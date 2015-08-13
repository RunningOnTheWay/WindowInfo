package com.telphone.zy.windowinfo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Home1Activity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home1);
		FrameLayout frameLayout = (FrameLayout) this.getWindow().getDecorView();
//		LinearLayout linearLayout = (LinearLayout) frameLayout.getChildAt(0);
		
		
		LinearLayout linearLayout1 = new LinearLayout(this);
		ViewGroup.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				200
		);

		linearLayout1.setLayoutParams(layoutParams1);
		linearLayout1.setBackgroundColor(Color.GREEN);

		LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT
		);
		
		TextView textView=new TextView(this);
		textView.setText("hello world ");
		layoutParams2.setMargins(0, getStatusBarHeight(), 0, 0);
		textView.setLayoutParams(layoutParams2);
		
		linearLayout1.addView(textView);
		
		frameLayout.addView(linearLayout1);
		
	}

	public int getStatusBarHeight() {
		int result = 0;
		int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = getResources().getDimensionPixelSize(resourceId);
		}
		return result;
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
