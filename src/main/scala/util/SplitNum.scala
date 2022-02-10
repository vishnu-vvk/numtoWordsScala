package util

import scala.collection.mutable.ArrayBuffer

class SplitNum {
  def splitNum(input:String) :ArrayBuffer[String]={
    var len = input.length()

    var splitStr= new ArrayBuffer[String]()

    if(len<=3){
      splitStr +=input
    }
    else if(len<=6){
      splitStr +=input.substring(0,3)
      splitStr +=input.substring(3)
    }
    else if(len<=9){
      splitStr +=input.substring(0,3)
      splitStr +=input.substring(3,6)
      splitStr +=input.substring(6)
    }
    else if(len>9){
      splitStr +=input.substring(0,3)
      splitStr +=input.substring(3,6)
      splitStr +=input.substring(6,9)
      splitStr +=input.substring(9)
    }

  return splitStr
  }

}
