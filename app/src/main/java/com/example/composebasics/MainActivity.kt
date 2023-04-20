package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Row (verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello $name!")

            Spacer(modifier = Modifier.height(20.dp))

            Text("Here is another line!", modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))

            Text("Second line?!")

            Image(
                painter = painterResource(id = R.drawable.creature16),
                contentDescription = "creature",
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )

            Button(onClick = { /*TODO*/ }) {
                Text("This is the button")
            }

            MySimpleFilledTextExample()
            MyPasswordFilledTextExample()

        }
    }
}

@Composable
fun MySimpleFilledTextExample() {
    var text by remember {
        mutableStateOf("Hello")
    }

    TextField(value = text,
              onValueChange = { text = it},
              label = {
                    Text("Label: $text")
                })
}

@Composable
fun MyPasswordFilledTextExample() {
    var text by remember {
        mutableStateOf("Hello")
    }

    TextField(value = text,
        onValueChange = { text = it},
        label = {
            Text("Label:")
        },
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        Greeting("Android")
    }
}