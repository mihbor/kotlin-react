import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.li
import react.dom.ol
import styled.css
import styled.styledDiv as div
import styled.styledImg as img

external interface PlanetListProps : RProps {
  var planets: List<Planet>
}

class PlanetList(props: PlanetListProps) : RComponent<PlanetListProps, RState>(props) {
  override fun RBuilder.render() {
    props.planets.map {
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
          css {
            width = 200.px
          }
          +"Moons:"
          ol {
            it.moons.map {
              li { +it }
            }
          }
        }
      }
    }
  }

  override fun shouldComponentUpdate(nextProps: PlanetListProps, nextState: RState): Boolean {
    return props.planets != nextProps.planets
  }
}
