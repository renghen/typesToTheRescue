// NOT GADT
enum MyList[+T]:
  case Cons(head: T, tail: MyList[T])
  case Nil

// GADT  
enum Box[T](contents: T):
  case IntBox(n: Int) extends Box[Int](n)
  case BoolBox(b: Boolean) extends Box[Boolean](b)  

// Box[Int] | Box [Boolean]

// haskell example
// -- A GADT
// data Expr a where
//     EBool  :: Bool     -> Expr Bool
//     EInt   :: Int      -> Expr Int
//     EEqual :: Expr Int -> Expr Int  -> Expr Bool

enum Expr[a]:
  case ExprBool(value: Boolean) extends Expr[Boolean]
  case ExprInt(value: Int) extends Expr[Int]
  case ExprEqual(
      a: Expr[Int],
      b: Expr[Int]
    ) extends Expr[Boolean]
