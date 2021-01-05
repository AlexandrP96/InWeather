package ru.alexbox.inweather.view.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.alexbox.inweather.R;
import ru.alexbox.inweather.presenter.FragmentPresenter;

public class InfoFragment extends Fragment {

    private TextView min_temp_value;
    private TextView max_temp_value;
    private TextView wind_info_view;
    private TextView wet_view_value;
    private TextView sunset_info_view;

    public InfoFragment() {

    }

    public static InfoFragment getInstance() {
        return new InfoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        min_temp_value = view.findViewById(R.id.min_temp_value);
        max_temp_value = view.findViewById(R.id.max_temp_value);
        wind_info_view = view.findViewById(R.id.wind_info_view);
        wet_view_value = view.findViewById(R.id.wet_view_value);
        sunset_info_view = view.findViewById(R.id.sunset_info_view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
    }

    private void setData() {
        min_temp_value.setText(FragmentPresenter.getInstance().getData());
        max_temp_value.setText(FragmentPresenter.getInstance().getData());
        wind_info_view.setText(FragmentPresenter.getInstance().getData());
        wet_view_value.setText(FragmentPresenter.getInstance().getData());
        sunset_info_view.setText(FragmentPresenter.getInstance().getData());
    }
}