package com.parnekov.sasha.fragmentincrement.utils;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.parnekov.sasha.fragmentincrement.MainActivity;
import com.parnekov.sasha.fragmentincrement.R;
import com.parnekov.sasha.fragmentincrement.fragments.FragmentFirst;
import com.parnekov.sasha.fragmentincrement.fragments.FragmentSecond;
import com.parnekov.sasha.fragmentincrement.fragments.FragmentThird;

public final class FragmentsUtil {
    public static final String KEY_FOR_INTENT_TO_FIRST_FRAGMENT = "INTENT1";
    public static final String KEY_FOR_INTENT_TO_SECOND_FRAGMENT = "INTENT12";
    public static final String KEY_FOR_INTENT_TO_THIRD_FRAGMENT = "INTENT23";

    public static void getFragment(AppCompatActivity activity, android.support.v4.app.Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                fragment).commit();
    }

    public static void getFragments(Intent intent, AppCompatActivity activity) {
        if (intent.getExtras() == null || intent.hasExtra(KEY_FOR_INTENT_TO_FIRST_FRAGMENT)) {
            getFragment(activity, new FragmentFirst());
        }

        if (intent.hasExtra(KEY_FOR_INTENT_TO_SECOND_FRAGMENT)) {
            getFragment(activity, new FragmentSecond());
        }

        if (intent.hasExtra(KEY_FOR_INTENT_TO_THIRD_FRAGMENT)) {
            getFragment(activity, new FragmentThird());
        }
    }

    public static void moveTo(Context activity, int getNumber, String keyExtra) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra(keyExtra, getNumber);
        activity.startActivity(intent);
    }
}
