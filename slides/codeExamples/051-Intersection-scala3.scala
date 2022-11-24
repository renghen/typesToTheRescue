trait Resettable:
  def reset(): Unit

trait Growable[T]:
  def add(t: T): Unit

def f(x: Resettable & Growable[String]) =
  x.reset()
  x.add("first")



@main def run = 
  // will not compile
  val r : Resettable = new Resettable: 
    def reset(): Unit = println("resetting ...") 
  
  val g : Growable[Int] = new Growable[Int]: 
    def add(t : Int): Unit = println(s"adding $t") 

  f(r)
  f(g)

