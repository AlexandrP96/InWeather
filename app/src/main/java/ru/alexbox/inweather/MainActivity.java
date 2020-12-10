package ru.alexbox.inweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    private void initView() {
        city_text_view = findViewById(R.id.city_text_view);
        main_weather_view = findViewById(R.id.main_weather_view);
        button_add = findViewById(R.id.button_add);
    }

    private void onButtonAdd() {
        button_add.setOnClickListener(v -> {
            city_text_view.setText("Moscow");
            main_weather_view.setText("+" + getTemp() + " ");
        });
    }

    private int getTemp() {
        return 10;
    }

    // Так лучше не делать из за условий и множества кнопок
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public void onClick(View view) {
        Toast.makeText(this, "Переход", Toast.LENGTH_SHORT).show();
    }
}