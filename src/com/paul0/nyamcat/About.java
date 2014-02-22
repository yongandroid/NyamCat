package com.paul0.nyamcat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.paul0.nyamcat.R;

public class About extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        // Backbutton
        ((Button)findViewById(R.id.back_button)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
