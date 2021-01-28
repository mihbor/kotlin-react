import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.img
import styled.styledDiv as div

external interface PlanetListProps : RProps {
  var planets: List<Planet>
}

class PlanetList(props: PlanetListProps) : RComponent<PlanetListProps, RState>(props) {
  override fun RBuilder.render() {
    props.planets.map {
      div {
        a(href=it.wiki, target="new") {
          key = it.name
          +it.name
        }
        img(src=it.image){
          attrs {
            width = "400"
          }
        }
      }
    }
  }

  override fun shouldComponentUpdate(nextProps: PlanetListProps, nextState: RState): Boolean {
    return props.planets != nextProps.planets
  }
}
