import kotlinx.serialization.Serializable

@Serializable
data class Planet(val name: String)

const val planetsPath = "/planets"