import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.br
import react.dom.h1
import react.dom.input
import react.router.dom.routeLink
import styled.css
import styled.styledDiv as div

private val scope = MainScope()

data class SolarSystemState(val planets: List<Planet>, val planetFilter: String)

@JsExport
val solarSystem = functionalComponent<RProps> {
  val (state, setState) = useState(SolarSystemState(emptyList(), ""))

  useEffect(dependencies = listOf()) {
    scope.launch {
      setState(SolarSystemState(getPlanets(), ""))
    }
  }

  h1 {
    +"Solar System Planets"
  }

  div {
    routeLink(to="/pioneers.html") {
      +"Space Pioneers"
    }
    +" | "
    routeLink(to="/spacecraft.html") {
      +"Spacecraft"
    }
    br {  }
    br {  }
  }

  input(InputType.search) {
    attrs {
      placeholder = "search..."
      onChangeFunction = { event -> setState(SolarSystemState(state.planets, (event.target as HTMLInputElement).value))}
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
          it.asText().toLowerCase().contains(state.planetFilter.toLowerCase())
        }
      }
    }
  }
}

fun Planet.asText() = name + " " + moons.joinToString(" ")