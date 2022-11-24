sealed interface State

data class Liquid(val name :String) : State
data class Solid(val name: String, val tensile:Long): State
data class Gas(val name: String, val compressRatio : Double): State
