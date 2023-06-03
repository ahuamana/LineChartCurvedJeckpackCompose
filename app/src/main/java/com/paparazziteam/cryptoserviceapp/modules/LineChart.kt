package com.paparazziteam.cryptoserviceapp.modules

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LineChart(dataPoints: List<Float>) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val linePath = androidx.compose.ui.graphics.Path()

        val xStep = size.width / (dataPoints.size - 1)
        val yStep = size.height / (dataPoints.maxOrNull() ?: 1f)

        dataPoints.forEachIndexed { index, dataPoint ->
            val xPos = index * xStep
            val yPos = size.height - (dataPoint * yStep)

            if (index == 0) {
                linePath.moveTo(xPos, yPos)
            } else {
                linePath.lineTo(xPos, yPos)
            }
        }

        drawPath(
            path = linePath,
            color = Color.Blue,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}


@Preview
@Composable
fun LineChartPreview() {
    LineChart(dataPoints = listOf(0.5f, 0.4f, 0.6f, 0.8f, 0.4f, 0.7f, 0.2f))
}
