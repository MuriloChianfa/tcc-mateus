package com.example.teste.Core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;


public abstract class Base64
{
    public static byte[] encodeTobase64(Bitmap bitmap)
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        return stream.toByteArray();
    }

    public static Bitmap decodeBase64(byte[] byteArray)
    {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }
}
