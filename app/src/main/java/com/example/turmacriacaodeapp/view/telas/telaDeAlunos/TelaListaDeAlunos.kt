package com.example.turmacriacaodeapp.view.telas

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.turmacriacaodeapp.data.ListaDeAlunos
import com.example.turmacriacaodeapp.model.Aluno

@Composable
fun TelaListaDeAlunos(controleDeNavegacao: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn{
            items(ListaDeAlunos().carregarListaDeAlunos()){
                    aluno-> DiarioDeClasse (aluno=aluno)
            }
        }
    }
}
@Composable
fun DiarioDeClasse(

    aluno: Aluno
){

    var expandir by remember{ mutableStateOf(true) }

    Card(
        modifier = Modifier.padding(20.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column(
            modifier = Modifier
                .padding(20.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = aluno.foto),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                Column() {
                    Text(
                        text = aluno.nome,
                        modifier = Modifier,
                        fontSize = 15.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = aluno.curso,
                        modifier = Modifier,
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Icon(
                    imageVector =
                    if(expandir)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { expandir = !expandir }
                )
            }
            if (expandir)
                Spacer(modifier = Modifier.height(20.dp))

            Text(
                text =
                "Faltas: ${aluno.faltas}",
                fontSize = 15.sp
            )
            Text(
                text =
                "Nota: ${aluno.nota}",
                fontSize = 15.sp
            )
        }
    }
}
