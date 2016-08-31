package com.mergetest.peter.mergeproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

public class mUnityActivity extends UnityPlayerActivity {

    public static Activity mCurrentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCurrentActivity = this;
    }

    public void StartActivityNonStatic(final Activity activity){

        Intent intent = new Intent(activity, PageOneActivity.class);
        startActivity(intent);
    }
}
