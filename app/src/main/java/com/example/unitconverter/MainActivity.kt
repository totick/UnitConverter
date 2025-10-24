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
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }

    fun handleUnitChange(unitName: String, unitType: String){
        if(unitType == "Input"){
            inputUnit = unitName
            inExpanded = false
        }else{
            outputUnit = unitName
            outExpanded = false
        }
    }

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
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDropDown")
                }
                DropdownMenu(expanded = inExpanded, onDismissRequest = { inExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = { handleUnitChange("Centimeters", "Input") })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = { handleUnitChange("Meters", "Input") })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { handleUnitChange("Feet", "Input") })
                    DropdownMenuItem(text = { Text("Millimeters") }, onClick = { handleUnitChange("Millimeters", "Input") })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            /* Output Box */
            Box {
                Button(onClick = { outExpanded = true }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDropDown")
                }
                DropdownMenu(expanded = outExpanded, onDismissRequest = { outExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {handleUnitChange("Centimeters", "Output")})
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {handleUnitChange("Meters", "Output")})
                    DropdownMenuItem(text = { Text("Feet") }, onClick = {handleUnitChange("Feet", "Output")})
                    DropdownMenuItem(text = { Text("Millimeters") }, onClick = {handleUnitChange("Millimeters", "Output")})
                }
            }
        }
    }
}