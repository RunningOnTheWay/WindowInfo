package com.telphone.zy.windowinfo;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created from com.telphone.zy.windowinfo.
 * User ：${Yan}[ZY] on 2015/8/10 0010 11:25
 * Email ：530412159@qq.com
 */

/**
 * 悬浮窗 拖拽处理
 */
public class FloatTouchListener implements View.OnTouchListener ,View.OnClickListener{

	private float lastX;
	private float lastY;

	@Override
	public boolean onTouch(View v, MotionEvent event) {

		boolean ret = false;

		int action = event.getAction();

		switch (action) {

			case MotionEvent.ACTION_DOWN:
				// 事件中如果ActionDown 返回true 那莫后续的Move 和Up  才会传递给这个接口方法
				// 如果返回false 那莫move 和 up 则不会传给这个方法。
				lastX = event.getRawX();
				lastY = event.getRawY();
				ret = false;
				break;
			case MotionEvent.ACTION_MOVE:
				float currentX = event.getRawX();
				float currentY = event.getRawY();


				float cx = currentX - lastX;
				float cy = currentY - lastY;

				// 注意!!!!!!!   得到偏移量之后必须把当前位置  设置给 lastX 和lastY 
				// 因为这样才可以进行下一次的计算
				lastX=currentX;
				lastY=currentY;
				
				ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
				if (layoutParams instanceof WindowManager.LayoutParams) {
					WindowManager.LayoutParams lp = (WindowManager.LayoutParams) layoutParams;
					//更新LayoutParams 的 x y

					lp.x=lp.x+(int)cx;
					lp.y=lp.y+(int)cy;

					// 直接修改 LayoutParams 的数值是不能直接更新UI的 使用WindowManager 来更新

					WindowManager manager=(WindowManager) v.getContext().getSystemService(Context.WINDOW_SERVICE);

					// 主线程  更新UI
					manager.updateViewLayout(v,lp);
				}
				
				break;

			case MotionEvent.ACTION_UP:
				
				
				break;
		}
		return ret;
	}

	@Override
	public void onClick(View v) {
		Context context = v.getContext();
		Intent intent = new Intent(context, TestActivity.class);
		
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
		
		context.startActivity(intent);
		
	}
}
