package com.c1yde3.mvvmexample.util.extension

import android.text.TextUtils
import java.lang.IllegalArgumentException
import kotlin.math.pow


fun String.toHexByteArray():ByteArray{
    if (this.isEmpty()){
        throw IllegalArgumentException("不能为空")
    }
    val preProcessed = this.toLowerCase()
    val arr = ByteArray(preProcessed.length / 2)
    for (index in 0..(arr.size-1)){
        arr[index] = preProcessed.substring(index*2,index*2+2).toByte(16);
    }
    return arr;
}


fun String.toUnsignedByte(radix:Int):Byte{
    return this.toInt(radix).toByte()
}