package util

class InputValidator {

  def validateInput(input:String):Boolean ={
  if(input.toLong>1000000000)
  return true
  else
    return false

}
