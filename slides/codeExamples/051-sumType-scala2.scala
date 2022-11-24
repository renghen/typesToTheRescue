sealed trait State

class Solid(name: String, tensile:Long) extends State
class Liquid(name :String) extends  State
class Gas(name: String, compressRatio : Double) extends State