package com.example.fujitsu.mojprojekat.activity.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fujitsu.mojprojekat.R;
import com.example.fujitsu.mojprojekat.activity.providers.CategoryProvider;
import com.example.fujitsu.mojprojekat.activity.providers.MealProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class DetailFragment extends Fragment {

    private int position = 0;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_detail, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is;
        try {
            is = getActivity().getAssets().open(MealProvider.getMealById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(MealProvider.getMealById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(MealProvider.getMealById(position).getDescription());

        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)MealProvider.getMealById(position).getCategory().getId());

        TextView tvIngredients = (TextView) getView().findViewById(R.id.tv_ingredients);
        tvIngredients.setText(MealProvider.getMealById(position).getIngredients());

        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_calories);
        tvCalories.setText(MealProvider.getMealById(position).getCalories() + " Kcal");

        TextView tvPrice = (TextView) getView().findViewById(R.id.tv_price);
        tvPrice.setText(MealProvider.getMealById(position).getPrice() + " RSD");

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);
    }

    public void setContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }

    public void updateContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "updateContent() sets position to " + position);

        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is;
        try {
            is = getActivity().getAssets().open(MealProvider.getMealById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(MealProvider.getMealById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(MealProvider.getMealById(position).getDescription());

        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)MealProvider.getMealById(position).getCategory().getId());

        TextView tvIngredients = (TextView) getView().findViewById(R.id.tv_ingredients);
        tvIngredients.setText(MealProvider.getMealById(position).getIngredients());

        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_calories);
        tvCalories.setText(MealProvider.getMealById(position).getCalories() + " Kcal");

        TextView tvPrice = (TextView) getView().findViewById(R.id.tv_price);
        tvPrice.setText(MealProvider.getMealById(position).getPrice() + " RSD");

    }
}
