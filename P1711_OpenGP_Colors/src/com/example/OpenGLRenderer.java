package com.example;

import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.GL_FLOAT;
import static android.opengl.GLES20.GL_FRAGMENT_SHADER;
import static android.opengl.GLES20.GL_TRIANGLES;
import static android.opengl.GLES20.GL_TRIANGLE_FAN;
import static android.opengl.GLES20.GL_TRIANGLE_STRIP;
import static android.opengl.GLES20.GL_VERTEX_SHADER;
import static android.opengl.GLES20.GL_LINES;
import static android.opengl.GLES20.GL_LINE_STRIP;
import static android.opengl.GLES20.GL_LINE_LOOP;
import static android.opengl.GLES20.GL_POINTS;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glLineWidth;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glDrawArrays;
import static android.opengl.GLES20.glEnableVertexAttribArray;
import static android.opengl.GLES20.glGetAttribLocation;
import static android.opengl.GLES20.glGetUniformLocation;
import static android.opengl.GLES20.glUniform4f;
import static android.opengl.GLES20.glUseProgram;
import static android.opengl.GLES20.glVertexAttribPointer;
import static android.opengl.GLES20.glViewport;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;

public class OpenGLRenderer implements Renderer {
	private Context context;
	private int programId;
	private FloatBuffer vertexData;
	private int aColorLocation;
	private int aPositionLocation;

	public OpenGLRenderer(Context context) {
		this.context = context;
		prepareData();
	}

	@Override
	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		glClearColor(0f, 0f, 0f, 1f);
		int vertexShaderId = ShaderUtils.createShader(context, GL_VERTEX_SHADER, R.raw.vertex_shader);
		int fragmentShaderId = ShaderUtils.createShader(context, GL_FRAGMENT_SHADER, R.raw.fragment_shader);
		programId = ShaderUtils.createProgram(vertexShaderId, fragmentShaderId);
		glUseProgram(programId);
		bindData();
	}

	@Override
	public void onSurfaceChanged(GL10 arg0, int width, int height) {
		glViewport(0, 0, width, height);
	}

	private void prepareData() {
		float[] vertices_01 = {
				// треугольник 1
				-0.9f, 0.8f, -0.9f, 0.2f, -0.5f, 0.8f,

				// треугольник 2
				-0.6f, 0.2f, -0.2f, 0.2f, -0.2f, 0.8f,

				// треугольник 3
				0.1f, 0.8f, 0.1f, 0.2f, 0.5f, 0.8f,

				// треугольник 4
				0.1f, 0.2f, 0.5f, 0.2f, 0.5f, 0.8f, };

		float[] vertices_02 = { 0.1f, 0.8f, 0.1f, 0.2f, 0.5f, 0.8f, 0.1f, 0.2f, 0.5f, 0.2f, 0.5f, 0.8f, };

		float[] vertices_03 = { 0.1f, 0.8f, 0.1f, 0.2f, 0.5f, 0.8f, 0.5f, 0.2f, };

		float[] vertices_04 = { 0.0f, 0.0f, -0.4f, 0.4f, 0.4f, 0.4f, 0.8f, 0.0f, 0.4f, -0.4f, -0.4f, -0.4f, -0.8f, 0.0f,
				-0.4f, 0.4f, };

		float[] vertices_05 = { -0.9f, -0.9f, 0.9f, 0.9f, };

		float[] vertices_06 = {
				// линия 1
				-0.9f, -0.9f, 0.9f, 0.9f,

				// линия 2
				-0.5f, 0.0f, 0.5f, 0.0f,

				// линия 3
				0.0f, 0.7f, 0.0f, -0.7f, };
		
		float[] vertices_07 = {
		        -0.4f, 0.6f, 
		        0.4f, 0.6f, 
		        0.6f, 0.4f,
		        0.6f, -0.4f, 
		        0.4f, -0.6f, 
		        -0.4f, -0.6f,
		};
		
		
		float[] vertices_08 = { 
		        // треугольник 1 
		        -0.9f, 0.8f, -0.9f, 0.2f, -0.5f, 0.8f, 
		         
		        // треугольник 2 
		        -0.6f, 0.2f, -0.2f, 0.2f, -0.2f, 0.8f, 
		         
		        // треугольник 3 
		        0.1f, 0.8f, 0.1f, 0.2f, 0.5f, 0.8f, 
		         
		        // треугольник 4 
		        0.1f, 0.2f, 0.5f, 0.2f, 0.5f, 0.8f, 
		         
		        // линия 1 
		        -0.7f, -0.1f, 0.7f, -0.1f, 
		         
		        // линия 2 
		        -0.6f, -0.2f, 0.6f, -0.2f, 
		         
		        // точка 1 
		        -0.5f, -0.3f, 
		         
		        // точка 2 
		        0.0f, -0.3f, 
		         
		        // точка 3 
		        0.5f, -0.3f, 
		}; 
		
		float[] vertices_09 = {
		        // линия 1
		        -0.4f, 0.6f, 1.0f, 0.0f, 0.0f,
		        0.4f, 0.6f, 0.0f, 1.0f, 0.0f,
		  
		        // линия 2
		        0.6f, 0.4f, 0.0f, 0.0f, 1.0f,
		        0.6f, -0.4f, 1.0f, 1.0f, 1.0f,
		  
		        // линия 3
		        0.4f, -0.6f, 1.0f, 1.0f, 0.0f,
		        -0.4f, -0.6f, 1.0f, 0.0f, 1.0f,
		};
		
		float[] vertices = {
		        -0.5f, -0.2f, 1.0f, 0.0f, 0.0f,
		        0.0f, 0.2f, 0.0f, 1.0f, 0.0f,
		        0.5f, -0.2f, 0.0f, 0.0f, 1.0f,
		};

		vertexData = ByteBuffer.allocateDirect(vertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
		vertexData.put(vertices);
	}

	private void bindData_08() {
		aColorLocation = glGetUniformLocation(programId, "u_Color");
		glUniform4f(aColorLocation, 0.0f, 0.0f, 1.0f, 1.0f);
		aPositionLocation = glGetAttribLocation(programId, "a_Position");
		vertexData.position(0);
		glVertexAttribPointer(aPositionLocation, 2, GL_FLOAT, false, 0, vertexData);
		glEnableVertexAttribArray(aPositionLocation);
	}
	
	private void bindData() {
	    // координаты
	    aPositionLocation = glGetAttribLocation(programId, "a_Position");
	    vertexData.position(0);
	    glVertexAttribPointer(aPositionLocation, 2, GL_FLOAT, false, 20, vertexData);
	    glEnableVertexAttribArray(aPositionLocation);
	  
	    // цвет
	    aColorLocation = glGetAttribLocation(programId, "a_Color");
	    vertexData.position(2);
	    glVertexAttribPointer(aColorLocation, 3, GL_FLOAT, false, 20, vertexData);
	    glEnableVertexAttribArray(aColorLocation);
	}


	public void onDrawFrame0(GL10 arg0) {
		glClear(GL_COLOR_BUFFER_BIT);
		// glDrawArrays(GL_TRIANGLES, 0, 12);
		// glDrawArrays(GL_TRIANGLES, 0, 6);
		// glDrawArrays(GL_TRIANGLE_STRIP, 0, 4);
		// glDrawArrays(GL_TRIANGLE_FAN, 0, 8);
		//glDrawArrays(GL_LINES, 0, 2);

		glLineWidth(5);
		//glDrawArrays(GL_LINES, 0, 6);
		
		//glDrawArrays(GL_LINE_STRIP, 0, 6);
		
		//glDrawArrays(GL_LINE_LOOP, 0, 6);
		
		glDrawArrays(GL_POINTS, 0, 6); 
	}
	

	public void onDrawFrame01(GL10 arg0) {
	    glClear(GL_COLOR_BUFFER_BIT);
	    glLineWidth(5);
	  
	    // синие треугольники
	    glUniform4f(aColorLocation, 0.0f, 0.0f, 1.0f, 1.0f);
	    glDrawArrays(GL_TRIANGLES, 0, 12);
	  
	    // зеленые линии
	    glUniform4f(aColorLocation, 0.0f, 1.0f, 0.0f, 1.0f);
	    glDrawArrays(GL_LINES, 12, 4);
	  
	    // красные точки
	    glUniform4f(aColorLocation, 1.0f, 0.0f, 0.0f, 1.0f);
	    glDrawArrays(GL_POINTS, 16, 3);
	}
	
	public void onDrawFrame2(GL10 arg0) {
	    glClear(GL_COLOR_BUFFER_BIT);
	    glLineWidth(5);
	  
	    // синие треугольники
	    glUniform4f(aColorLocation, 0.0f, 0.0f, 1.0f, 1.0f);
	    glDrawArrays(GL_TRIANGLES, 0, 12);
	  
	    // зеленая линия
	    glUniform4f(aColorLocation, 0.0f, 1.0f, 0.0f, 1.0f);
	    glDrawArrays(GL_LINES, 12, 2);
	  
	    // желтая линия
	    glUniform4f(aColorLocation, 1.0f, 1.0f, 0.0f, 1.0f);
	    glDrawArrays(GL_LINES, 14, 2);
	  
	    // красные точки
	    glUniform4f(aColorLocation, 1.0f, 0.0f, 0.0f, 1.0f);
	    glDrawArrays(GL_POINTS, 16, 3);
	}
	
	@Override
	public void onDrawFrame(GL10 arg0) {
	    glLineWidth(5);
	    glDrawArrays(GL_TRIANGLES, 0, 3);
	}
}