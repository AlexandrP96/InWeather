package ru.alexbox.inweather.view.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.alexbox.inweather.R;
import ru.alexbox.inweather.presenter.MainPresenter;
import ru.alexbox.inweather.view.browser.BrowserActivity;

public class MainFragment extends Fragment {

    private TextView city_text_view;
    private TextView main_weather_view;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        city_text_view = view.findViewById(R.id.city_text_view);
        main_weather_view = view.findViewById(R.id.main_weather_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
        onCityPress();
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }

    private void setData() {
        city_text_view.setText(MainPresenter.getInstance().getCity());
        main_weather_view.setText(MainPresenter.getInstance().getWeatherString());
    }

    private void onCityPress() {
        if (city_text_view != null) city_text_view.setOnClickListener(e -> {
            Intent intent = new Intent(getContext(), BrowserActivity.class);
            startActivity(intent);
        });
    }
}