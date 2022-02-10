package util

import mapper.UnitMap

import scala.collection.mutable.ArrayBuffer

class ConvertToWord {

  var map = new UnitMap

  def convertToWord(splitStr:ArrayBuffer[String]):String={
    val len = splitStr.length
    val word = StringBuilder.newBuilder

    for(i <- 0 to len-1){
      val ip = splitStr(i)
      if(i!=0)
        word.append(checkPlaces(ip,i).reverse)

      if(ip.length==1)
        word.append((map.mapUnits(ip(0).toString)).reverse)
      else if(ip.length==2)
        word.append(checkTens(ip).reverse)
      else if(ip.length==3)
        word.append((checkHundreds(ip,i)+checkTens(ip(0)+""+ip(1))).reverse)
    }

    return word.reverse.toString()
  }

  def checkTens(ip:String):String={
    if((ip(1)+""+ip(0)).toInt<20)
      return map.mapUnits(ip(1) + "" + ip(0))
    else
      return map.mapTens(ip(1).toString)+" "+ map.mapUnits(ip(0).toString)
  }

  def checkHundreds(ip:String,i:Int):String={
    if(ip.toInt==0)
      return ""
    else if(i!=0)
      return map.mapUnits(ip(2).toString)+" hundred"
    else {
      if((ip(1)+""+ip(0)).toInt==0)
        return map.mapUnits(ip(2).toString)+" hundred"
      else
        return map.mapUnits(ip(2).toString)+" hundred and "
    }
  }

  def checkPlaces(ip:String,i:Int):String={
    if(ip.toInt==0)
      return ""
    else
      return " "+map.arrayPlace(i.toString)+" "
  }

}
