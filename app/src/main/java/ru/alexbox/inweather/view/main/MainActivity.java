package ru.alexbox.inweather.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import ru.alexbox.inweather.presenter.MainPresenter;
import ru.alexbox.inweather.R;
import ru.alexbox.inweather.view.browser.BrowserActivity;
import ru.alexbox.inweather.view.chose.ChoseActivity;
import ru.alexbox.inweather.view.info.InfoFragment;

public class MainActivity extends AppCompatActivity {

    private TextView city_text_view;
    private TextView main_weather_view;

    private Button button_add;
    private Button button_settings;
    private Button button_favorite;

    private Button button_frag_info;
    private Button button_frag_main;
    private Button button_frag_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initButtons();

        MainPresenter.getInstance().setWeather(10);

        setData(MainPresenter.getInstance().getCity(),
                String.valueOf(MainPresenter.getInstance().getWeather()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setData(MainPresenter.getInstance().getCity(),
                String.valueOf(MainPresenter.getInstance().getWeather()));
    }

    private void initView() {
        city_text_view = findViewById(R.id.city_text_view);
        main_weather_view = findViewById(R.id.main_weather_view);
        button_add = findViewById(R.id.button_add);
        button_favorite = findViewById(R.id.button_favorite);
        button_settings = findViewById(R.id.button_settings);
        button_frag_info = findViewById(R.id.button_frag_1);
        button_frag_main = findViewById(R.id.button_frag_2);
        button_frag_map = findViewById(R.id.button_frag_3);
    }

    private void initButtons() {
        onButtonAdd();
        onCityPress();
        onFavoritePress();
        onSettingsPress();
        onFragInfo();
        onFragMain();
        onFragMap();
    }

    private void setData(String city, String weather) {
        city_text_view.setText(city);
        main_weather_view.setText(weather);
    }

    private void onButtonAdd() {
        button_add.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ChoseActivity.class);
            startActivity(intent);
        });
    }

    private void onCityPress() {
        if (city_text_view != null) city_text_view.setOnClickListener(e -> {
            Intent intent = new Intent(getApplicationContext(), BrowserActivity.class);
            startActivity(intent);
        });
    }

    private void onFavoritePress() {
        button_favorite.setOnClickListener(e -> {
        });
    }

    private void onSettingsPress() {
        button_settings.setOnClickListener(e -> {

        });
    }

    private void onFragInfo() {
        button_frag_info.setOnClickListener(e -> initFragment(InfoFragment.getInstance()));
        button_frag_info.setTextColor(getResources().getColor(R.color.color_button_activated));
    }

    private void onFragMain() {
        button_frag_main.setOnClickListener(e -> initFragment(MainFragment.getInstance()));
        button_frag_main.setTextColor(getResources().getColor(R.color.color_button_activated));
    }

    private void onFragMap() {
        button_frag_map.setOnClickListener(e -> {

        });
        button_frag_map.setTextColor(getResources().getColor(R.color.color_button_activated));
    }

    private void initFragment(Fragment yourFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_cont_main, yourFragment);
        fragmentTransaction.addToBackStack("to_stack");
        fragmentTransaction.commit();
    }
}