package io.github.loacq.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.loacq.R
import io.github.loacq.design_system.theme.LostArkTheme

@Preview
@Composable
fun GoogleLoginButtonShortPreview() {
    LostArkTheme {
        GoogleLoginButton(Modifier.width(180.dp))
    }
}

@Preview
@Composable
fun GoogleLoginButtonLongPreview() {
    LostArkTheme {
        GoogleLoginButton(Modifier.width(360.dp))
    }
}

@Composable
fun GoogleLoginButton(modifier: Modifier = Modifier) {
    ElevatedButton(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = {}
    ) {
        Box {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.start_for_google),
                style = MaterialTheme.typography.titleMedium.copy(color = Color.Black),
                textAlign = TextAlign.Center
            )
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_login_google),
                contentDescription = null
            )
        }
    }
}