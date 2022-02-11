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

    for(i <- len-1 to 0 by -1){
      val ip = splitStr(i)

      if(ip.length==1)
        word.append((map.mapUnits(ip(0).toString)))
      else if(ip.length==2)
        word.append(validate.checkTens(ip))
      else if(ip.length==3)
        word.append((validate.checkHundreds(ip,i)+validate.checkTens(ip(0)+""+ip(1))))

      if(i!=0)
        word.append(validate.checkPlaces(ip,i))
    }

    return word.toString()
  }


}
