package com.mergetest.peter.mergeproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageOneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_one);

        Button btBack = (Button)findViewById(R.id.bt_back);
        Button btNext = (Button)findViewById(R.id.bt_next);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PageOneActivity.this.finish();
            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageOneActivity.this, PageTwoActivity.class));
            }
        });
    }
}
