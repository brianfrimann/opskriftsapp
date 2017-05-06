package dk.cphbusiness.template

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NewRecipeButton.onClick {
            startActivity(intentFor<RecipeActivity>("position" to -1))
        }
    }

    override fun onResume() {
        super.onResume()
//        RecipeDbHelper.instance.use {
//            val cursor = rawQuery("select * from ${DB.RecipeTable.tableName}", null)
//            listAdapter = MainCursorAdapter(this@MainActivity, cursor, 0)
//        }
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
//            val test = v.tag
//            if (test is Int)
//                startActivity(intentFor<RecipeActivity>("test" to test))
//           else toast("id is corrupt: ${test}")
            startActivity(intentFor<RecipeActivity>("position" to position))
        }

    }
