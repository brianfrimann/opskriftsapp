package dk.cphbusiness.template

data class Pet(val name: String, var age: Int)

data class Person(
        var firstName: String,
        var lastName: String,
        var email: String,
        val pets: MutableList<Pet> = mutableListOf()
        )

object data {
    val people = mutableListOf<Person>()

    init {
        val kurt = Person("Kurt", "Hansen", "kurt@hansen.dk")
        val sonja = Person("Sonja", "Petterson", "sonja@petterson.se")
        val ib = Person("Ib", "Nebukanezer", "mail@ib.dk")

        kurt.pets.add(Pet("Rufus", 5))
        kurt.pets.add(Pet("King", 7))

        sonja.pets.add(Pet("Felix", 10))
        sonja.pets.add(Pet("Misser", 8))
        sonja.pets.add(Pet("Pusser", 12))

        ib.pets.add(Pet("Ninus", 12))

        people.add(kurt)
        people.add(sonja)
        people.add(ib)

        }
    }