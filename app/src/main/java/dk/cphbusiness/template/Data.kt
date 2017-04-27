package dk.cphbusiness.template

data class Action(var actionTxt: String, var time: Int)

data class Ingredient(var ingredientTxt: String, var amount: Int, var measure: String)
    {
    override fun toString(): String = "$ingredientTxt : $amount $measure \n"
    }

data class Recipe(
        var name: String,
        var category: String,
        val actions: MutableList<Action> = mutableListOf(),
        val ingredients: MutableList<Ingredient> = mutableListOf()
        )

object data {
    val Recipes = mutableListOf<Recipe>()

    init {
        //Pandekager
        val pandekager = Recipe("Pandekager", "Dessert")

        pandekager.ingredients.add(Ingredient("æg", 2, "stk"))
        pandekager.ingredients.add(Ingredient("mel", 2, "spiseskeer"))
        pandekager.ingredients.add(Ingredient("mælk", 2, "dl"))

        pandekager.actions.add(Action("Slå æg ud og kom mælk og mel i", 0))
        pandekager.actions.add(Action("Bag på varm pande", 2))

        //Kødsovs
        val Kødsovs = Recipe("Kødsovs", "Hovedret")

        Kødsovs.ingredients.add(Ingredient("Hakket oksekøde", 250, "g"))
        Kødsovs.ingredients.add(Ingredient("Flåede tomater", 250, "g"))

        Kødsovs.actions.add(Action("Steg det hakkede oksekød", 10))
        Kødsovs.actions.add(Action("Tilsæt flåede tomat og kog ved svag varme", 30))

        Recipes.add(pandekager)
        Recipes.add(Kødsovs)
        }
    }