package com.telphone.zy.windowinfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

	private static ImageView imageView;
	private WindowManager windowManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//1.获取windowManager 来进行窗口的管理
		windowManager = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
		
		//2.进行悬浮窗的添加

		//2.1 创建要添加的悬浮窗  实际上就是UI控件
		if (imageView == null) {

			imageView = new ImageView(this.getApplicationContext());
			imageView.setImageResource(R.mipmap.ic_launcher);
			//2.2 添加悬浮窗

			//2.2.1 设置悬浮窗的参数 必须使用WindowManager.LayoutParams()
			WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
			lp.width=WindowManager.LayoutParams.WRAP_CONTENT;
			lp.height= WindowManager.LayoutParams.WRAP_CONTENT;
			// 控件在中间的部分
			lp.gravity= Gravity.CENTER;
			//参考gravity为基准，向下移动20px
			lp.y=20; lp.x=-20;
			// 悬浮窗的背景 默认是不透明的 （黑色） OPAQUE
			lp.format= PixelFormat.TRANSPARENT;

			//窗口的类型   需要接收事件 窗口类型必须设置为   TYPE_SYSTEM_ALERT   需要悬浮必须设置为  TYPE_SYSTEM_OVERLAY
			lp.type=WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY|WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;

			lp.flags=WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;


			windowManager.addView(imageView, lp);

			FloatTouchListener listener = new FloatTouchListener();
			imageView.setOnTouchListener(listener);
			
			imageView.setOnClickListener(listener);
		}
		
	
		
	}

	@Override
	protected void onDestroy() {
		//删除添加过的悬浮窗
//		windowManager.removeViewImmediate(imageView);
		
		super.onDestroy();
	}

	public void btnTest(View view) {
		Intent intent = new Intent(this, TestActivity.class);
		startActivity(intent);
	}
}
