import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RProps
import react.dom.*
import react.functionalComponent
import react.useEffect
import react.useState
import styled.css
import styled.styledDiv as div

private val scope = MainScope()

data class SpacecraftState(
  val spacecraft: List<Spacecraft>,
  val landers: List<Spacecraft>,
  val launchers: List<Spacecraft>,
  val spacecraftFilter: String
)

@JsExport
val spacecraft = functionalComponent<RProps> {
  val (state, setState) = useState(SpacecraftState(emptyList(), emptyList(), emptyList(),""))

  useEffect(dependencies = listOf()) {
    scope.launch {
      setState(SpacecraftState(getSpacecraft(), getLanders(), getLaunchers(), ""))
    }
  }

  h1 {
    +"Spacecraft"
  }

  div {
    a(href="/planets.html") {
      +"Solar System Planets"
    }
    +" | "
    a(href="/pioneers.html") {
      +"Space Pioneers"
    }
    br {  }
    br {  }
  }

  input(InputType.search) {
    attrs {
      placeholder = "search..."
      onChangeFunction = { event -> setState(SpacecraftState(state.spacecraft, state.landers, state.launchers, (event.target as HTMLInputElement).value))}
    }
  }

  div {
    css {
      display = Display.grid
      gap = Gap("10px")
      gridTemplateColumns = GridTemplateColumns(1.fr, 1.fr, 1.fr, 1.fr)
    }
    child(SpacecraftList::class) {
      attrs {
        spacecraft = state.spacecraft.filter {
          it.asText().toLowerCase().contains(state.spacecraftFilter.toLowerCase())
        }
      }
    }
  }
  hr { }
  h2 {
    +"Landers"
  }
  div {
    css {
      display = Display.grid
      gap = Gap("10px")
      gridTemplateColumns = GridTemplateColumns(1.fr, 1.fr, 1.fr, 1.fr)
    }
    child(SpacecraftList::class) {
      attrs {
        spacecraft = state.landers.filter {
          it.asText().toLowerCase().contains(state.spacecraftFilter.toLowerCase())
        }
      }
    }
  }
  hr { }
  h2 {
    +"Launchers"
  }
  div {
    css {
      display = Display.grid
      gap = Gap("10px")
      gridTemplateColumns = GridTemplateColumns(1.fr, 1.fr, 1.fr, 1.fr)
    }
    child(SpacecraftList::class) {
      attrs {
        spacecraft = state.launchers.filter {
          it.asText().toLowerCase().contains(state.spacecraftFilter.toLowerCase())
        }
      }
    }
  }
}

fun Spacecraft.asText() = "$name $launched $decommissioned"