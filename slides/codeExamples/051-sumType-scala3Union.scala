case class UserName(name: String)
case class Password(hash: Hash)

def help(id: UserName | Password) =
  val user = id match
    case UserName(name) => lookupName(name)
    case Password(hash) => lookupPassword(hash)

val rand = new scala.util.Random
val random = rand.nextInt()

val either: Password | UserName = if ((random % 2) == 0) then name else password
