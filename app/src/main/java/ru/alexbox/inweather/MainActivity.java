package ru.alexbox.inweather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView city_text_view;
    private TextView main_weather_view;

    private Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        onButtonAdd();

        MainPresenter.getInstance().setWeather(10);
        MainPresenter.getInstance().setCity("Moscow");

        setData(MainPresenter.getInstance().getCity(),
                String.valueOf(MainPresenter.getInstance().getWeather()));
    }
    
    private void initView() {
        city_text_view = findViewById(R.id.city_text_view);
        main_weather_view = findViewById(R.id.main_weather_view);
        button_add = findViewById(R.id.button_add);
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

}