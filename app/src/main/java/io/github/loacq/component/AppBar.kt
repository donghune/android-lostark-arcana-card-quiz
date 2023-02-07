@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.loacq.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseUser

@Composable
fun LoaCqAppBar(modifier: Modifier = Modifier, firebaseUser: FirebaseUser) {
    TopAppBar(
        modifier = modifier,
        title = {
            Row(modifier = modifier) {
                Image(
                    modifier = Modifier.size(24.dp).align(CenterVertically),
                    imageVector = Icons.Filled.Person2,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(text = "${firebaseUser.displayName}님 어서오세요")
            }
        }
    )
}
