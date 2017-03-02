package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_person.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class PersonActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        val position = intent.getIntExtra("position", -1)
        okButton.onClick {
            if (position == -1) {
                toast("Vi laver en ny")
                }
            else {
                val person = data.people[position]
                person.firstName = editFirstName.text.toString()
                person.lastName = editLastName.text.toString()
                person.email = editEmail.text.toString()
                }
            finish()
            }
        if (position == -1) longToast("Desværre")
        else {
            val person = data.people[position]
            editFirstName.setText(person.firstName)
            editLastName.setText(person.lastName)
            editEmail.setText(person.email)
            }
        }

    }
