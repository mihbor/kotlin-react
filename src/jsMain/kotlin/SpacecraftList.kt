import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.br
import styled.css
import styled.styledDiv as div
import styled.styledImg as img

external interface SpacecraftListProps : RProps {
  var spacecraft: List<Spacecraft>
}

class SpacecraftList(props: SpacecraftListProps) : RComponent<SpacecraftListProps, RState>(props) {
  override fun RBuilder.render() {
    props.spacecraft.map {
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
            maxWidth = 400.px
            maxHeight = 400.px
          }
        }
        div {
          +"First used: ${it.launched} "
          br { }
          +"End of mission: ${it.decommissioned}"
        }
        div {
          it.summary?.split("\n")?.map{
            +it
            br { }
          }
        }
      }
    }
  }

  override fun shouldComponentUpdate(nextProps: SpacecraftListProps, nextState: RState): Boolean {
    return props.spacecraft != nextProps.spacecraft
  }
}
