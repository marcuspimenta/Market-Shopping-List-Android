package com.mviniciuspimenta.marketshoppinglist.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mviniciuspimenta.marketshoppinglist.R;
import com.mviniciuspimenta.marketshoppinglist.model.Category;

import java.util.List;

/**
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17/09/15 16:57
 */
public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, List<Category> objects) {
        super(context, 0, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_category, null);

        if(position % 2 == 1){
            convertView.setBackgroundColor(getContext().getResources().getColor(R.color.white));
        }

        Category item = getItem(position);

        TextView categoryTextView = (TextView) convertView.findViewById(R.id.categoryTextView);
        categoryTextView.setText(item.getName());

        return convertView;
    }
}
