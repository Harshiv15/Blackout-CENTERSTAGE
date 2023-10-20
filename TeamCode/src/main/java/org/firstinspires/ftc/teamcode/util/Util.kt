package org.firstinspires.ftc.teamcode.util

// Let's just make it very clear what units we're using to avoid confusion
// Anything to do with RoadRunner is in Inches
typealias Radian = Double
typealias Degree = Double
typealias Inch = Double
typealias Meter = Double

fun Degree.toRadian(): Radian = this / 180 * Math.PI
fun Radian.toDegree(): Degree = this * 180 / Math.PI

fun Inch.toMeter(): Meter = 0.0254 * this

// if you use this, I will cry.
fun Meter.toInch(): Inch = 39.37008 * this