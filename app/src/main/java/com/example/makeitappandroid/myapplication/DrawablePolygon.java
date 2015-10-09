package com.example.makeitappandroid.myapplication;

/**
 * Created by MakeitappAndroid on 09/10/15.
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Matrix;

/**
 * Simple implementation for a drawable polygon
 */
public class DrawablePolygon {
    /**
     * The polygon itself, represented as a Path object
     */
    protected Path path = new Path();

    /**
     * Matrix to help moving the polgon
     */
    protected Matrix matrix = new Matrix();

    /**
     * Paint object to help define the colour of the polygon
     */
    protected Paint paint = new Paint();

    /**
     * Hidden position co-ordinates for the polygon
     */
    protected float positionX, positionY;


    /**
     * Create a DrawablePolygon given an array of vertices
     */
    public DrawablePolygon(float x, float y, Vector2[] vertices, int colour)
    {
        //set the position of the polygon (this should be the centre of the polygon)
        positionX = x;
        positionY = y;

        //set the starting vertex of the path
        path.moveTo(vertices[0].X, vertices[0].Y);

        //add the other vertices to the path
        for (int i = 1; i < vertices.length; i++) {
            path.lineTo(vertices[i].X, vertices[i].Y);
        }

        //close the path, so the last vertex joins to the first
        path.close();

        //set polygon colour
        paint.setColor(colour);
    }

    /**
     * Automatically creates a drawable polygon from a radius and number of
     * vertices supplied
     */
    public DrawablePolygon(float x, float y, int noOfVertices, float radius, int colour)
    {
        //set the position of the polygon
        positionX = x;
        positionY = y;

        //degrees of separation between each vertex
        float degrees = 360.0f / noOfVertices;

        //initial position of the first vertex
        float vx = (float) (Math.sin(0) + radius);
        float vy = (float) (Math.cos(0) - radius);

        //move vertex into position and set as starting vertex
        path.moveTo(vx + x, vy + y);

        //calculate other vertices and add them accordingly
        for (int i = 1; i < noOfVertices; i++) {
            vx = (float) (Math.sin(degrees * i) + radius);
            vy = (float) (Math.cos(degrees * i) - radius);
            path.lineTo(vx + x, vy + y);
        }

        //close polygon
        path.close();

        //set polygon's colour
        paint.setColor(colour);
    }

    /**
     * Draws the polygon to the given canvas
     */
    public void draw(Canvas canvas)
    {
        canvas.drawPath(path, paint);
    }

    /**
     * Sets the colour of the polygon
     */
    public void setColor(int colour)
    {
        paint.setColor(colour);
    }

    /**
     * Sets the polygon to be drawn as an outline
     */
    public void outline()
    {
        paint.setStyle(Paint.Style.STROKE);
    }

    /**
     * Sets the polygon to be filled as a solid polygon
     */
    public void fill()
    {
        paint.setStyle(Paint.Style.FILL);
    }

}
