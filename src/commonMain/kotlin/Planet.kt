import kotlinx.serialization.Serializable

@Serializable
data class Planet(val name: String, val image: String, val wiki: String)
