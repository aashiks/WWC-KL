val breakException = new RuntimeException("Break Exception !!")

def breakable(op: => Unit){
  try{
    op
  } catch {case _ : Throwable => }
}

def break = throw breakException

def install = {
  val env = System.getenv("JAVA_HOME")

  if(env == null) {
    println("No environment found")
    break
  }
  println("Found Scala home directory")

}


breakable(install)
