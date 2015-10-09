package com.example.makeitappandroid.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by MakeitappAndroid on 09/10/15.
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //purple outlined automatically built polygon (hexagon)
        DrawablePolygon poly1 = new DrawablePolygon(100, 100, 6, 40, Color.YELLOW);
        poly1.outline();
        poly1.draw(canvas);

        //orange filled set defined polygon (triangle)
        Vector2[] vertices = new Vector2[3];
        vertices[0] = new Vector2(100, 100);
        vertices[1] = new Vector2(150, 150);
        vertices[2] = new Vector2(50, 150);

        DrawablePolygon poly2 = new DrawablePolygon(100, 133.33f, vertices, Color.GREEN);
        poly2.draw(canvas);
    }
}
