import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.respondHtml
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.response.*
import io.ktor.serialization.*
import kotlinx.html.*

fun main() {
  embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
    install(ContentNegotiation) {
      json()
    }
    install(CORS) {
      method(HttpMethod.Get)
      method(HttpMethod.Post)
      method(HttpMethod.Delete)
      anyHost()
    }
    install(Compression) {
      gzip()
    }
    routing {
      get(planetsPath) {
        call.respond(solarSystemPlanets)
      }
      get(pioneersPath) {
        call.respond(spacePioneers)
      }
      get(spacecraftPath) {
        call.respond(spacecraftList)
      }
      get(landersPath) {
        call.respond(landerList)
      }
      get(launchersPath) {
        call.respond(launcherList)
      }
      static("/static") {
        resources()
      }
      static {
        resource("/kotlin-react.js")
        resource("/{...}", "index.html")
      }
    }
  }.start(wait = true)
}