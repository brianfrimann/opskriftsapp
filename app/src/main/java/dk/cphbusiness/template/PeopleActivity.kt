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

class PeopleActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
        }

    override fun onResume() {
        super.onResume()
//        listAdapter = ArrayAdapter<Person>(
//                this,
//                android.R.layout.simple_list_item_1,
//                data.people
//                )
        listAdapter = SimpleAdapter(
                this,
                data.people.map {
                    p -> mapOf(
                        "firstName" to p.firstName,
                        "lastName" to p.lastName,
                        "email" to p.email
                        ) },
                R.layout.item_person,
                arrayOf("firstName", "lastName", "email"),
                intArrayOf(R.id.textFirstName, R.id.textLastName, R.id.textEmail)
                )
        }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
//        val intent = Intent(this, PersonActivity::class.java)
//        intent.putExtra("position", position)
//        startActivity(intent)
        startActivity(intentFor<PersonActivity>("position" to position))
        }

    }
