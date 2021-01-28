import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.a
import react.dom.br
import react.dom.h1
import react.dom.input
import styled.css
import styled.styledDiv as div

private val scope = MainScope()

data class PioneersState(val pioneers: List<Person>, val personFilter: String) : RState

@JsExport
val pioneers = functionalComponent<RProps> { _ ->
  val (state, setState) = useState(PioneersState(emptyList(), ""))

  useEffect(dependencies = listOf()) {
    scope.launch {
      setState(PioneersState(getPioneers(), ""))
    }
  }

  h1 {
    +"Space Pioneers"
  }

  div {
    a(href="/planets.html") {
      +"Solar System Planets"
    }
    br {  }
    br {  }
  }

  input(InputType.search) {
    attrs {
      placeholder = "search..."
      onChangeFunction = { event -> setState(PioneersState(state.pioneers, (event.target as HTMLInputElement).value))}
    }
  }

  div {
    css {
      display = Display.grid
      gap= Gap("10px")
      gridTemplateColumns= GridTemplateColumns(1.fr, 1.fr, 1.fr, 1.fr)
    }
    child(PersonList::class) {
      attrs {
        people = state.pioneers.filter {
          it.asText().toLowerCase().contains(state.personFilter.toLowerCase())
        }
      }
    }
  }
}

fun Person.asText() = "$name $born $died"