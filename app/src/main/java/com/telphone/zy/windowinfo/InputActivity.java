package com.telphone.zy.windowinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


public class InputActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);

		EditText editText =(EditText) findViewById(R.id.edit_name);
	}


}
