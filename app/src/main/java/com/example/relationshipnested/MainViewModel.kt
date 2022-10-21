package com.example.relationshipnested

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.relationshipnested.config.DBRelationships
import com.example.relationshipnested.mocks.dashboardMock
import kotlinx.coroutines.launch

class MainViewModel(app: Application):AndroidViewModel(app) {

    private val TAG = MainViewModel::class.java.name
    private val db = DBRelationships.getInstance( app )
    private val dashboardDao = db.dashboardDao()

    fun createDb(){
        Log.i(TAG,"Crear DB")
        viewModelScope.launch {
            dashboardDao.saveDashboardInformation(dashboardMock)
        }
    }

    fun truncateDB(){
        Log.i(TAG,"Crear DB")
    }
}