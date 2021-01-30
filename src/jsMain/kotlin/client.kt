import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.child

fun main() {
  window.onload = {
    document.getElementById("planets")
      ?.also { it.innerHTML = "" }
      ?.also {
        render(it) {
          child(solarSystem) { }
        }
      }
    document.getElementById("pioneers")
      ?.also { it.innerHTML = "" }
      ?.also {
        render(it) {
          child(pioneers) { }
        }
      }
    document.getElementById("spacecraft")
      ?.also { it.innerHTML = "" }
      ?.also {
        render(it) {
          child(spacecraft) { }
        }
      }
  }
}
