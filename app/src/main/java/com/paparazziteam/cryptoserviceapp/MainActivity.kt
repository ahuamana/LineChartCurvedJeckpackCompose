package com.paparazziteam.cryptoserviceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paparazziteam.cryptoserviceapp.modules.LineChart
import com.paparazziteam.cryptoserviceapp.modules.LineChartCurved
import com.paparazziteam.cryptoserviceapp.modules.LineChartFullCurved
import com.paparazziteam.cryptoserviceapp.ui.theme.CryptoServiceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllChartsCrypto()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AllChartsCrypto(){
    CryptoServiceAppTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            LineChart(dataPoints = listOf(0.5f, 0.4f, 0.6f, 0.8f, 0.4f, 0.7f, 0.2f))
            LineChartCurved(dataPoints = listOf(0.5f, 0.4f, 0.6f, 0.8f, 0.4f, 0.7f, 0.2f))
            LineChartFullCurved(dataPoints = listOf(0.5f, 0.4f, 0.6f, 0.8f, 0.4f, 0.7f, 0.2f))
        }
    }
}