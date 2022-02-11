package util

import mapper.UnitMap

class ValidateConversion {

  var map = new UnitMap

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
      return map.mapUnits(ip(2).toString)+" hundred "
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
