package ru.alexbox.inweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String INFO = "INFO_DEVELOPER";
    private static final String TEMP = "SAVED_TEMP";
    private static final String CITY = "SAVED_CITY";

    private TextView city_text_view;
    private TextView main_weather_view;

    private Button button_add;

    private int weather = 0;
    private String city = "City";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainPresenter presenter = MainPresenter.getInstance();

        initView();
        setData(city, weather = presenter.getWeather());
        onButtonAdd();
    }

    private void initView() {
        city_text_view = findViewById(R.id.city_text_view);
        main_weather_view = findViewById(R.id.main_weather_view);
        button_add = findViewById(R.id.button_add);
        makeLog("Вызван метод initView");
    }

    private void setData(String city, int weather) {
        city_text_view.setText(city);
        main_weather_view.setText(weather);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        // Сохранение
        super.onSaveInstanceState(outState, outPersistentState);

//        outPersistentState.putInt(TEMP, weather);
//        outPersistentState.putString(CITY, city);
//        makeLog("Сохранение данных в onRestoreInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // Восстановление
        super.onRestoreInstanceState(savedInstanceState);

//        weather = (int) savedInstanceState.get(TEMP);
//        city = (String) savedInstanceState.get(CITY);
//        setData(city, weather);
    }

    private void onButtonAdd() {
        button_add.setOnClickListener(v -> {
            city = "Moscow";
            city_text_view.setText(city);
        });
    }

    private void makeLog(String message) {
        Log.d(INFO, message);
    }
}