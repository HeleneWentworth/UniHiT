package View

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.text.TextAlignment
import person.Person
import subject.Subject
import university.UniHiT
import university.UniversityViewModel

class UniversityView: View() {

    val universityViewModel = UniversityViewModel(UniHiT())


    override val root = vbox {
        val subject = universityViewModel.subject.value
        borderpane {

            left = vbox() {
                setPrefSize(200.0, 960.0)
                useMaxHeight = true

                label ("UniHiT"){
                    setPrefSize(200.0, 30.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (universityViewModel.getUniName()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label ("Subjects: " + universityViewModel.getSubjectsCount().toString()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }
                label ("Diploma Students: " + universityViewModel.getDiStudentCount().toString()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label ("Degree Students: " + universityViewModel.getDeStudentCount().toString()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label ("Academic Staff: " + universityViewModel.getAcStaffCount().toString()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label ("Administrative Staff: " + universityViewModel.getAdStaffCount().toString()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label ("All people: " + universityViewModel.getAllPeople().toString()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 12.0
                        marginBottom = 12.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(224, 224, 224)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                style{
                    backgroundColor += Color.rgb(125, 146, 158)
                }
            }

            top = vbox{
                setPrefSize(90.0, 30.0)
                useMaxWidth = true
                style{
                    backgroundColor += Color.rgb(125, 146, 158)
                }
            }


            center = vbox{
                setPrefSize(1000.0, 960.0)
                useMaxWidth = true
                style{
                    backgroundColor += Color.rgb(73, 89, 115)
                }

                borderpane {

                    left = vbox {
                        label ("Users"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }
                        val model = ViewModel()
                        val search = model.bind { SimpleStringProperty() }
                        form{
                            fieldset {
                                field("Search"){
                                    textfield(search)
                                }
                            }

                            button("Search") {
                                action {
                                    uniHiTViewModel.search(search.value.toString())
                                    println("Search")
                                    search.value = ""
                                }
                            }
                        }


                        tableview<Person> {
                            items = listOf(
                                Person(0,"Helene", 0),
                                Person(1,"Helene", 1),
                                Person(2,"Helene", 2),
                                Person(3,"Helene", 3)
                            ).observable()

                            column("ID",Person::idProperty)
                            column("NAME",Person::name)
                            column("TYPE",Person::type)
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                    right = vbox {
                        label ("Subjects"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        tableview<Subject> {
                            items = listOf(
                                    Subject("IXT", "IXT300", 40, 40, 40000f),
                                    Subject("IDV", "IDV300", 40, 40, 40000f),
                            Subject("LEANUX", "LX303", 20, 20, 10000f)

                            ).observable()

                            column("NAME",Subject::name)
                            column("CODE",Subject::code)
                            column("CREDITS",Subject::credits)
                            column("HOURS",Subject::hours)
                            column("PRICE",Subject::price)

                        }

                        setPrefSize(450.0, 302.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }

                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
                    }

                }

                borderpane {

                    left = vbox {
                        label ("Register people"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        val model = ViewModel()
                        val name = model.bind { SimpleStringProperty() }
                        val type = model.bind { SimpleStringProperty() }


                        form{
                            fieldset {
                                field("Name"){
                                    textfield(name)
                                }

                                field("Type"){
                                    textfield(type)
                                }
                            }

                            button("Add Person") {
                                action {
                                    println(universityViewModel.getAllPeople().toString() + " Before Add")
                                    universityViewModel.addPerson(name.value.toString(),type.value.toInt())
                                    println("Added Person")

                                    println(universityViewModel.getAllPeople().toString() + " After Add")
                                    name.value = ""
                                    type.value = ""

                                }
                            }
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                    right = vbox {
                        label ("new subjects"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }
                        val model = ViewModel()
                        val name = model.bind { SimpleStringProperty() }
                        val code = model.bind { SimpleStringProperty() }
                        val credits = model.bind { SimpleStringProperty() }
                        val hours = model.bind { SimpleStringProperty() }
                        val price = model.bind { SimpleStringProperty() }

                        form{
                            fieldset {
                                field("Name"){
                                    textfield(name)
                                }

                                field("Code"){
                                    textfield(code)
                                }
                                field("Credits"){
                                    textfield(credits)
                                }
                                field("Hours"){
                                    textfield(hours)
                                }
                                field("Price"){
                                    textfield(price)
                                }
                            }

                            button("Add Subject") {
                                action {
                                    println(universityViewModel.getSubjectsCount().toString() + " Before Add")
                                    universityViewModel.addSubject(name.value.toString(), code.value.toString(), credits.value.toInt(), hours.value.toInt(), price.value.toFloat())
                                    println("Added Person")

                                    println(universityViewModel.getSubjectsCount().toString() + " After Add")
                                    name.value = ""
                                    code.value = ""
                                    credits.value = ""
                                    hours.value = ""
                                    price.value = ""

                                }
                            }
                        }

                        setPrefSize(450.0, 302.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(28, 39, 43)
                        }
                    }

                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                    style{
                        backgroundColor += Color.rgb(132, 152, 188)
                    }

                }

                borderpane {

                    left = vbox {
                        label ("end Month"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }
                        label ("Students need to pay R" + universityViewModel.getMoneyFees().toString()){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        label ("Staff will be payed R" + universityViewModel.getStaffPayment().toString()){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }
                        var projection =   universityViewModel.getMoneyFees() - universityViewModel.getStaffPayment()
                        label ("End of Month R" + projection.toString()){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }
                        var poolProjected = universityViewModel.getUniversityPool() - universityViewModel.getStaffPayment() - universityViewModel.getMoneyFees()
                        label ("Pool Funds R" + poolProjected.toString()){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(28, 33, 40)
                        }
                    }
                    right = vbox {
                        label ("Add subject to people"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        val model = ViewModel()
                        val name = model.bind { SimpleStringProperty() }
                        val id = model.bind { SimpleStringProperty() }

                        form{
                            fieldset {
                                field("Persons Id"){
                                    textfield(name)
                                }

                                field("Subject Id"){
                                    textfield(id)
                                }
                            }

                            button("Add Subject") {
                                action {
                                    println(universityViewModel.getRegisteredSubjectCount().toString() + " Before Add")
                                    universityViewModel.addSubjectToPerson(name.value.toInt(),id.value.toInt())
                                    println("Added Person")

                                    println(universityViewModel.getRegisteredSubjectCount().toString() + " After Add")
                                    name.value = ""
                                    id.value = ""

                                }
                            }
                        }

                        setPrefSize(450.0, 302.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(28, 33, 40)
                        }
                    }

                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                    style{
                        backgroundColor += Color.rgb(132, 152, 188)
                    }

                }

            }
Well
        }
    }
}