package com.iweigame;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class MyCubeRenderer implements Renderer {

	private MyCube mCube;
	public float mAngleX;
	public float mAngleY;

	public MyCubeRenderer() {
		mCube = new MyCube();
	}

	@Override
	public void onDrawFrame(GL10 gl) {

		/*
		 * 清除当前缓冲区 GL_COLOR_BUFFER_BIT颜色缓冲区 GL_DEPTH_BUFFER_BIT深度缓冲区
		 */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		// 设置矩阵为模型视图矩阵
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		// 把当前矩阵设置为单位矩阵
		gl.glLoadIdentity();
		// 向z轴复半轴移动3
		gl.glTranslatef(0, 0, -3.0f);
		// 延y轴旋转
		gl.glRotatef(mAngleX, 0, 1, 0);
		// 延x轴旋转
		gl.glRotatef(mAngleY, 1, 0, 0);
		// 激活坐标数组
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		// 激活颜色数组
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

		mCube.draw(gl);

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);

		float ratio = (float) width / height;
		// 设置矩阵为投影矩阵
		gl.glMatrixMode(GL10.GL_PROJECTION);
		// 把当前矩阵设置为单位矩阵
		gl.glLoadIdentity();
		// 创建一个透视试图平截头体矩阵
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// 禁用抖动
		gl.glDisable(GL10.GL_DITHER);

		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);

		// 清除窗口
		gl.glClearColor(1, 1, 1, 1);

		// 打开或这关闭一些渲染功能例如：光照，纹理，隐藏表面消除，雾等效果
		// 打开可见面判大特性
		gl.glEnable(GL10.GL_CULL_FACE);
		//着色模型，平滑
		gl.glShadeModel(GL10.GL_SMOOTH);

		// 打开深度比较，并对深度缓冲区进行更新，
		// 开启深度测试，这样就可以比较新像素和旧像素的远近了！
		gl.glEnable(GL10.GL_DEPTH_TEST);
	}

}
