import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.h1
import react.dom.li
import react.dom.ul
import styled.css
import styled.styledDiv as div
import styled.styledSpan as span
import styled.styledInput

private val scope = MainScope()

@JsExport
val solarSystem = functionalComponent<RProps> { _ ->
  val (state, setState) = useState(emptyList<Planet>())

  useEffect(dependencies = listOf()) {
    scope.launch {
      setState(getPlanets())
    }
  }

  h1 {
    +"Solar System Planets"
  }

  ul {
    state.map {
      li {
        key = it.name
        +it.name
      }
    }
  }
}