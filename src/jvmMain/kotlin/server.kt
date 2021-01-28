import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.respondHtml
import io.ktor.http.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.response.*
import io.ktor.serialization.*
import kotlinx.html.*

fun HTML.planets() {
  head {
    title("Kotlin React App")
  }
  body {
    div {
      id = "planets"
      +"Hello from Ktor! Loading ... "
    }
    script(src = "/static/scripts.js") {}
  }
}

fun HTML.pioneers() {
  head {
    title("Kotlin React App")
  }
  body {
    div {
      id = "pioneers"
      +"Hello from Ktor! Loading ... "
    }
    script(src = "/static/scripts.js") {}
  }
}

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
      get("/") {
        call.respondHtml(HttpStatusCode.OK, HTML::planets)
      }
      get("/planets.html") {
        call.respondHtml(HttpStatusCode.OK, HTML::planets)
      }
      get("/pioneers.html") {
        call.respondHtml(HttpStatusCode.OK, HTML::pioneers)
      }
      get(planetsPath) {
        call.respond(solarSystemPlanets)
      }
      get(pioneersPath) {
        call.respond(spacePioneers)
      }
      static("/static") {
        resources()
      }
    }
  }.start(wait = true)
}