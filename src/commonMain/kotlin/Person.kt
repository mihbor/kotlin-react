import kotlinx.serialization.Serializable

@Serializable
data class Person(val name: String, val born: Int, val died: Int, val image: String, val wiki: String)