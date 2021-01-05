package ru.alexbox.inweather.presenter;

// Singleton
public final class MainPresenter {

    private static MainPresenter instance = null;
    private String city;
    private int weather;

    // Объект на который будут синхронизироваться потоки
    private static final Object syncObj = new Object();

    private MainPresenter() {
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

    public String getWeatherString() {
        return ((Integer) weather).toString();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWeather(int w) {
        this.weather = w;
    }
}
