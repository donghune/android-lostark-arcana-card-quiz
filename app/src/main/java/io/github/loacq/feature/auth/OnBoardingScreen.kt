package io.github.loacq.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.loacq.R
import io.github.loacq.component.GoogleLoginButton
import io.github.loacq.design_system.theme.LostArkTheme

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    LostArkTheme(useDarkTheme = true) {
        OnBoardingScreen(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
    ) {
        Box(modifier.padding(horizontal = 16.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(52.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = stringResource(id = R.string.app_description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 56.dp)
            ) {
                GoogleLoginButton(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}