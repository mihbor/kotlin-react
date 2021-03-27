import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

import kotlinx.browser.window

val endpoint = window.location.origin // only needed until https://github.com/ktorio/ktor/issues/1695 is resolved

val jsonClient = HttpClient {
  install(JsonFeature) { serializer = KotlinxSerializer() }
}

private inline suspend fun <reified T>getOrDefault(path: String, default: T): T = try {
  jsonClient.get(endpoint + path)
} catch (e: Throwable) {
  console.log(e)
  default
}

suspend fun getPlanets() : List<Planet> = getOrDefault(planetsPath, solarSystemPlanets)

suspend fun getPioneers() : List<Person> = getOrDefault(pioneersPath, spacePioneers)

suspend fun getSpacecraft() : List<Spacecraft> = getOrDefault(spacecraftPath, spacecraftList)

suspend fun getLanders() : List<Spacecraft> = getOrDefault(landersPath, landerList)

suspend fun getLaunchers() : List<Spacecraft> = getOrDefault(launchersPath, launcherList)
