package dk.cphbusiness.template

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_pet.view.*
import org.jetbrains.anko.onFocusChange
import org.jetbrains.anko.onKey
import org.jetbrains.anko.toast


class PetListAdapter(context: Context, val pets: List<Pet>) :
        ArrayAdapter<Pet>(context, 0, pets) {

    override fun getView(position: Int, template: View?, parent: ViewGroup): View {
        val pet = pets[position]
        val view = template ?: LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_pet, parent, false)
//                if (template == null)
//                    LayoutInflater
//                            .from(context)
//                            .inflate(R.layout.item_pet, parent, false)
//                else template
        view.editName.setText(pet.name)
        view.editAge.setText(pet.age.toString())
        view.editName.onKey { v, i, event ->
            pet.name = v.editName.text.toString()
            false
            }
        return view
        }

    }