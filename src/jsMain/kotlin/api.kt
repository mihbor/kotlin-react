import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

import kotlinx.browser.window

val endpoint = window.location.origin // only needed until https://github.com/ktorio/ktor/issues/1695 is resolved

val jsonClient = HttpClient {
  install(JsonFeature) { serializer = KotlinxSerializer() }
}

suspend fun getPlanets() : List<Planet> {
  return jsonClient.get(endpoint + planetsPath)
}

suspend fun getPioneers() : List<Person> {
  return jsonClient.get(endpoint + pioneersPath)
}

suspend fun getSpacecraft() : List<Spacecraft> {
  return jsonClient.get(endpoint + spacecraftPath)
}
