package university

import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import person.Person
import subject.Subject
import tornadofx.ViewModel
import java.awt.List

class UniHiT {

    val subjectsProperty = SimpleListProperty<SimpleObjectProperty<Subject>>()

    val universityProperty = SimpleObjectProperty<University>()

    val personProperty = SimpleListProperty<SimpleObjectProperty<Person>>()

}

class UniHiTViewModel(val uniHiT: UniHiT): ViewModel(){
    var university = bind {uniHiT.universityProperty  }
    var subject = bind {uniHiT.subjectsProperty}
    var person = bind {uniHiT.personProperty  }

    init{
        university.set(University("Lion Institute", 100000f))

        addSubject("IDV", "IDV303", 100, 40, 300f)
        addSubject("IXT", "IXT303", 100, 40, 300f)

        addPerson("Jake", 0)

        addPerson("Jake", 1)

        addPerson("Jake", 2)

        addPerson("Jake", 3)


    }

    fun start(){

    }

    fun getUniName(): String{
        return university.value.nameProperty.value
    }

    fun getSubjectsCount(): Int{
        return subject.size
    }

    fun getDiStudentCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 0){
                count++
            }
        }
        return count
    }

    fun getDeStudentCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 1){
                count++
            }
        }
        return count
    }

    fun getAcStaffCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 2){
                count++
            }
        }
        return count
    }

    fun getAdStaffCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 3){
                count++
            }
        }
        return count
    }

    fun GetPeopleByNo(number:Int): Person{
        return person[number].value
    }


    fun getAllPeople(): Int{
        return person.size
    }

    fun getName(){
        println(subject[0].value.nameProperty)
        println(person.size)
        println(university.value.nameProperty.value)
    }

    fun addPerson(name: String, type: Int){
        var position = person.size
        person.value.add(SimpleObjectProperty(Person(position, name, type)))
        position++

    }

    fun addSubject(name: String, code: String,  credits: Int, hours: Int,  price: Float){
        subject.value.add(SimpleObjectProperty(Subject(name,code,credits,hours,price)))

    }

    fun search(data:String){

        for (student in person){
            if (student.value.id.toString() == data){
                println( student.value.name + " ID: " + student.value.id.toString()+ " Type: " + student.value.type.toString())
            }
            if (student.value.name.toLowerCase() == data.toLowerCase()){
                println( student.value.name + " ID: " + student.value.id.toString()+ " Type: " + student.value.type.toString())
            }
        }
    }




}