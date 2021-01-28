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

fun HTML.index() {
  head {
    title("Kotlin React App")
  }
  body {
    div {
      id = "root"
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
        call.respondHtml(HttpStatusCode.OK, HTML::index)
      }
      get(planetsPath) {
        call.respond(solarSystemPlanets)
      }
      static("/static") {
        resources()
      }
    }
  }.start(wait = true)
}