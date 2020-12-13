package ru.alexbox.inweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String INFO = "INFO_DEVELOPER";

    private TextView city_text_view;
    private TextView main_weather_view;

    private Button button_add;

    private String city = "City";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setData(city, String.valueOf(MainPresenter.getInstance().getWeather()));
        onButtonAdd();
    }

    private void initView() {
        city_text_view = findViewById(R.id.city_text_view);
        main_weather_view = findViewById(R.id.main_weather_view);
        button_add = findViewById(R.id.button_add);
        makeLog("Вызван метод initView");
    }

    private void setData(String city, String weather) {
        city_text_view.setText(city);
        main_weather_view.setText(weather);
    }

    private void onButtonAdd() {
        button_add.setOnClickListener(v -> {
            city = "Moscow";
            city_text_view.setText(city);
        });
        makeLog("Вызван метод onButtonAdd");
    }

    private void makeLog(String message) {
        Log.d(INFO, message);
    }
}