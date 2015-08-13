package com.telphone.zy.windowinfo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Field;


/**
 * 对话框样式的Activity 
 */
public class DiaLogStyleActivity extends FragmentActivity  {

	private EditText[] editTexts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dia_log_style);
		Log.e("hehe","hehe");
		editTexts = new EditText[6];
		//提出来的效率高，反序列更高
		int length = editTexts.length;
		//批量找相同格式的id   利用反射来查找R.id. 内部多个Id数值
		Class<R.id> idClass = R.id.class;
		
		for (int i = 0; i < length; i++) {
			try {
				Field field = idClass.getDeclaredField("dialog_edit" + i);
				int rId = field.getInt(idClass);
				editTexts[i] =(EditText) findViewById(rId);

				PasswordWatcher watcher = new PasswordWatcher(i);
				editTexts[i].addTextChangedListener(watcher);
				editTexts[i].setOnKeyListener(watcher);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 用来检查输入框的输入的 当输入了一个数字之后再次输入就进入到下一个输入框
	 */
	private class  PasswordWatcher implements TextWatcher,View.OnKeyListener{

		private  int currentIndex;
		
		private EditText editText;

		public PasswordWatcher(int currentIndex) {
			this.currentIndex = currentIndex;
			editText=editTexts[currentIndex];
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		Log.e("beforeChange","....."+s+"...:"+count);
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {

			Log.e("afterChange","....."+s+"...:"+count);
		}

		/**
		 * 输入完成之后
		 * @param s
		 */
		@Override
		public void afterTextChanged(Editable s) {

			String s1 = s.toString();
			if (s1.length()>0){
				int next = currentIndex + 1;
				if (next<editTexts.length){
					EditText ed =editTexts[next];

					if (ed != null) {
						ed.requestFocus();
					}
				}
			}
		
		}

		/**
		 * 再控件中 输入键盘事件的时候调用的额方法
		 * @param v 控件
		 * @param keyCode  点击的按键
		 * @param event  事件
		 * @return boolean 是否消费
		 */
		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			boolean ret = false;
			int action = event.getAction();
			if (action==KeyEvent.ACTION_DOWN){
				// todo 通过KeyCode来判断按键
				Log.d("key","..."+KeyEvent.KEYCODE_DEL);
				if (keyCode==KeyEvent.KEYCODE_FORWARD_DEL);
			}
			return ret;
		}
	}

	
}
