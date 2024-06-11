package pe.edu.idat.ec1_ortizsaavedraalvaro

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign



@Composable
fun espacion(tamanio: Int){
    Spacer(modifier = Modifier.height(tamanio.dp))
}

@Composable
fun pregunta1(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 40.dp)){
        var indicador by rememberSaveable {
            mutableStateOf("")
        }
        var tasaalcohol by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(text = "Test de Alcoholemia",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
            espacion(tamanio = 12)
            OutlinedTextField(value = indicador, onValueChange = {indicador=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese Indicador: C, A, T o M")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

            espacion(tamanio = 12)
            OutlinedTextField(value = tasaalcohol, onValueChange = {tasaalcohol=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese Nivel de Alcohol")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            espacion(tamanio = 12)
            
            Button(onClick = {
                resultado = resultado1(indicador.toString(),tasaalcohol.toDouble())
            }, Modifier.fillMaxWidth()) {
                Text(text = "RESULTADO")
            }

            espacion(tamanio = 12)
            Text(text = resultado)
        }
    }
}

fun resultado1(indicador: String, tasaalcohol: Double): String {
    var indicador1 = indicador
    val tasaalcohol1 = tasaalcohol
    var resultado2 = ""
    var resultado3 = ""
    if(indicador1 == "C" || indicador1 == "c"){
        if(tasaalcohol1 >= 0.3){
            resultado3 = "Positivo"
        }else{resultado3 = "Negativo"}
        resultado2 = "Camión"
    }else if(indicador1 == "A" || indicador1 == "a"){
        if(tasaalcohol1 >= 0.3){
            resultado3 = "Positivo"
        }else{resultado3 = "Negativo"}
        resultado2 = "Autobus"
    }else if(indicador1 == "T" || indicador1 == "t"){
        if(tasaalcohol1 >= 0.5){
            resultado3 = "Positivo"
        }else{resultado3 = "Negativo"}
        resultado2 = "Turismo"
    }else if(indicador1 == "M" || indicador1 == "m"){
        if(tasaalcohol1 >= 0.3){
            resultado3 = "Positivo"
        }else{resultado3 = "Negativo"}
        resultado2 = "Motocicleta"
    }else{
        resultado2 = "Indicador incorrecto"
    }

    return "El veciculo intervnido es: $resultado2 y su test de alcoholemia es: $resultado3"
}

