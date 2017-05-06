package dk.cphbusiness.template

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import kotlinx.android.synthetic.main.item_main.view.*

class MainCursorAdapter(context: Context, cursor: Cursor, flags: Int) :
        CursorAdapter(context, cursor, flags) {

    override fun newView(context: Context, cursor: Cursor, parent: ViewGroup): View {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_main, parent, false)
    }

    override fun bindView(view: View, context: Context, cursor: Cursor) {
        view.tag = cursor.getInt(DB.RecipeTable.id)
        view.textName.setText(cursor.getString(DB.RecipeTable.name))
        view.textCategory.setText(cursor.getString(DB.RecipeTable.category))
    }

}

