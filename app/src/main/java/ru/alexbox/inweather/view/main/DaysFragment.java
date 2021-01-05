package ru.alexbox.inweather.view.main;

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

public class DaysFragment extends Fragment {

    private TextView text_view_one;
    private TextView text_view_two;
    private TextView text_view_three;
    private TextView text_view_four;
    private TextView text_view_five;
    private TextView text_view_six;
    private TextView text_view_seven;

    public DaysFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_days, container, false);
        text_view_one = layout.findViewById(R.id.temp_one_view);
        text_view_two = layout.findViewById(R.id.temp_two_view);
        text_view_three = layout.findViewById(R.id.temp_three_view);
        text_view_four = layout.findViewById(R.id.temp_four_view);
        text_view_five = layout.findViewById(R.id.temp_five_view);
        text_view_six = layout.findViewById(R.id.temp_six_view);
        text_view_seven = layout.findViewById(R.id.temp_seven_view);

        return layout;
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

    public static DaysFragment getInstance() {
        return new DaysFragment();
    }

    public void setData() {
        // Заменить эту бодягю на цикл!
        text_view_one.setText(FragmentPresenter.getInstance().getData());
        text_view_two.setText(FragmentPresenter.getInstance().getData());
        text_view_three.setText(FragmentPresenter.getInstance().getData());
        text_view_four.setText(FragmentPresenter.getInstance().getData());
        text_view_five.setText(FragmentPresenter.getInstance().getData());
        text_view_six.setText(FragmentPresenter.getInstance().getData());
        text_view_seven.setText(FragmentPresenter.getInstance().getData());
    }
}