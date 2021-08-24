package com.example.teste.Core;

import android.graphics.Bitmap;
import android.view.View;

public class Screenshot
{
    public static Bitmap take(View view)
    {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);

        Bitmap bitmapData = Bitmap.createBitmap(view.getDrawingCache(true));

        view.setDrawingCacheEnabled(false);

        return bitmapData;
    }

    public static Bitmap takeOfRootView(View view)
    {
        return take(view.getRootView());
    }
}
