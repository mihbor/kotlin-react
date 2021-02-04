import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.child
import react.router.dom.browserRouter
import react.router.dom.route

fun main() {
  window.onload = {
    document.getElementById("root")
      ?.also { it.innerHTML = "" }
      ?.also {
        render(it) {
          browserRouter {
            route("/", exact = true) {
              child(solarSystem) { }
            }
            route("/planets.html") {
              child(solarSystem) { }
            }
            route("/pioneers.html") {
              child(pioneers) { }
            }
            route("/spacecraft.html") {
              child(spacecraft) { }
            }
          }
        }
      }
  }
}
