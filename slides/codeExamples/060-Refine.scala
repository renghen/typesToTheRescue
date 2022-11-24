//exmaple taken from https://blog.rockthejvm.com/refined-types/

// traditional 
case class User(name: String, email: String)

val daniel = User("Daniel", "daniel@rockthejvm.com")
val noDaniel = User("daniel@rockthejvm.com", "Daniel") // you can interchange variable, compiler does not know

import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._

val aPositiveInteger: Refined[Int, Positive] = 42
val aNegativeInteger: Refined[Int, Positive] = -100 // does not compile

val aNegative: Int Refined Negative = -100
val nonNegative: Int Refined NonNegative = 0
val anOdd: Int Refined Odd = 3
val anEven: Int Refined Even = 68

import eu.timepit.refined.W
//W means Witness
val smallEnough: Int Refined LessThan[W.`100`.T] = 45

// string must end with $
import eu.timepit.refined.string._
val commandPrompt: String refined EndsWith[W.`"$"`.T] = "daniel@mbp $"

// now we use constraints on the string
type Email = String Refined MatchesRegex[W.`"""[a-z0-9]+@[a-z0-9]+\\.[a-z0-9]{2,}"""`.T]
type SimpleName = String Refined MatchesRegex[W.`"""[A-Z][a-z]+"""`.T]
case class ProperUser(name: SimpleName, email: Email)

val daniel = ProperUser("Daniel", "daniel@rockthejvm.com")
// val noDaniel = ProperUser("daniel@rockthejvm.com", "Daniel") // doesn't compile


// Refining at Runtime
import eu.timepit.refined.api.RefType

val poorEmail = "daniel"
val refineCheck = RefType.applyRef[Email](poorEmail) // returns either a right value or an error