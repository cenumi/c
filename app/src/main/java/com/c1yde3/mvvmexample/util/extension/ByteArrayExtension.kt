package com.c1yde3.mvvmexample.util.extension

import java.lang.IllegalArgumentException
import kotlin.experimental.and


fun ByteArray.toHexString():String{
    var res = ""
    for (item in this){
        res += String.format("%02x",item.toInt() and 0xff)
    }
    return res.toUpperCase()
}

fun ByteArray.concat(array: ByteArray):ByteArray{
    return byteArrayOf(*this,*array)
}