package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ingredients.*
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.item_ingredient.*
import org.jetbrains.anko.*

class IngredientsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        val position = intent.getIntExtra("position", -1)
        if (position == -1) longToast("Funktionalitet mangler")
        else {
            val recipe = data.Recipes[position]
            listIngridients.adapter = IngredientListAdapter(this, recipe.ingredients)
        }

        smsButton.onClick {
            sendSMS(editSms.text.toString(), data.Recipes[position].ingredients.toString())
        }

//        personsButton.onClick {
//            editAmount.setText((editPersons.toString().toInt() * editAmount.toString().toInt()).toString())
//        }
    }
}
