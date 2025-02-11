package org.lee.mugen.renderer.jogl.shader;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class SubShader extends Shader {

	public SubShader() {
		super("substract");
	}
	private int opacityUniPos;
	private int baseUniPos;
	private int blendUniPos;
	
	public void compileShader(GL2 gl) {
		super.compileShader(gl);
		
		gl.glGetObjectParameterivARB(programID,
				GL2.GL_OBJECT_LINK_STATUS_ARB, programBuffer);
		if (programBuffer.get(0) == GL2.GL_FALSE)
			System.err.println("A linking error occured in a shader program.");
		opacityUniPos = getUniformLocation(gl, programID, "Opacity");
		baseUniPos = getUniformLocation(gl, programID, "BaseImage");
		blendUniPos = getUniformLocation(gl, programID, "BlendImage");
		
	}
	public void render(GL2 gl, float opacity, Texture base, Texture blend) {
		gl.glUseProgramObjectARB(programID);
		gl.glUniform1fARB(opacityUniPos, opacity);
		
		gl.glActiveTexture(GL2.GL_TEXTURE1);
		base.bind(gl);
		gl.glUniform1i(baseUniPos, 1);

		gl.glActiveTexture(GL2.GL_TEXTURE0);
		blend.bind(gl);
		gl.glUniform1i(blendUniPos, 0);

	
	}
}
