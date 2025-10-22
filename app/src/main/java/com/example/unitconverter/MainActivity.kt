package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {
    var inputValue by remember { mutableStateOf("") }
    var inExpanded by remember { mutableStateOf(false) }
    var outExpanded by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize().padding(0.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = { inputValue = it }, label = { Text("Enter value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            /* Input Box */
            Box {
                Button(onClick = { inExpanded = true }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDropDown")
                }
                DropdownMenu(expanded = inExpanded, onDismissRequest = { inExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = { /*TODO*/})
                    DropdownMenuItem(text = { Text("Meters") }, onClick = { /*TODO*/})
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/})
                    DropdownMenuItem(text = { Text("Millimeters") }, onClick = { /*TODO*/})
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            /* Output Box */
            Box {
                Button(onClick = { outExpanded = true }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDropDown")
                }
                DropdownMenu(expanded = outExpanded, onDismissRequest = { outExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = { /*TODO*/})
                    DropdownMenuItem(text = { Text("Meters") }, onClick = { /*TODO*/})
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/})
                    DropdownMenuItem(text = { Text("Millimeters") }, onClick = { /*TODO*/})
                }
            }
        }
    }
}