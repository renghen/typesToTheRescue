case class MakeCoffee(id: Int, kind: String, addict: String)
case class CoffeeMade(id: Int, kind: String, forAddict: String, at: ZonedDateTime)

val command = MakeCoffee(id = Random.nextInt,
                         kind = "Espresso",
                         addict = "Piotr")
// MakeCoffee(?, "Espresso", "Piotr")

val event = CoffeeMade(id = command.id,
                       kind = command.kind,
                       forAddict = command.addict,
                       at = ZonedDateTime.now)

import io.scalaland.chimney.dsl._

val event = command.into[CoffeeMade]
  .withFieldComputed(_.at, _ => ZonedDateTime.now)
  .withFieldRenamed(_.addict, _.forAddict)
  .transform

// patching
case class User(id: Int, email: String, address: String, phone: Long)
case class UserUpdateForm(email: String, phone: Long)

val user = User(10, "abc@example.com", "Broadway", 123456789L)
val updateForm = UserUpdateForm("xyz@example.com", 123123123L)

user.patchUsing(updateForm)

//transformational 

case class Catterpillar(size: Int, name: String)
case class Butterfly(size: Int, name: String)

val stevie = Catterpillar(5, "Steve")
val steve = stevie.transformInto[Butterfly]

case class Youngs(insects: List[Catterpillar])
case class Adults(insects: List[Butterfly])

val kindergarden = Youngs(List(Catterpillar(5, "Steve"), Catterpillar(4, "Joe")))
val highschool = kindergarden.transformInto[Adults]

case class Catterpillar(size: Int, name: String)
case class Butterfly(size: Int, name: String, wingsColor: String)

val c = Catterpillar(5, "Steve")
val b = stevie.transformInto[Butterfly] // cannot compile, where is your wing color

val b = c.into[Butterfly]
  .withFieldConst(_.wingsColor, "white")
  .transform

val b = c.into[Butterfly]
  .withFieldComputed(_.wingsColor, c => if(c.size > 4) "yellow" else "gray")
  .transform  
