package com.mviniciuspimenta.marketshoppinglist.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.mviniciuspimenta.marketshoppinglist.R;
import com.mviniciuspimenta.marketshoppinglist.view.fragment.CategoriesFragment;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 14/09/15 19:20
 */
public class MenuActivity extends AppCompatActivity implements IActivity{

    private DrawerLayout rootDrawerLayout;
    private RelativeLayout rootMenuRelativeLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private ListView menuListView;

    private ImageView logoImageView;
    private CategoriesFragment categoriesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        settingsAttributes();
        settingsView();
    }

    @Override
    public void settingsAttributes() {
    }

    @Override
    public void settingsView() {
        logoImageView = (ImageView) findViewById(R.id.logoImageView);

        categoriesFragment = (CategoriesFragment) getSupportFragmentManager().findFragmentById(R.id.categoriesFragment);

        rootDrawerLayout = (DrawerLayout)findViewById(R.id.rootDrawerLayout);
        rootMenuRelativeLayout = (RelativeLayout) findViewById(R.id.rootMenuRelativeLayout);

        mDrawerToggle = new ActionBarDrawerToggle(this, rootDrawerLayout, R.string.app_name, R.string.app_name);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        rootDrawerLayout.setDrawerListener(mDrawerToggle);

        menuListView = (ListView) findViewById(R.id.menuListView);
        menuListView.setAdapter(new ArrayAdapter<String>(this, R.layout.adapter_menu_list, getResources().getStringArray(R.array.menu_array)));
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                settingsMenuVisibility(position);

                rootDrawerLayout.closeDrawer(rootMenuRelativeLayout);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        settingsMenuVisibility(-1);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void settingsMenuVisibility(int itemPosition) {
        switch (itemPosition){
            case 0:
                logoImageView.setVisibility(View.GONE);
                categoriesFragment.getView().setVisibility(View.VISIBLE);
                break;

            default:
                logoImageView.setVisibility(View.VISIBLE);
                categoriesFragment.getView().setVisibility(View.GONE);
                break;
        }
    }
}
