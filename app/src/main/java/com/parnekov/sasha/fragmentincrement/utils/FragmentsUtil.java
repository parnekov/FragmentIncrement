package com.parnekov.sasha.fragmentincrement.utils;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.parnekov.sasha.fragmentincrement.R;
import com.parnekov.sasha.fragmentincrement.fragments.FragmentFirst;
import com.parnekov.sasha.fragmentincrement.fragments.FragmentSecond;
import com.parnekov.sasha.fragmentincrement.fragments.FragmentThird;

public final class FragmentsUtil {
    public static final String KEY_FOR_INTENT_FROM_ONE_TO_TWO = "INTENT12";
    public static final String KEY_FOR_INTENT_FROM_TWO_TO_THREE = "INTENT23";
    public static final String KEY_FOR_INTENT_FROM_THREE_TO_TWO = "INTENT32";
    public static final String KEY_FOR_INTENT_FROM_TWO_TO_ONE = "INTENT21";
    public static final String KEY_FOR_INTENT_TO_ONE = "INTENT1";

    public static void getFragment(Activity activity, Fragment fragment){
         activity.getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                 fragment).commit();
    }

    public static void getFragments(Intent intent, Activity activity){
        if (intent.getExtras() == null || intent.hasExtra(KEY_FOR_INTENT_TO_ONE) || intent.hasExtra(KEY_FOR_INTENT_FROM_TWO_TO_ONE)) {
            getFragment(activity, new FragmentFirst());
        }

        if (intent.hasExtra(KEY_FOR_INTENT_FROM_ONE_TO_TWO) | intent.hasExtra(KEY_FOR_INTENT_FROM_THREE_TO_TWO)) {
            getFragment(activity, new FragmentSecond());
        }

        if (intent.hasExtra(KEY_FOR_INTENT_FROM_TWO_TO_THREE)) {
            getFragment(activity, new FragmentThird());
        }
    }
}
