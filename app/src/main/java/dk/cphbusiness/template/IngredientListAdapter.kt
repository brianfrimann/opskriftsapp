package dk.cphbusiness.template

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_ingredients.*
import kotlinx.android.synthetic.main.activity_ingredients.view.*
import kotlinx.android.synthetic.main.item_action.view.*
import kotlinx.android.synthetic.main.item_ingredient.*
import kotlinx.android.synthetic.main.item_ingredient.view.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.onFocusChange
import org.jetbrains.anko.onKey
import org.jetbrains.anko.toast


class IngredientListAdapter(context: Context, val ingredients: List<Ingredient>) :
        ArrayAdapter<Ingredient>(context, 0, ingredients) {

    override fun getView(position: Int, template: View?, parent: ViewGroup): View {
        val ingredient = ingredients[position]
        val view = template ?: LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_ingredient, parent, false)
        view.editIngredientName.setText(ingredient.ingredientTxt)
        view.editAmount.setText(ingredient.amount.toString())
        view.editMessure.setText(ingredient.measure)
        view.editIngredientName.onKey { v, i, event ->
            ingredient.ingredientTxt = v.editIngredientName.text.toString()
            false
            }
//        view.personsButton.onClick {
//            view.editAmount.setText((view.editPersons.toString().toInt() * view.editAmount.toString().toInt()).toString())
//        }
        return view
        }
    }