//exmaple taken from https://blog.rockthejvm.com/refined-types/

object MyMath:

  opaque type Logarithm = Double

  object Logarithm:

    // These are the two ways to lift to the Logarithm type

    def apply(d: Double): Logarithm = math.log(d)

    def safe(d: Double): Option[Logarithm] =
      if d > 0.0 then Some(math.log(d)) else None

  end Logarithm

  // Extension methods define opaque types' public APIs
  extension (x: Logarithm)
    def toDouble: Double = math.exp(x)
    def + (y: Logarithm): Logarithm = Logarithm(math.exp(x) + math.exp(y))
    def * (y: Logarithm): Logarithm = x + y

end MyMath

// import MyMath.*
// val test = Logarithm(10.0)
// test + 10 // does not compile
// test + 10.0 // does not compile
// test + Logarithm(10.0) // compiles

