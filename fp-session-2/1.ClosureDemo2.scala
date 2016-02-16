  object Foo {
    def closureDemo(f:(String) => Unit, name:String){
      f(name)
    }
  }


object HelloWorld extends App {

  var hello = "HELLO !!"

  def sayHello(name:String){
    println(s"$hello $name")
  }


  Foo.closureDemo(sayHello, "WWC KL !")
  hello = "EHLO !!"
  Foo.closureDemo(sayHello, "WWC KL !")

}

HelloWorld.main(Array())
