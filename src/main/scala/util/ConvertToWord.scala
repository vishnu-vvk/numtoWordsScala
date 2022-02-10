package util

import mapper.UnitMap
import util.ValidateConversion

import scala.collection.mutable.ArrayBuffer

class ConvertToWord {

  var map = new UnitMap
  var validate = new ValidateConversion

  def convertToWord(splitStr:ArrayBuffer[String]):String={
    val len = splitStr.length
    val word = StringBuilder.newBuilder

    for(i <- 0 to len-1){
      val ip = splitStr(i)
      if(i!=0)
        word.append(validate.checkPlaces(ip,i).reverse)

      if(ip.length==1)
        word.append((map.mapUnits(ip(0).toString)).reverse)
      else if(ip.length==2)
        word.append(validate.checkTens(ip).reverse)
      else if(ip.length==3)
        word.append((validate.checkHundreds(ip,i)+validate.checkTens(ip(0)+""+ip(1))).reverse)
    }

    return word.reverse.toString()
  }


}
