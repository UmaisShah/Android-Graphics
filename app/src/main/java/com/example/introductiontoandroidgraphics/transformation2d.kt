package com.example.introductiontoandroidgraphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Point
import android.view.View

open class transformation2d(context: Context) : View(context) {
    var points = arrayOf<Point>().also {
        Point(50, 300)
        Point(150, 400)
        Point(180, 340)
        Point(240, 420)
        Point(300, 200)
    }
    lateinit var myLines: Path

    /*      Translation of vertices
            We can translate the vertices of a shape by using the translate() method of the Canvas class upon x and y axis
            For Rotation we use following equaton.
            x' = x*cos(theta) - y*sin(theta)
            y' = x*sin(theta) + y*cos(theta)
            for scaling we can use following equation
            x' = x*sx
            y' = y*sy
            where sx and sy are scaling factors along x and y axis respectively.
            For shear
            x' = x + y*shx
            y' = x*shy + y
            where shx and shy are shear factors along x and y axis respectively.
    */

    fun translate(input: Array<Point>, px: Int, py: Int): Array<Point> {
        val matrix = arrayOf(
            doubleArrayOf(1.0, 0.0, 0.0),
            doubleArrayOf(0.0, 1.0, 0.0),
            doubleArrayOf(px.toDouble(), py.toDouble(), 1.0)
        )
        return AffineTransformation(input,matrix)
    }
    fun updatePath(newPoints: Array<Point>) {
        myLines.reset()
        myLines.moveTo(newPoints[0].x.toFloat(), newPoints[0].y.toFloat())
        for (i in 1 until newPoints.size) {
            myLines.lineTo(newPoints[i].x.toFloat(), newPoints[i].y.toFloat())
        }
        myLines.close()
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }


}

//    private Path linegraph;
////constructior
//viewheight = getResources()} .getOisplayMetrics().heightPixels - 70; //7@ is the height of the bottom control bar
//viewwidth = getResources().getDisplayMetrics() .widthPixels;
//int plotdata[)={11,29,10,20,12,5,31,24,21, 13};
//Linegraph=CreateLineGraph(plotdata, viewwidth, viewheight);
//private Path CreateLineGraph(int[(]input, int width,int height) {
//Point (Jptarraysnew Point {input. Length] ;
//int minvalue = 999999, maxvalue = -999999;
//for (int i=0;i<input. length; i++) {ptarray[i]=new Point(4, input [i] );
//minvalue = Math.min(minvalue, input[i]); maxvalue = Math.max(maxvalue, input[i});}
//ptarray=translate(ptarray,@,-minvalue);
//double yscalesheight/ (double) (maxvalue-minvalue) , xscaleswidth/ (double) (input. length-1);
//ptarray=scale(ptarray,xscale, yscale);
//Path result=new Path();
//result.moveTo(ptarray([@].x,ptarray[@].y);
//for (int i=1;i<ptarray.length;it++) result. lineTo(ptarray[i).x,ptarray(i].y);
//return result;}
//canvas. drawPath( linegraph, redPaint); //<-onDraw
