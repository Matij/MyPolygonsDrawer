package com.example.makeitappandroid.myapplication;

/**
 * Created by MakeitappAndroid on 09/10/15.
 */
public class Vector2 {
    /**
     * X component of the vector
     */
    public float X;

    /**
     * Y component of the vector
     */
    public float Y;


    /**
     * Create a new Vector2 object
     */
    public Vector2() {
        X = 0;
        Y = 0;
    }


    /**
     * Create a new Vector2 object with given x and y co-ordinates
     */
    public Vector2(float x, float y) {
        X = x;
        Y = y;
    }

    /**
     *
     */
    public void rotate(float degree, float px, float py)
    {
        //calculate angles needed to rotate vector
        float sin = (float) Math.sin(degree);
        float cos = (float) Math.cos(degree);

        //offset the vector to the origin
        float offsetx = X - px;
        float offsety = Y - py;

        //rotate the vector
        float newx = (offsetx * cos) - (offsety * sin);
        float newy = (offsetx * sin) + (offsety * cos);

        //translate vector back
        X = newx + px;
        Y = newy + py;
    }

    /**
     * Returns the magnitude of this vector
     */
    public float magnitude()
    {
        return (float)Math.sqrt((X * X) + (Y * Y));
    }


    /**
     * returns the magnitude between this vector and another given vector
     */
    public float magnitude(Vector2 vector)
    {
        float deltax = X - vector.X;
        float deltay = Y - vector.Y;
        return (float)Math.sqrt((deltax * deltax) + (deltay * deltay));
    }


    /**
     * Returns the squared magnitude between this vector and another given
     * vector
     */
    public float squaredMagnitude(Vector2 vector)
    {
        float deltax = X - vector.X;
        float deltay = Y - vector.Y;
        return (deltax * deltax) + (deltay * deltay);
    }

    /**
     * Returns the dot product between this vector and another given vector
     */
    public float dot(Vector2 vector)
    {
        return (X * vector.X) + (Y * vector.Y);
    }


    /**
     * Returns the centre point from an array of given vectors
     */
    public static Vector2 getCentre(Vector2[] vectors)
    {
        //create new vector
        Vector2 centre = new Vector2();

        //add up all vector in the given array
        for (int i = 0; i < vectors.length; i++) {
            centre.X += vectors[i].X;
            centre.Y += vectors[i].Y;
        }

        //divide by total number of vectors for centre point
        centre.X /= vectors.length;
        centre.Y /= vectors.length;

        //return centre
        return centre;
    }

}
