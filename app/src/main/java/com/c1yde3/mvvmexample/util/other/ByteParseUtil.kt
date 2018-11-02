package com.c1yde3.mvvmexample.util.other


import kotlin.experimental.and

object ByteParseUtil {

    fun byte2Long(high: Byte,b2: Byte,b3: Byte,low: Byte):Long{
        return (low.toInt() and 0xff shl 24 or
                b3.toInt() and 0xff shl 16 or
                b2.toInt() and 0xff shl 8 or
                high.toInt() and 0xff).toLong()
    }

    fun byte2Int(high: Byte,b2: Byte,low: Byte):Int{
        return (low.toInt() and 0xff shl 16 or
                b2.toInt() and 0xff shl 8 or
                high.toInt() and 0xff)
    }

    fun byte2Int(high: Byte,low: Byte):Int{
        return byte2Int(0,high,low)
    }

    fun byte2Int(byte: Byte):Int{
        return byte2Int(0,byte)
    }

}