package ru.alexbox.inweather.view.chose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import ru.alexbox.inweather.presenter.MainPresenter;
import ru.alexbox.inweather.R;

public class ChoseActivity extends AppCompatActivity {

    private Button button_chose;
    private EditText chose_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);

        initView();
        initSearch();
    }

    private void initView() {
        button_chose = findViewById(R.id.button_chose);
        chose_edit_text = findViewById(R.id.chose_edit_text);
    }

    private void initSearch() {
        button_chose.setOnClickListener(e -> {
            MainPresenter.getInstance().setCity(chose_edit_text.getText().toString());
            finish();
        });
    }
}