package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ingredients.*
import kotlinx.android.synthetic.main.activity_recipe.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class IngredientsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        val position = intent.getIntExtra("position", -1)
        if (position == -1) longToast("Desværre")
        else {
            val recipe = data.Recipes[position]
            listIngridients.adapter = IngredientListAdapter(this, recipe.ingredients)
            }
        }
    }
