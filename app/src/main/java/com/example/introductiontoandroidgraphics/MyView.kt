package com.example.introductiontoandroidgraphics

import android.content.Context
import android.graphics.*
import android.view.View

class MyView(context: Context) : View(context) {
    private var lines: Path = Path().apply {
        moveTo(0f, 0f)
        lineTo(10f, 10f)
        lineTo(50f, 50f)
        lineTo(100f, 100f)
        lineTo(150f, 150f)
//for closing polyline to makeit polygon
        close()
    }
    private var gradientPaint: Paint = Paint().apply {
        style = Paint.Style.FILL
        shader = linearGradient
    }

    //    gradient color
    private var linearGradient: LinearGradient =
        LinearGradient(0f, 0f, 150, 150f, Color.RED, Color.GREEN, Shader.TileMode.MIRROR)
    private var redPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE//setting stroke no fill
        color = 0xFFFF0000.toInt()//setting color
        strokeWidth = 5f//setting stroke width
    }
    private var greenPaint: Paint = Paint().apply {
        setARGB(255, 0, 255, 0)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //drawing rectangle
        canvas?.drawRect(10f, 30f, 200f, 200f, redPaint)
        //drawing circle
        canvas?.drawCircle(200f, 200f, 100f, redPaint)
        //draw polyline
        canvas?.drawPath(lines, greenPaint)
        draw gradient polygon
        canvas?.drawPath(lines, gradientPaint)
    }
}