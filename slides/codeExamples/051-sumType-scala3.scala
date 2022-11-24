
enum Color(val rgb: Int):
  case Red   extends Color(0xFF0000)
  case Green extends Color(0x00FF00)
  case Blue  extends Color(0x0000FF)
  
enum State:
  case Solidname (name: String, tensile: Long)
  case Liquid(name :String)
  case Gas(name: String, compressRatio : Double)

enum Option[+T]:
  case Some(x: T)
  case None

  