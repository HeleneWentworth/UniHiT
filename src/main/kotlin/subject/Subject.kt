package subject

import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty

class Subject (var name: String, var code: String,  var credits: Int, var hours: Int, var price: Float){
    var nameProperty = SimpleStringProperty(this, "name", name)
    var codeProperty = SimpleStringProperty(this, "code", code)
    var creditsProperty = SimpleIntegerProperty(this, "credits", credits)
    var hoursProperty = SimpleIntegerProperty(this, "hours", hours)
    var priceProperty = SimpleFloatProperty(this, "price", price)

}