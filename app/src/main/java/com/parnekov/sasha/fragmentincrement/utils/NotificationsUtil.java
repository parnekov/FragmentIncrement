package com.parnekov.sasha.fragmentincrement.utils;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.parnekov.sasha.fragmentincrement.MainActivity;
import com.parnekov.sasha.fragmentincrement.R;

import static com.parnekov.sasha.fragmentincrement.utils.FragmentsUtil.KEY_FOR_INTENT_TO_FIRST_FRAGMENT;

public final class NotificationsUtil {
    private static final int PENDING_INTENT_ID = 3417;

    public static void showNotification(Context context, int number, String extra) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        int notifyID = number;
        String CHANNEL_ID = "my_channel_01";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "chanel_name";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("You Create a Notification")
                .setContentText("Notification " + number)
                .setFullScreenIntent(contentIntent(context, number, extra), false);

        notificationManager.notify(notifyID, mBuilder.build());
    }

    private static PendingIntent contentIntent(Context context, int numberFragment, String extra) {
        Intent startActivityIntent = new Intent(context, MainActivity.class);
        if (extra == null) {
            extra = KEY_FOR_INTENT_TO_FIRST_FRAGMENT;
        }
        startActivityIntent.putExtra(extra, numberFragment);
        return PendingIntent.getActivity(context, PENDING_INTENT_ID, startActivityIntent, numberFragment);
    }
}
