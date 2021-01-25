import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.*
import styled.css
import styled.styledDiv as div
import styled.styledSpan as span
import styled.styledInput

external interface NameProps : RProps {
  var name: String
}

external interface EditableNameProps : RProps {
  var name: String
  var setName: (String) -> Unit
}

val userInput = functionalComponent<EditableNameProps> { props ->
  styledInput {
    css {
      +WelcomeStyles.textInput
    }
    attrs {
      type = InputType.text
      value = props.name
      onChangeFunction = { event -> props.setName((event.target as HTMLInputElement).value) }
    }
  }
}

fun RBuilder.chars(handler: EditableNameProps.() -> Unit) = child(chars) { attrs { handler() } }

fun RBuilder.userInput(handler: EditableNameProps.() -> Unit) = child(userInput) { attrs { handler() } }

fun RBuilder.inputValidation(handler: EditableNameProps.() -> Unit) = child(inputValidation) { attrs { handler() } }

val inputValidation = functionalComponent<EditableNameProps> { props ->
  div {
    if (props.name.length < 5) {
      +"text too short!"
    } else if (props.name.length > 20) {
      +"text too long!"
    } else {
      chars {
        name = props.name
        setName = props.setName
      }
    }
  }
}

val userOutput = functionalComponent<NameProps> { props ->
  div {
    css {
      +WelcomeStyles.textContainer
    }
    +"Hello, ${props.name}"
  }
}

val chars = functionalComponent<EditableNameProps> { props ->

  fun removeChar(index: Int) {
    props.setName(props.name.removeRange(index, index+1))
  }
  props.name.mapIndexed { i, c ->
    span {
      key = i.toString()
      +c.toString()
      attrs {
        onClickFunction = { event -> removeChar(i) }
      }
    }
  }
}

@JsExport
val welcome = functionalComponent<NameProps> { props ->

  val (state, setState) = useState(props.name)

  child(userOutput) {
    attrs.name = state
  }
  userInput {
    name = state
    setName = setState
  }
  inputValidation {
    name = state
    setName = setState
  }
}
