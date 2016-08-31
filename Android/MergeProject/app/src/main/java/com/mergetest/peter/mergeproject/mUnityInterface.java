package com.mergetest.peter.mergeproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

import com.unity3d.player.UnityPlayer;

/**
 * Created by apple on 2016/8/29.
 */
public class mUnityInterface {

    // TODO Unity Call Funtion
    public static void Show (final String title, final String content){

        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {

                AlertDialog.Builder builder = new AlertDialog.Builder(UnityPlayer.currentActivity);
                builder.setTitle(title).setMessage(content).setCancelable(false).setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // TODO Android Call Function
                                try {
                                    UnityPlayer.UnitySendMessage("MyAndroid","getMessage","this is Android!");
                                } catch (Exception e){
                                    Log.d("Unity", "UnitySendMessage failed" + e.getMessage());
                                }
                            }
                        });
                builder.show();
                        }
            });
    }
}
