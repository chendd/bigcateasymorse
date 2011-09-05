package com.nea.nehe.lesson06;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

/**
 * This class is an object representation of a Cube containing the vertex
 * information, texture coordinates, the vertex indices and drawing
 * functionality, which is called by the renderer.
 * 
 * @author Savas Ziplies (nea/INsanityDesign)
 */
public class Cube {



	/** Our texture pointer */
	private int[] textures = new int[6];


	private float vertices1[][] = {
			// Vertices according to faces
			{ -1.0f, -1.0f, 1.0f, // Vertex 0
					1.0f, -1.0f, 1.0f, // v1
					-1.0f, 1.0f, 1.0f, // v2
					1.0f, 1.0f, 1.0f }, // v3

			{ 1.0f, -1.0f, 1.0f, // ...
					1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f },

			{ 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f,
					-1.0f, 1.0f, -1.0f },

			{ -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f,
					-1.0f, 1.0f, 1.0f },

			{ -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f,
					1.0f, -1.0f, 1.0f },

			{ -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f,
					1.0f, -1.0f } };

	private float texture1[][] = {
			// Mapping coordinates for the vertices
			{ 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f },

			{ 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f },

			{ 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f },

			{ 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f },

			{ 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f },

			{ 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f }

	};

	

	/**
	 * The Cube constructor.
	 * 
	 * Initiate the buffers.
	 */

	FloatBuffer[] cubeBuff = new FloatBuffer[6];
	FloatBuffer[] texBuff = new FloatBuffer[6];

	Bitmap[] bitmap = new Bitmap[6];
	
	protected static FloatBuffer makeFloatBuffer(float[] arr) {
		ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * 4);
		bb.order(ByteOrder.nativeOrder());
		FloatBuffer fb = bb.asFloatBuffer();
		fb.put(arr);
		fb.position(0);
		return fb;
	}

	public Cube() {

		for (int i = 0; i < vertices1.length; i++) {
			cubeBuff[i] = makeFloatBuffer(vertices1[i]);
			texBuff[i] = makeFloatBuffer(texture1[i]);
		}

	}

	/**
	 * The object own drawing function. Called from the renderer to redraw this
	 * instance with possible changes in values.
	 * 
	 * @param gl
	 *            - The GL Context
	 */
	public void draw(GL10 gl) {
		// Bind our only previously generated texture in this case
		// gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

		// Point to our buffers
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		// Set the face rotation
		gl.glFrontFace(GL10.GL_CCW);


		gl.glEnable(GL10.GL_TEXTURE_2D);
		
		for (int i = 0; i < 6; i++) {
			
			
			gl.glGenTextures(0, textures, 0);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[i]);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
					GL10.GL_LINEAR);
			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0,bitmap[i] , 0);		

			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, cubeBuff[i]);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texBuff[i]);

			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP,0 , 4);
		}

		// Disable the client state before leaving
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	}

	/**
	 * Load the textures
	 * 
	 * @param gl
	 *            - The GL Context
	 * @param context
	 *            - The Activity context
	 */
	public void loadGLTexture(GL10 gl, Context context) {


		// Create Nearest Filtered Texture
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_LINEAR);

		// Different possible texture parameters, e.g. GL10.GL_CLAMP_TO_EDGE
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S,
				GL10.GL_REPEAT);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T,
				GL10.GL_REPEAT);
		
		
		bitmap[0] = getBitmap(context,R.drawable.hon_1);
		bitmap[1] = getBitmap(context,R.drawable.hon_2);
		bitmap[2] = getBitmap(context,R.drawable.hon_3);
		bitmap[3] = getBitmap(context,R.drawable.hon_4);
		bitmap[4] = getBitmap(context,R.drawable.hon_5);
		bitmap[5] = getBitmap(context,R.drawable.hon_6);
		
	}

	public Bitmap getBitmap(Context context, int imageInt) {
		InputStream is = context.getResources().openRawResource(imageInt);
		Bitmap bitmap = null;
		try {
			// BitmapFactory is an Android graphics utility for images
			bitmap = BitmapFactory.decodeStream(is);

		} finally {
			// Always clear and close
			try {
				is.close();
				is = null;
			} catch (IOException e) {
			}
		}
		return bitmap;
	}
}
