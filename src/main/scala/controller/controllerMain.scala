package controller

import scala.collection.mutable
import mapper.UnitMap
import util.SplitNum
import util.ConvertToWord

import scala.collection.mutable.ArrayBuffer

object controllerMain {

  var map = new UnitMap
  var split = new SplitNum
  var ctw = new ConvertToWord

  def convertNumToWords(): Unit ={
    val input:String = scala.io.StdIn.readLine()
    val output = StringBuilder.newBuilder
    var splitStr = new ArrayBuffer[String]()

    if(input.toLong<20){
      output.append(map.mapUnits(input))
    }
    else{
      splitStr = split.splitNum(input.reverse)
      output.append(ctw.convertToWord(splitStr))
    }

    println(output.toString().capitalize)

  }

  def main(args: Array[String]): Unit = {
    convertNumToWords()
  }

}
