package dk.cphbusiness.template

data class Pet(var name: String, var age: Int)

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

        val brille = Pet("Brille", 3)
        val brille2 = Pet("Brille", 3)
        val linse = brille.copy(name = "Linse")

        kurt.pets.add(Pet("Rufus", 5))
        kurt.pets.add(Pet("King", 7))
        kurt.pets.add(brille)

        kurt.pets
                .filter { pet -> pet.age > 4 }
                .forEachIndexed { i, pet -> println("$pet is pet #$i") }

        sonja.pets.add(Pet("Felix", 10))
        sonja.pets.add(Pet("Misser", 8))
        sonja.pets.add(Pet("Pusser", 12))
        sonja.pets.add(brille)


        ib.pets.add(Pet("Ninus", 12))

        people.add(kurt)
        people.add(sonja)
        people.add(ib)

        }
    }