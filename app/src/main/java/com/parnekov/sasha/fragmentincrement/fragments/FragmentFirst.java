package com.parnekov.sasha.fragmentincrement.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parnekov.sasha.fragmentincrement.MainActivity;
import com.parnekov.sasha.fragmentincrement.NumberModel;
import com.parnekov.sasha.fragmentincrement.R;
import com.parnekov.sasha.fragmentincrement.utils.NotificationsUtil;

import static com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil.KEY_FOR_INTENT_FROM_ONE_TO_TWO;
import static com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil.KEY_FOR_INTENT_TO_ONE;


public class FragmentFirst extends Fragment {
    Button mButtonAdd;
    Button mButtonSubtract;
    TextView mTextViewNumber, mTextViewGetNotification;
    NumberModel numberModel;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mButtonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(KEY_FOR_INTENT_FROM_ONE_TO_TWO, numberModel.getNumber());
                startActivity(intent);
            }
        });

        mTextViewGetNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationsUtil.showNotification(getActivity(), numberModel.getNumber(), KEY_FOR_INTENT_TO_ONE);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_layout, container, false);
        mButtonAdd = view.findViewById(R.id.button_add);
        mButtonSubtract = view.findViewById(R.id.button_subtract);
        mTextViewNumber = view.findViewById(R.id.tv_number);
        mTextViewGetNotification = view.findViewById(R.id.tv_get_notification);
        mButtonSubtract.setVisibility(View.GONE);
        numberModel = new NumberModel();
        numberModel.setNumber(1);
        mTextViewNumber.setText(String.valueOf(numberModel.getNumber()));

        return view;
    }


}
