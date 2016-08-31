package com.mergetest.peter.mergeproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageTwoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        Button btBack = (Button)findViewById(R.id.bt_back);
        Button btUnity = (Button)findViewById(R.id.bt_unity);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PageTwoActivity.this.finish();
            }
        });
        btUnity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageTwoActivity.this, mUnityActivity.class));
            }
        });
    }
}
