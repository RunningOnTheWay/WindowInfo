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
		//����Activity�ڲ��ײ�Ķ���
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
	 * seekBar ���ȵ�����ʱ��ص�
	 *
	 * @param seekBar
	 * @param progress ����
	 * @param fromUser �Ƿ����û���ָ�Ĳ���
	 */
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

		// ��ȡActivity��ʾ���Ǹ�Window��
		Window window = getWindow();

		//1. ��ȡActivity �ɵ�Window ���� ���޸���Ļ����

		WindowManager.LayoutParams attributes = window.getAttributes();
		
		switch (seekBar.getId()) {
			case R.id.seek_bar:
				//1.1 ��Ļ����
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

		//���õ�ǰwindow ������ 
		window.setAttributes(attributes);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

	}
}
