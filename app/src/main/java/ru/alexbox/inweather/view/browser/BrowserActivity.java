package ru.alexbox.inweather.view.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ru.alexbox.inweather.presenter.MainPresenter;
import ru.alexbox.inweather.R;

public class BrowserActivity extends AppCompatActivity {

    private WebView browser_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        browser_view = findViewById(R.id.browser_view);
        initBrowser();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initBrowser() {
        WebSettings settings = browser_view.getSettings();
        settings.setJavaScriptEnabled(true);
        browser_view.loadUrl("https://ru.wikipedia.org/wiki/" + MainPresenter.getInstance().getCity());
        browser_view.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (browser_view.canGoBack())
            browser_view.goBack();
        else
            super.onBackPressed();
    }
}