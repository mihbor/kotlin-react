import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
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

@JsExport
class UserInput(props: InputProps): RComponent<InputProps, RState>(props) {

  override fun RBuilder.render() {
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
}

@JsExport
class UserOutput(props: WelcomeProps): RComponent<WelcomeProps, RState>(props) {

  override fun RBuilder.render() {
    styledDiv {
      css {
        +WelcomeStyles.textContainer
      }
      +"Hello, ${props.name}"
    }
  }
}

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

  init {
    state = WelcomeState(props.name)
  }

  override fun RBuilder.render() {
    child(UserOutput::class) {
      attrs.name = state.name
    }
    child(UserInput::class) {
      attrs.name = state.name
      attrs.onClick = {
        setState(
          WelcomeState(name = it)
        )
      }
    }
    child(UserOutput::class) {
      attrs.name = state.name
    }
  }
}
