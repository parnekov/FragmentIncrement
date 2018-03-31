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
    Button mButtonAdd, mButtonSubtract;
    TextView mTextViewNumber, mTextViewGetNotification;
    NumberModel numberModel;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentsUtil.moveTo(getActivity(), numberModel.getNumber(), KEY_FOR_INTENT_TO_THIRD_FRAGMENT);
            }
        });

        mButtonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentsUtil.moveTo(getActivity(), numberModel.getNumber(), KEY_FOR_INTENT_TO_FIRST_FRAGMENT);
            }
        });

        mTextViewGetNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationsUtil.showNotification(getActivity(), numberModel.getNumber(), KEY_FOR_INTENT_TO_SECOND_FRAGMENT);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout, container, false);
        mButtonAdd = view.findViewById(R.id.button_add);
        mButtonSubtract = view.findViewById(R.id.button_subtract);
        mTextViewNumber = view.findViewById(R.id.tv_number);
        mTextViewGetNotification = view.findViewById(R.id.tv_get_notification);
        numberModel = new NumberModel();
        numberModel.setNumber(2);
        mTextViewNumber.setText(String.valueOf(numberModel.getNumber()));
        return view;
    }
}
