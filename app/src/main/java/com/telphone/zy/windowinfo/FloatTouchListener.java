package com.telphone.zy.windowinfo;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created from com.telphone.zy.windowinfo.
 * User ��${Yan}[ZY] on 2015/8/10 0010 11:25
 * Email ��530412159@qq.com
 */

/**
 * ������ ��ק����
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
				// �¼������ActionDown ����true ��Ī������Move ��Up  �Żᴫ�ݸ�����ӿڷ���
				// �������false ��Īmove �� up �򲻻ᴫ�����������
				lastX = event.getRawX();
				lastY = event.getRawY();
				ret = false;
				break;
			case MotionEvent.ACTION_MOVE:
				float currentX = event.getRawX();
				float currentY = event.getRawY();


				float cx = currentX - lastX;
				float cy = currentY - lastY;

				// ע��!!!!!!!   �õ�ƫ����֮�����ѵ�ǰλ��  ���ø� lastX ��lastY 
				// ��Ϊ�����ſ��Խ�����һ�εļ���
				lastX=currentX;
				lastY=currentY;
				
				ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
				if (layoutParams instanceof WindowManager.LayoutParams) {
					WindowManager.LayoutParams lp = (WindowManager.LayoutParams) layoutParams;
					//����LayoutParams �� x y

					lp.x=lp.x+(int)cx;
					lp.y=lp.y+(int)cy;

					// ֱ���޸� LayoutParams ����ֵ�ǲ���ֱ�Ӹ���UI�� ʹ��WindowManager ������

					WindowManager manager=(WindowManager) v.getContext().getSystemService(Context.WINDOW_SERVICE);

					// ���߳�  ����UI
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
