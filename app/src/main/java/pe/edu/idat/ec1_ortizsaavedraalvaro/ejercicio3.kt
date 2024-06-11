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
fun pregunt3(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 40.dp)) {
        var num by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(text = "Mes de Año",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
            espacion(tamanio = 12)
            OutlinedTextField(value = num,
                onValueChange = {num = it},
                modifier = Modifier.fillMaxWidth(),
                label ={Text(text = "Ingrese un número entre 1 y 12")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            espacion(tamanio = 12)

            Button(onClick = {
                resultado = mes1(num.toInt())
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            espacion(tamanio = 12)
            Text(text = resultado)
        }
    }
}

fun mes1(num: Int): String {
    var n = num
    var respuesta = ""
    if(n == 1){
        respuesta = "ENERO"
    }else if(n == 2){
        respuesta = "FEBRERO"
    }else if(n == 3){
        respuesta = "MARZO"
    }else if(n == 4){
        respuesta = "ABRIL"
    }else if(n == 5){
        respuesta = "MAYO"
    }else if(n == 6){
        respuesta = "JUNIO"
    }else if(n == 7){
        respuesta = "JULIO"
    }else if(n == 8){
        respuesta = "AGOSTO"
    }else if(n == 9){
        respuesta = "SEPTIEMBRE"
    }else if(n == 10){
        respuesta = "OCTUBRE"
    }else if(n == 11){
        respuesta = "NOVIEMBRE"
    }else if(n == 12){
        respuesta = "DICIEMBRE"
    }
    else {
        respuesta = "Incorrecto, vuelve a intentar"
    }
    return "El mes es: $respuesta"
}