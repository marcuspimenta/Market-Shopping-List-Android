package com.mviniciuspimenta.marketshoppinglist.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.mviniciuspimenta.marketshoppinglist.R;

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
        rootDrawerLayout = (DrawerLayout)findViewById(R.id.rootDrawerLayout);
        rootMenuRelativeLayout = (RelativeLayout) findViewById(R.id.rootMenuRelativeLayout);

        mDrawerToggle = new ActionBarDrawerToggle(this, rootDrawerLayout, R.string.app_name, R.string.app_name);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        rootDrawerLayout.setDrawerListener(mDrawerToggle);

        menuListView = (ListView) findViewById(R.id.menuListView);
        menuListView.setAdapter(new ArrayAdapter<String>(this, R.layout.adapter_menu_list, getResources().getStringArray(R.array.menu_array)));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
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
}
