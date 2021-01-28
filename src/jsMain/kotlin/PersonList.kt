import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import styled.css
import styled.styledDiv as div
import styled.styledImg as img

external interface PersonListProps : RProps {
  var people: List<Person>
}

class PersonList(props: PersonListProps) : RComponent<PersonListProps, RState>(props) {
  override fun RBuilder.render() {
    props.people.map {
      div {
        css {
          textAlign = TextAlign.center
        }
        div {
          a(href=it.wiki, target="new") {
            key = it.name
            +it.name
          }
        }
        img(src=it.image){
          css {
            width = 400.px
          }
        }
        div {
          +"Born ${it.born} Died ${it.died}"
        }
      }
    }
  }

  override fun shouldComponentUpdate(nextProps: PersonListProps, nextState: RState): Boolean {
    return props.people != nextProps.people
  }
}
