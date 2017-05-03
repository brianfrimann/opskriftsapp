package dk.cphbusiness.template

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class RecipeDbHelper(context: Context = App.instance) : ManagedSQLiteOpenHelper(
        context,
        DB.name,
        null,
        8) {
    companion object {
        val instance by lazy { RecipeDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(DB.RecipeTable.tableName, true,
                DB.RecipeTable.id to INTEGER + PRIMARY_KEY,
                DB.RecipeTable.name to TEXT,
                DB.RecipeTable.category to TEXT
        )
        db.createTable(DB.ActionTable.tableName, true,
                DB.ActionTable.id to INTEGER + PRIMARY_KEY,
                DB.ActionTable.fk to INTEGER,
                DB.ActionTable.actionTxt to TEXT,
                DB.ActionTable.time to INTEGER
        )
        db.createTable(DB.IngredientTable.tableName, true,
                DB.IngredientTable.id to INTEGER + PRIMARY_KEY,
                DB.IngredientTable.fk to INTEGER,
                DB.IngredientTable.ingredientTxt to TEXT,
                DB.IngredientTable.measure to TEXT,
                DB.IngredientTable.amount to INTEGER
        )
        initData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(DB.IngredientTable.tableName)
        db.dropTable(DB.ActionTable.tableName)
        db.dropTable(DB.RecipeTable.tableName)
        onCreate(db)
    }
}

object DB {
    val name = "RecipeDb"
    object RecipeTable {
        val tableName = "RECIPE"
        val id = "_id"
        val name = "name"
        val category = "category"
    }
    object ActionTable {
        val tableName = "ACTIONS"
        val id = "_id"
        val fk = "fk"
        val actionTxt = "actiontxt"
        val time = "time"
    }
    object IngredientTable {
        val tableName = "INGREDIENTS"
        val id = "_id"
        val fk = "fk"
        val ingredientTxt = "ingredienttxt"
        val measure = "measure"
        val amount = "amount"
    }
}

fun initData(db: SQLiteDatabase) {
    db.insert(DB.RecipeTable.tableName,
            DB.RecipeTable.id to 1,
            DB.RecipeTable.name to "Pandekager",
            DB.RecipeTable.category to "Dessert"
    )
    db.insert(DB.ActionTable.tableName,
            DB.ActionTable.id to 1,
            DB.ActionTable.fk to 1,
            DB.ActionTable.actionTxt to "Slå æg ud og kom mælk og mel i",
            DB.ActionTable.time to 0
    )
    db.insert(DB.ActionTable.tableName,
            DB.ActionTable.id to 2,
            DB.ActionTable.fk to 1,
            DB.ActionTable.actionTxt to "Bag på varm pande",
            DB.ActionTable.time to 2
    )
    db.insert(DB.IngredientTable.tableName,
            DB.IngredientTable.id to 1,
            DB.IngredientTable.fk to 1,
            DB.IngredientTable.ingredientTxt to "æg",
            DB.IngredientTable.amount to 2,
            DB.IngredientTable.measure to "stk"
    )
    db.insert(DB.IngredientTable.tableName,
            DB.IngredientTable.id to 2,
            DB.IngredientTable.fk to 1,
            DB.IngredientTable.ingredientTxt to "mel",
            DB.IngredientTable.amount to 2,
            DB.IngredientTable.measure to "spiseskeer"
    )
    db.insert(DB.IngredientTable.tableName,
            DB.IngredientTable.id to 3,
            DB.IngredientTable.fk to 1,
            DB.IngredientTable.ingredientTxt to "mælk",
            DB.IngredientTable.amount to 2,
            DB.IngredientTable.measure to "dl"
    )
}

fun Cursor.getString(columnName: String) =
        this.getString(this.getColumnIndex(columnName))

fun Cursor.getInt(columnName: String) =
        this.getInt(this.getColumnIndex(columnName))