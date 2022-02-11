package controller

import mapper.UnitMap
import util.SplitNum
import util.ConvertToWord
import util.InputValidator

import scala.collection.mutable.ArrayBuffer

object controllerMain {

  var map = new UnitMap
  var split = new SplitNum
  var ctw = new ConvertToWord
  var ival = new InputValidator


  def convertNumToWords(): Unit ={
    val input:String = scala.io.StdIn.readLine()
    val output = StringBuilder.newBuilder
    var splitStr = new ArrayBuffer[String]()

    if(ival.validateInput(input)){
      output.append("Undefined")
    }
    else{
      if(input.toLong<20){
        output.append(map.mapUnits(input))
      }
      else{
        splitStr = split.splitNum(input.reverse)
        output.append(ctw.convertToWord(splitStr))
      }

    }

    println(output.toString().capitalize)

  }

  def main(args: Array[String]): Unit = {
    convertNumToWords()
  }

}
