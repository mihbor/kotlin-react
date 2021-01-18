import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.child

fun main() {
  window.onload = {
    document.getElementById("root")?.also { it.innerHTML = "" }
    render(document.getElementById("root")) {
      child(welcome) {
        attrs.name = "Kotlin/JS"
      }
    }
  }
}
