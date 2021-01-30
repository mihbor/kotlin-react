import kotlinx.serialization.Serializable

@Serializable
data class Spacecraft(val name: String, val launched: String, val decommissioned: String, val image: String, val wiki: String)
