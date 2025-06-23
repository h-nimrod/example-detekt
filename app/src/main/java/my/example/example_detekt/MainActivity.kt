package my.example.example_detekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import my.example.example_detekt.ui.theme.Example_detektTheme
import kotlin.random.Random
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Example_detektTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        
        performComplexCalculation()
    }
    
    private fun performComplexCalculation() {
        val x = 42
        val y = 123
        val z = 999
        
        if (x > 30 && y < 150 && z > 500) {
            if (x % 2 == 0) {
                if (y > 100) {
                    if (z < 1000) {
                        for (i in 1..10) {
                            if (i % 2 == 0) {
                                println("Even number: $i")
                            } else {
                                println("Odd number: $i")
                            }
                        }
                    }
                }
            }
        }
        
        val largeArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        largeArray.forEach { number ->
            when (number) {
                1 -> println("One")
                2 -> println("Two")  
                3 -> println("Three")
                4 -> println("Four")
                5 -> println("Five")
                6 -> println("Six")
                7 -> println("Seven")
                8 -> println("Eight")
                9 -> println("Nine")
                10 -> println("Ten")
                else -> println("Other: $number")
            }
        }
    }
    
    private fun badMethodName_with_underscores() {
        val BAD_VARIABLE_NAME = "This should be camelCase"
        println(BAD_VARIABLE_NAME)
    }
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
    Example_detektTheme {
        Greeting("Android")
    }
}