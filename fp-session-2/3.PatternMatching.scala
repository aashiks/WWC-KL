def monthString(month:Int) = month match {
  case 1 => "January"
  case 2 => "February"
  case 3 => "March"
  case 4 => "April"
  case 5 => "May"
  case 6 => "June"
  case 7 => "July"
  case 8 => "August"
  case 9 => "September"
  case 10 => "October"
  case 11 => "November"
  case 12 => "December"
  case _ => "What are you talking about ?"
}

def getType(obj:AnyRef) = obj match {
  case o:String => "String"
  case l:List[_] => "List"
  case a:Array[_] => "Array"
  case _ => "Dunno !"
}


println(monthString(13))


println(getType("String"))
println(getType(Nil))
println(getType(Array()))
