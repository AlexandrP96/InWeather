package ru.alexbox.inweather.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import ru.alexbox.inweather.IConstants;
import ru.alexbox.inweather.MainPresenter;
import ru.alexbox.inweather.R;
import ru.alexbox.inweather.view.browser.BrowserActivity;
import ru.alexbox.inweather.view.chose.ChoseActivity;

public class MainActivity extends AppCompatActivity implements IConstants {

    private TextView city_text_view;
    private TextView main_weather_view;

    private Button button_add;
    private Button button_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        onButtonAdd();
        onButtonInfo();
        onCityPress();

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
        button_info = findViewById(R.id.button_info);
    }

    private void setData(String city, String weather) {
        city_text_view.setText(city);
        main_weather_view.setText(weather);
    }

    private void onButtonAdd() {
        button_add.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ChoseActivity.class);
            startActivityForResult(intent, INT_CITY);
        });
    }

    private void onCityPress() {
        city_text_view.setOnClickListener(e -> {
            Intent intent = new Intent(getApplicationContext(), BrowserActivity.class);
            startActivity(intent);
        });
    }

    private void onButtonInfo() {
        button_info.setOnClickListener(e -> city_text_view.setText("Moscow"));
    }

}