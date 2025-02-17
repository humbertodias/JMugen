///*
// * Copyright (c) 2002-2004 LWJGL Project
// * All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions are
// * met:
// *
// * * Redistributions of source code must retain the above copyright
// *   notice, this list of conditions and the following disclaimer.
// *
// * * Redistributions in binary form must reproduce the above copyright
// *   notice, this list of conditions and the following disclaimer in the
// *   documentation and/or other materials provided with the distribution.
// *
// * * Neither the name of 'LWJGL' nor the names of
// *   its contributors may be used to endorse or promote products derived
// *   from this software without specific prior written permission.
// *
// * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
// * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
// * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
// * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
// * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// */
///*
// * Created by LWJGL.
// * User: spasi
// * Date: 2004-03-30
// * Time: 9:55:38 pm
// */
//
//package org.lwjgl.test.opengl.shaders;
//
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import org.lwjgl.opengl.GL20;
//import org.lwjgl.opengl.GL30;
//import org.lwjgl.opengl.GL33;
//
//import static org.lwjgl.opengl.GL20.*;
//import static org.lwjgl.opengl.GL30.*;
//
//final class ShaderVP extends Shader {
//
//	final String file;
//	final String source;  // Change to String to pass as CharSequence to OpenGL
//
//	final int programID;
//	final int vertexShaderID;
//
//	ShaderVP(final String shaderFile) {
//		this.file = shaderFile;
//		this.source = getShaderText(shaderFile); // Assuming this method loads shader source code as String
//
//		// Compile the vertex shader
//		vertexShaderID = glCreateShader(GL_VERTEX_SHADER);
//		glShaderSource(vertexShaderID, source);  // Use String for source
//		glCompileShader(vertexShaderID);
//		checkShaderCompileError(vertexShaderID, file);
//
//		// Create the program and attach the vertex shader
//		programID = glCreateProgram();
//		glAttachShader(programID, vertexShaderID);
//		glLinkProgram(programID);
//		glValidateProgram(programID);
//
//		checkProgramLinkError(programID);
//	}
//
//	void render() {
//		glUseProgram(programID);
//
//		// Set the shader uniform parameters
//		int location = glGetUniformLocation(programID, "someUniform");  // Assuming the uniform is called "someUniform"
//		glUniform4f(location, ShadersTest.getSin(), ShadersTest.getSpecularity() * 8.0f, 0.0f, 0.0f);
//
//		// Render the object
//		ShadersTest.renderObject();
//	}
//
//	void cleanup() {
//		// Cleanup the program and shader
//		glDeleteProgram(programID);
//		glDeleteShader(vertexShaderID);
//	}
//
//	private void checkShaderCompileError(int shaderID, String file) {
//		if (glGetShaderi(shaderID, GL_COMPILE_STATUS) == GL_FALSE) {
//			System.err.println("Shader compilation failed for: " + file);
//			System.err.println(glGetShaderInfoLog(shaderID));
//			throw new RuntimeException("Shader compilation error");
//		}
//	}
//
//	private void checkProgramLinkError(int programID) {
//		if (glGetProgrami(programID, GL_LINK_STATUS) == GL_FALSE) {
//			System.err.println("Program linking failed");
//			System.err.println(glGetProgramInfoLog(programID));
//			throw new RuntimeException("Program linking error");
//		}
//	}
//
//}
