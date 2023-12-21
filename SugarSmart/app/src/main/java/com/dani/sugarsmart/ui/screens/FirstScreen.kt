package com.dani.sugarsmart.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dani.sugarsmart.R
import com.dani.sugarsmart.ui.screens.destinations.LoginScreenDestination
import com.dani.sugarsmart.ui.screens.destinations.RegistrationScreenDestination
import com.dani.sugarsmart.ui.viewmodels.StartViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
@RootNavGraph(start = true)
fun FirstScreen(navigator: DestinationsNavigator) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(32.dp)),
                        painter = painterResource(id = R.drawable.first_sc_img),
                        contentDescription = "First screen image",
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "SugarSmart",
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Column(
                    modifier = Modifier.padding(32.dp)
                ) {
                    FilledTonalButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            navigator.navigate(LoginScreenDestination)
                        }
                    ) {
                        Text("Вход")
                    }

                    FilledTonalButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            navigator.navigate(RegistrationScreenDestination)
                        }
                    ) {
                        Text("Регистрация")
                    }
                }
            }
        }
    }
}