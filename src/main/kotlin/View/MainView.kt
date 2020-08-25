
package View

import tornadofx.*

class MainView : View("UniHiT") {

    override val root = borderpane {

//        top(NeighborhoodView::class)
        left(UniversityView::class)
//        addClass(Styles.main)
    }

}