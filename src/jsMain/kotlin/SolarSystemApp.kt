import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.h1
import react.dom.input
import styled.css
import styled.styledDiv as div

private val scope = MainScope()

data class AppState(val planets: List<Planet>, val planetFilter: String) : RState

@JsExport
val solarSystem = functionalComponent<RProps> { _ ->
  val (state, setState) = useState(AppState(emptyList(), ""))

  useEffect(dependencies = listOf()) {
    scope.launch {
      setState(AppState(getPlanets(), ""))
    }
  }

  h1 {
    +"Solar System Planets"
  }

  input(InputType.search) {
    attrs {
      placeholder = "search..."
      onChangeFunction = { event -> setState(AppState(state.planets, (event.target as HTMLInputElement).value))}
    }
  }

  div {
    css {
      display = Display.grid
      gap=Gap("10px")
      gridTemplateColumns=GridTemplateColumns(1.fr, 1.fr, 1.fr, 1.fr)
    }
    child(PlanetList::class) {
      attrs {
        planets = state.planets.filter {
          it.name.toLowerCase().contains(state.planetFilter.toLowerCase())
        }
      }
    }
  }
}
