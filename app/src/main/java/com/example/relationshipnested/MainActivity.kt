package com.example.relationshipnested

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.relationshipnested.ui.theme.RelationShipNestedTheme

class MainActivity : ComponentActivity() {

    private val TAG = MainActivity::class.java.name
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RelationShipNestedTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        mainViewModel.createDb()
                    }) {
                        Text(text = "Crear DB")
                    }
                    Button(onClick = {
                        mainViewModel.truncateDB()
                    }) {
                        Text(text = "Vaciar DB")
                    }
                }
            }
        }
    }
}