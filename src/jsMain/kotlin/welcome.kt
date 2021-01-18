import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import styled.css
import styled.styledDiv
import styled.styledInput

external interface WelcomeProps : RProps {
  var name: String
}

data class WelcomeState(val name: String) : RState

external interface InputProps : RProps {
  var name: String
  var onClick: (String) -> Unit
}

val userInput = functionalComponent<InputProps> { props ->
  styledInput {
    css {
      +WelcomeStyles.textInput
    }
    attrs {
      type = InputType.text
      value = props.name
      onChangeFunction = { event -> props.onClick((event.target as HTMLInputElement).value) }
    }
  }
}

fun RBuilder.userInput(handler: InputProps.() -> Unit) = child(userInput) {
  attrs {
    handler()
  }
}

val userOutput = functionalComponent<WelcomeProps> { props ->
  styledDiv {
    css {
      +WelcomeStyles.textContainer
    }
    +"Hello, ${props.name}"
  }
}

@JsExport
val welcome = functionalComponent<WelcomeProps> { props ->

  val (state, setState) = useState(props.name)

  child(userOutput) {
    attrs.name = state
  }
  userInput {
    name = state
    onClick = setState
  }
  child(userOutput) {
    attrs.name = state
  }
}
