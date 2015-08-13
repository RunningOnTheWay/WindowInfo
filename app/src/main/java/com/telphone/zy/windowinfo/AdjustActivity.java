package com.telphone.zy.windowinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;


public class AdjustActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adjust);
		ListView listView=(ListView) findViewById(R.id.common_list);
		LinkedList strings = new LinkedList();
		for (int i = 0; i < 20; i++) {
			strings.add("java -  "+i);
		}
		ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, strings);
		listView.setAdapter(adapter);
	}


	public void btnCommon(View view) {
		// V7 包中的AlertDialog
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		builder.setTitle("发表评论");
//		builder.setMessage("亲 谢谢你的评论");
//		builder.show();
		
		// 使用Aleart样式的Activity
		Intent intent = new Intent(this, DiaLogStyleActivity.class);
		startActivity(intent);

	}
}
