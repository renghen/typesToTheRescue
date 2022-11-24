/**
  * classical
  */

trait DoorState
case class Open() extends DoorState
case class Closed() extends DoorState

case class Door(state: DoorState) {
  def open = state match {
    case _: Open => throw new DoorStateException("You cannot open a door thats already open")
    case _ => Door(Open())
  }
def close = state match {
    case _: Closed => throw new DoorStateException("You cannot close a door thats already closed")
    case _ => Door(Closed())
  }
}

//phantom menace
// in java marker interface
sealed trait DoorState
sealed trait Open extends DoorState
sealed trait Closed extends DoorState

case class Door[State <: DoorState](){
  def open(implicit ev: State =:= Closed) = Door[Open]()
  def close(implicit ev: State =:= Open) = Door[Closed]()
}

// Door[Open]().open

