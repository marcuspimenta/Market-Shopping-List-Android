package com.mviniciuspimenta.marketshoppinglist.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mviniciuspimenta.marketshoppinglist.R;
import com.mviniciuspimenta.marketshoppinglist.database.CategoryDB;
import com.mviniciuspimenta.marketshoppinglist.view.adapter.CategoryAdapter;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 15/09/15 17:21
 */
public class CategoriesFragment extends Fragment implements SettingsFragment{

    private ListView categoriesListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        settingsAttributes();
        settingsView(view);

        return view;
    }

    @Override
    public void settingsAttributes() {

    }

    @Override
    public void settingsView(View view) {
        categoriesListView = (ListView) view.findViewById(R.id.categoriesListView);
        categoriesListView.setAdapter(new CategoryAdapter(getActivity(), CategoryDB.getInstance(getActivity()).selectAll()));
    }
}
