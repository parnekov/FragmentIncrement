package com.parnekov.sasha.fragmentincrement.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parnekov.sasha.fragmentincrement.NumberModel;
import com.parnekov.sasha.fragmentincrement.R;
import com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil;
import com.parnekov.sasha.fragmentincrement.utils.NotificationsUtil;

import static com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil.KEY_FOR_INTENT_TO_FIRST_FRAGMENT;
import static com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil.KEY_FOR_INTENT_TO_SECOND_FRAGMENT;
import static com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil.KEY_FOR_INTENT_TO_THIRD_FRAGMENT;


public class FragmentSecond extends android.support.v4.app.Fragment {

    private Button mButtonPlus;
    private Button mButtonMinus;
    private TextView mTextView, mTextViewGetNot;
    private NumberModel numberModel;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentsUtil.moveTo(getActivity(), numberModel.getNumber(), KEY_FOR_INTENT_TO_THIRD_FRAGMENT);
            }
        });

        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentsUtil.moveTo(getActivity(), numberModel.getNumber(), KEY_FOR_INTENT_TO_FIRST_FRAGMENT);
            }
        });

        mTextViewGetNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationsUtil.showNotification(getActivity(), numberModel.getNumber(), KEY_FOR_INTENT_TO_SECOND_FRAGMENT);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);
        mButtonPlus = view.findViewById(R.id.button_add);
        mButtonMinus = view.findViewById(R.id.button_subtract);
        mTextView = view.findViewById(R.id.tv_number);
        mTextViewGetNot = view.findViewById(R.id.tv_get_notification);
        numberModel = new NumberModel();
        numberModel.setNumber(2);
        mTextView.setText(String.valueOf(numberModel.getNumber()));
        return view;
    }
}
