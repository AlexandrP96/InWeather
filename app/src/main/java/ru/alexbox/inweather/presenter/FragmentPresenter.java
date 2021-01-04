package ru.alexbox.inweather.presenter;

import ru.alexbox.inweather.model.DataModel;

public class FragmentPresenter {
    // По идее будем брать инфу для фрагментов отсюда, но это еще не точно
    private static FragmentPresenter instance = null;
    private static final Object syncObj = new Object();

    private FragmentPresenter() {

    }

    public static FragmentPresenter getInstance() {
        synchronized (syncObj) {
            if (instance == null) {
                instance = new FragmentPresenter();
            }
        }
        return instance;
    }

    public String getData() {
        DataModel dataModel = new DataModel();
        return dataModel.getData();
    }
}
