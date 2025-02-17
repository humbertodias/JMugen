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
//import java.nio.ByteBuffer;
//
//import org.lwjgl.opengl.ARBShaderObjects;
//import org.lwjgl.opengl.ARBVertexShader;
//import org.lwjgl.opengl.GL11;
//
//final class ShaderVSH extends Shader {
//
//	final String file;
//	final ByteBuffer source;
//
//	final int shaderID;
//	final int programID;
//
//	final int uniformLocation;
//
//	ShaderVSH(final String shaderFile) {
//		file = shaderFile;
//		source = getShaderText(shaderFile);
//
//		shaderID = ARBShaderObjects.glCreateShaderObjectARB(ARBVertexShader.GL_VERTEX_SHADER_ARB);
//		ARBShaderObjects.glShaderSourceARB(shaderID, source);
//		ARBShaderObjects.glCompileShaderARB(shaderID);
//
//		printShaderObjectInfoLog(file, shaderID);
//
//		ARBShaderObjects.glGetObjectParameterARB(shaderID, ARBShaderObjects.GL_OBJECT_COMPILE_STATUS_ARB, programBuffer);
//		if ( programBuffer.get(0) == GL11.GL_FALSE )
//			ShadersTest.kill("A compilation error occured in a vertex shader.");
//
//		programID = ARBShaderObjects.glCreateProgramObjectARB();
//
//		ARBShaderObjects.glAttachObjectARB(programID, shaderID);
//		ARBShaderObjects.glLinkProgramARB(programID);
//
//		printShaderProgramInfoLog(programID);
//
//		ARBShaderObjects.glGetObjectParameterARB(programID, ARBShaderObjects.GL_OBJECT_LINK_STATUS_ARB, programBuffer);
//		if ( programBuffer.get(0) == GL11.GL_FALSE )
//			ShadersTest.kill("A linking error occured in a shader program.");
//
//		uniformLocation = getUniformLocation(programID, "UNIFORMS");
//	}
//
//	void render() {
//		ARBShaderObjects.glUseProgramObjectARB(programID);
//
//		ARBShaderObjects.glUniform2fARB(uniformLocation, ShadersTest.getSin(), ShadersTest.getSpecularity() * 8.0f);
//
//		ShadersTest.renderObject();
//
//		ARBShaderObjects.glUseProgramObjectARB(0);
//	}
//
//	void cleanup() {
//		ARBShaderObjects.glDetachObjectARB(programID, shaderID);
//
//		ARBShaderObjects.glDeleteObjectARB(shaderID);
//		ARBShaderObjects.glDeleteObjectARB(programID);
//	}
//
//}