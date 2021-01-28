import kotlinx.serialization.Serializable

@Serializable
data class Planet(val name: String, val image: String, val wiki: String, val moons: List<String>) {
  constructor(name: String, image: String, wiki: String, vararg moons: String) : this(name, image, wiki, moons.asList())
}
