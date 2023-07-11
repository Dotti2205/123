package com.example.turmacriacaodeapp.view

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.turmacriacaodeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(controleDeNavegacao: NavHostController) {

    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.iconealuno), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )

            Text(
                text = "Login"
            )
            Spacer(modifier = Modifier.size(20.dp))

            OutlinedTextField(
                value = login,
                onValueChange = { login = it },
                label = { Text(text = "login")}
            )
            Spacer(modifier = Modifier.size(20.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = {Text(text = "senha")})

            Spacer(modifier = Modifier.size(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick ={controleDeNavegacao.navigate("telaListaDeAlunos")},
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Entrar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}