package dk.cphbusiness.template

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class MainActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    override fun onResume() {
        super.onResume()
        listAdapter = SimpleAdapter(
                this,
                data.Recipes.map {
                    p -> mapOf(
                        "name" to p.name,
                        "category" to p.category
                        ) },
                R.layout.item_main,
                arrayOf("name", "category"),
                intArrayOf(R.id.textName, R.id.textCategory)
                )
        }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        startActivity(intentFor<RecipeActivity>("position" to position))
        }

    }
