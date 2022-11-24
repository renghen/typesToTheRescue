case class Post(title:String, body : String, tags: List[String])
case class Addr(street:String, city : String, zip:String, tags: List[String])

object Processing{
  def format(args : {def tags:List[String]}) = {
    println(tags.mkString(","))
  }
}