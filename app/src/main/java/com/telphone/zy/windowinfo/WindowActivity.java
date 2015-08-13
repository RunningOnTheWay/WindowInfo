package com.telphone.zy.windowinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;


public class WindowActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

	private SeekBar seekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_window);
		
		
		////////////////////////////////
		//操作Activity内部底层的东西
		View decorView = getWindow().getDecorView();
		ViewGroup group=(ViewGroup) decorView;
		ImageView imageView = new ImageView(this);
		imageView.setImageResource(R.mipmap.ic_launcher);
		group.addView(imageView,200,200);

		//screen light
		seekBar = (SeekBar) findViewById(R.id.seek_bar);

		seekBar.setOnSeekBarChangeListener(this);


		/////////////////////////////////////////////////////////

		//alpha
		seekBar = (SeekBar) findViewById(R.id.seek_bar_alpha);

		seekBar.setOnSeekBarChangeListener(this);
		
		//y
		seekBar = (SeekBar) findViewById(R.id.seek_bar_y);

		seekBar.setOnSeekBarChangeListener(this);


	}


	/**
	 * seekBar 进度调整的时候回调
	 *
	 * @param seekBar
	 * @param progress 进度
	 * @param fromUser 是否是用户手指的操作
	 */
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

		// 获取Activity显示在那个Window上
		Window window = getWindow();

		//1. 获取Activity 旧的Window 属性 来修改屏幕亮度

		WindowManager.LayoutParams attributes = window.getAttributes();
		
		switch (seekBar.getId()) {
			case R.id.seek_bar:
				//1.1 屏幕亮度
				attributes.screenBrightness = (1f * progress) / seekBar.getMax();
				break;
			case R.id.seek_bar_alpha:
				attributes.alpha = (1f * progress) / seekBar.getMax();
				break;
			case R.id.seek_bar_y:
				attributes.gravity= Gravity.TOP|Gravity.LEFT;
				attributes.width= WindowManager.LayoutParams.WRAP_CONTENT;
				attributes.x= progress ;
				break;
		}

		//设置当前window 的属性 
		window.setAttributes(attributes);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

	}
}
