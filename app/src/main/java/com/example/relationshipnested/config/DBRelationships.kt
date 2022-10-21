package com.example.relationshipnested.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.relationshipnested.daos.DashboardDao
import com.example.relationshipnested.entities.*

@Database(
    entities = [
        AlertEntity::class,
        BannerEntity::class,
        BubbleEntity::class,
        DashboardEntity::class,
        SectionEntity::class,
        ThemeEntity::class,
        WideCardEntity::class,
        WideCardFooterEntity::class,
        WidgetsGroupEntity::class,
    ],
    version = 1
)
abstract class DBRelationships: RoomDatabase(){

    abstract fun dashboardDao(): DashboardDao

    companion object {
        private var INSTANCE : DBRelationships? = null

        fun getInstance(context : Context) : DBRelationships {
            INSTANCE = INSTANCE ?: Room.databaseBuilder( context, DBRelationships::class.java, "baz_dashboard_db" )
                .fallbackToDestructiveMigration()
                //.allowMainThreadQueries()
                //.addCallback(roomCallback)
                .build()

            return INSTANCE!!
        }

        /*private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                // Poblar la BD en caso de ser necesario
            }
        }*/
    }
}