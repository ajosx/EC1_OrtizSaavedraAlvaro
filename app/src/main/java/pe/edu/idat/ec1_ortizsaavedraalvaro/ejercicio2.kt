package pe.edu.idat.ec1_ortizsaavedraalvaro

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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun pregunta2(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 40.dp)) {
        var num1 by rememberSaveable {
            mutableStateOf("")
        }
        var num2 by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(text = "Calculadora Mágica",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
            espacion(tamanio = 12)
            OutlinedTextField(value = num1,
                onValueChange = {num1 = it},
                modifier = Modifier.fillMaxWidth(),
                label ={Text(text = "Ingrese un primer número al azar")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            espacion(tamanio = 12)
            OutlinedTextField(value = num2,
                onValueChange = {num2 = it},
                modifier = Modifier.fillMaxWidth(),
                label ={Text(text = "Ingrese un segundo número al azar")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            espacion(tamanio = 12)

            Button(onClick = {
                resultado = calculaimc(num1.toDouble(),num2.toDouble())
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            espacion(tamanio = 12)
            Text(text = resultado)
        }
    }
}

fun calculaimc(num1: Double, num2: Double): String {
    var opera1 = num1 * num2
    var opera2 = num1 - num2
    var opera3 = num1 + num2
    var respuesta = 0.0
    if(num1 == num2){
        respuesta = opera1
    }else if(num1 > num2){
        respuesta = opera2
    }else {
        respuesta = opera3
    }
    return "El resultado es: $respuesta"
}