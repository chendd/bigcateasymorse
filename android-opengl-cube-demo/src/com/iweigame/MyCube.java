package com.iweigame;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

public class MyCube {
	
    public MyCube()
    {
        int one = 0x10000;
        int vertices[] = {
                -one, -one, -one,
                one, -one, -one,
                one,  one, -one,
                -one,  one, -one,
                -one, -one,  one,
                one, -one,  one,
                one,  one,  one,
                -one,  one,  one,
        };

        int colors[] = {
                0,    0,    0,  one,
                one,    0,    0,  one,
                one,  one,    0,  one,
                0,  one,    0,  one,
                0,    0,  one,  one,
                one,    0,  one,  one,
                one,  one,  one,  one,
                0,  one,  one,  one,
        };

        byte indices[] = {
                0, 4, 5,    0, 5, 1,
                1, 5, 6,    1, 6, 2,
                2, 6, 7,    2, 7, 3,
                3, 7, 4,    3, 4, 0,
                4, 7, 6,    4, 6, 5,
                3, 0, 1,    3, 1, 2
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());
        mVertexBuffer = vbb.asIntBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);

        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
        cbb.order(ByteOrder.nativeOrder());
        mColorBuffer = cbb.asIntBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);
        
        
      //四个顶点
        int pfVer[] = { 0,		0,	0,
        		100,	0,	0,
        		100,	100,	0,
        		0,	100,	0 };
        //两个面
        byte piInd[] = { 0,1,2,
        		2,3,0 };

        ByteBuffer vbb1 = ByteBuffer.allocateDirect(pfVer.length*4);
        vbb1.order(ByteOrder.nativeOrder());
        mVertexBuffer1 = vbb1.asIntBuffer();
        mVertexBuffer1.put(pfVer);
        mVertexBuffer1.position(0);

        mIndexBuffer1 = ByteBuffer.allocateDirect(piInd.length);
        mIndexBuffer1.put(piInd);
        mIndexBuffer1.position(0);
    }
    
    
    
    public void draw(GL10 gl)
    {
    	// 设置CW方向为“正面”，CW即ClockWise，顺时针
        gl.glFrontFace(gl.GL_CW);
        
        /*
         * 空间坐标数组，
         * 定点坐标数量 3
         * 坐标数据类型 FIXED
         * 连续定点之间字节偏移量，0表示紧密相邻
         * 坐标地址数组
         */   
        gl.glVertexPointer(3, gl.GL_FIXED, 0, mVertexBuffer);
        
        /*
         * 颜色坐标数组
         * 顶点坐标数量 4
         * 坐标数据类型 FEXED
         * 偏移量 0表示紧密相邻 
         * 颜色数组
         */
        gl.glColorPointer(4, gl.GL_FIXED, 0, mColorBuffer);
        
        //通过较少的函数调用绘制多个几何图元
        gl.glDrawElements(gl.GL_TRIANGLES, 36, gl.GL_UNSIGNED_BYTE, mIndexBuffer);
        
        
    }

    private IntBuffer   mVertexBuffer;
    private IntBuffer   mVertexBuffer1;
    private IntBuffer   mColorBuffer;
    private ByteBuffer  mIndexBuffer;
    private ByteBuffer  mIndexBuffer1;
}
