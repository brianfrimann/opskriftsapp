package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.item_action.*
import org.jetbrains.anko.*
import java.sql.Time
import java.util.*
import kotlin.concurrent.timer

class RecipeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val position = intent.getIntExtra("position", -1)
        okButton.onClick {
            if (position == -1) {
                toast("Funktionalitet mangler")
            } else {
                val recipe = data.Recipes[position]
                recipe.name = editRecipeName.text.toString()
                recipe.category = editCategory.text.toString()
            }
            finish()
        }
        if (position == -1) longToast("Funktionalitet mangler")
        else {
            val recipe = data.Recipes[position]
            editRecipeName.setText(recipe.name)
            editCategory.setText(recipe.category)
            listActions.adapter = ActionListAdapter(this, recipe.actions)
        }

        ingredientsButton.onClick {
            startActivity(intentFor<IngredientsActivity>("position" to position))
        }
    }
}