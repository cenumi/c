package com.c1yde3.mvvmexample.util.extension

import kotlin.experimental.or

fun Byte.toUnsignedInt():Int{
    return this.toInt() and 0xFF
}

//fun Byte.toBinaryString():String{
//    val a = this.toInt() or 256
//    val s = a.toString(2)
//    val len = s.length
//    return s.substring(len - 8,len)
//}