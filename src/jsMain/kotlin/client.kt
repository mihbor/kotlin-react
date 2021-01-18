import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
  window.onload = {
    document.getElementById("root")?.also { it.innerHTML = "" }
    render(document.getElementById("root")) {
      child(Welcome::class) {
        attrs {
          name = "Kotlin/JS"
        }
      }
    }
  }
}
