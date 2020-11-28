package com.jeanbarrossilva.lauradata.extension

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.reflect.KClass

object RoomDatabaseX {
    fun <T : RoomDatabase> KClass<T>.from(context: Context, name: String = simpleName ?: "") =
        Room.databaseBuilder(context, this.java, name).allowMainThreadQueries().fallbackToDestructiveMigration().build()
}