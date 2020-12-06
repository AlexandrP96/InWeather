package ru.alexbox.inweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView city_text_view;

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
        button_add = findViewById(R.id.button_add);
    }

    private void onButtonAdd() {
        button_add.setOnClickListener(v -> city_text_view.setText("Moscow"));
    }
}