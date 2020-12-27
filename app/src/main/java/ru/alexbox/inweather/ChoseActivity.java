package ru.alexbox.inweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ChoseActivity extends AppCompatActivity {

    private Button button_chose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);

        initView();
        initSearch();
    }

    private void initView() {
        button_chose = findViewById(R.id.button_chose);
    }

    private void initSearch() {
        button_chose.setOnClickListener(e -> {
            

            finish();
        });
    }
}