package com.telphone.zy.windowinfo;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class HomeTest1Activity extends AppCompatActivity {

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_test1);

		FrameLayout frameLayout = (FrameLayout) this.getWindow().getDecorView();
		LinearLayout linearLayout = (LinearLayout) frameLayout.getChildAt(0);
		
		
		ViewGroup.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				30
		);
		
		LinearLayout linearLayout1 = new LinearLayout(this);
		linearLayout1.setLayoutParams(layoutParams1);
		linearLayout1.setBackgroundColor(Color.GREEN);

		LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT
		);
		TextView textView=new TextView(this);
		textView.setText("hello world ");
		textView.setLayoutParams(layoutParams2);

		linearLayout1.addView(textView);
		
		linearLayout.addView(linearLayout1,0);
		
	}

	public void btnShowDialog(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		AlertDialog dialog = builder.create();
		dialog.setTitle("发表评论");
		dialog.setMessage("亲，记得点赞 + 评论啊");
		dialog.show();
		WindowManager m = getWindowManager();
		//为获取屏幕宽、高  
		Display d = m.getDefaultDisplay();
		//获取对话框当前的参数值 
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.height = (int) (d.getHeight()*0.3);
		lp.width = (int) (d.getWidth());
		dialog.getWindow().setAttributes(lp);

	}
	
}
