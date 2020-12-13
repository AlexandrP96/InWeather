package ru.alexbox.inweather;

// Singleton
public final class MainPresenter {

    private static MainPresenter instance = null;
    private final int weather;

    // Объект на который будут синхронизироваться потоки
    private static final Object syncObj = new Object();

    private MainPresenter() {
        weather = 10;
    }

    public static MainPresenter getInstance() {
        synchronized (syncObj) {
            if (instance == null) {
                instance = new MainPresenter();
            }
        }
        return instance;
    }

    public int getWeatherFromInternet() {
        int weather_internet = 10;
        synchronized (syncObj) {
            // Будущий метод для получения данных о погоде через интернет

        }
        return weather_internet;
    }

    public int getWeather() {
        return weather;
    }
}
