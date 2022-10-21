package com.example.relationshipnested.ui.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.relationshipnested.ui.theme.RelationShipNestedTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RelationShipNestedTheme {
        Greeting("Android")
    }
}