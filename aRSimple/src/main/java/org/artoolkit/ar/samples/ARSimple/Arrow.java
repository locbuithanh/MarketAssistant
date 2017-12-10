package org.artoolkit.ar.samples.ARSimple;

import android.opengl.GLES10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.artoolkit.ar.base.rendering.RenderUtils;

import javax.microedition.khronos.opengles.GL10;

public class Arrow {
    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    public Arrow() {
        this(1.0F);
    }

    public Arrow(float size) {
        this(size, 0.0F, 0.0F, 0.0F);
    }

    public Arrow(float size, float x, float y, float z) {
        this.setArrays(size, x, y, z);
    }

    private void setArrays(float size, float x, float y, float z) {
        float hs = size / 2.0F;
        float qs = size / 4.0F;

        float[] vertices = new float[]{
                x - qs, y - qs, z - qs,
                x - qs, y + qs, z - qs,
                x + hs, y, z - qs,
                x - qs, y - qs, z + qs,
                x - qs, y + qs, z + qs,
                x + hs, y, z + qs
        };
        float c = 1.0F;
        float[] colors = new float[]{
                0.0F, c, 0.0F, 0.0F,
                0.0F, c, 0.0F, 0.0F,
                0.0F, c, 0.0F, 0.0F,
                0.0F, c, 0.0F, 0.0F,
                0.0F, c, 0.0F, 0.0F,
                0.0F, c, 0.0F, 0.0F
//                c, 0.0F, 0.0F, c,
//                c, c, 0.0F, c,
//                0.0F, c, 0.0F, c,
//                0.0F, 0.0F, c, c,
//                c, 0.0F, c, c,
//                c, c, c, c,
//                0.0F, c, c, c
        };
        byte[] indices = new byte[]{
                0, 2, 5,
                0, 5, 3,
                0, 4, 3,
                1, 0, 4,
                1, 4, 5,
                1, 5, 2,
                0, 1, 2,
                2, 3,
                3, 5, 4};
        this.mVertexBuffer = RenderUtils.buildFloatBuffer(vertices);
        this.mColorBuffer = RenderUtils.buildFloatBuffer(colors);
        this.mIndexBuffer = RenderUtils.buildByteBuffer(indices);
    }

    public void draw(GL10 unused) {
        GLES10.glColorPointer(4, 5126, 0, this.mColorBuffer);
        GLES10.glVertexPointer(3, 5126, 0, this.mVertexBuffer);
        GLES10.glEnableClientState('聶');
        GLES10.glEnableClientState('聴');
        GLES10.glDrawElements(4, 24, 5121, this.mIndexBuffer);
        GLES10.glDisableClientState('聶');
        GLES10.glDisableClientState('聴');
    }
}