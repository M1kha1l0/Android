package com.example.firstandroidproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstandroidproject.ui.theme.FirstAndroidProjectTheme
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAndroidProjectTheme {
                var context = LocalContext.current
                var a by remember{ mutableStateOf(0) }
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Spacer(modifier = Modifier.height(325.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                            Greeting(name = a.toString())
                        }

                    Spacer(modifier = Modifier.height(160.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                        Button(onClick = { a++ }) {
                            Text(text ="+1" )
                        }
                        Button(onClick = { a-- }) {
                            Text(text = "-1")
                        }
                        Button(onClick = { a = a * 2 }) {
                            Text(text = "*2")
                        }
                        Button(onClick = {
                            if(a % 3 == 0) a = a / 3
                            else {
                                Toast.makeText(context, "НЕ ДЕЛИТСЯ", Toast.LENGTH_SHORT).show()
                            }
                        }) {
                            Text(text = "/3")
                        }
                }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name", fontSize = 40.sp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstAndroidProjectTheme {
        Greeting("Android")
    }
}
