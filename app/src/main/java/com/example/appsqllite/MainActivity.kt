package com.example.appsqllite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appsqllite.ui.theme.AppSqlLiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun App() {
    AppSqlLiteTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(Modifier.height(80.dp)) {
                    MenuTopBar()
                }

                SimpleTextFieldSample("Nome:")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Endereço:")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Bairro:")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Cep:")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                ButtonSample()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun AppPreview() {
    App()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar() {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar( //barra do topo centralizada
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Black
                ),
                title = { //titulo
                    Column {
                        Text(text = "JetPack Compose", color = Color.White)
                        Text(text = "SQLite", color = Color.White, style = MaterialTheme.typography.labelSmall)
                    }
                },
                navigationIcon = { //icone de voltar
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, tint = Color.White, contentDescription = "")
                    }
                },
                actions = {//icone tres pontos
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.MoreVert, tint = Color.White, contentDescription = "")
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {

        }
    }
}

@Preview
@Composable
fun MenuTopBarPreview() {
    MenuTopBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextFieldSample(label: String) {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        singleLine = true
    )
}

@Preview
@Composable
fun SimpleTextFieldSamplePreview() {
    SimpleTextFieldSample("Nome:")
}

@Composable
fun ButtonSample() {
    Button(onClick = { /* Do something! */ }) { Text("Cadastrar") }
}

@Preview
@Composable
fun ButtonSamplePreview() {
    ButtonSample()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppSqlLiteTheme {
        Greeting("Android")
    }
}