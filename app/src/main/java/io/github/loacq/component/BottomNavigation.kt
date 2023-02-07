package io.github.loacq.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoaCqBottomNav(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Quiz,
                    contentDescription = null
                )
            },
            label = { Text(text = "Home") },
            onClick = {}
        )
        NavigationBarItem(
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null
                )
            },
            label = { Text(text = "Profile") },
            onClick = {}
        )
        NavigationBarItem(
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = null
                )
            },
            label = { Text(text = "Rank") },
            onClick = {}
        )
    }
}
