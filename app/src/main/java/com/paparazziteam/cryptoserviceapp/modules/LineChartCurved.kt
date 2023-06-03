package com.paparazziteam.cryptoserviceapp.modules

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LineChartCurved(
    dataPoints: List<Float>,
    color : Color = Color.Blue
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val linePath = Path()

        val xStep = size.width / (dataPoints.size - 1)
        val yStep = size.height / (dataPoints.maxOrNull() ?: 1f)

        dataPoints.forEachIndexed { index, dataPoint ->
            val xPos = index * xStep
            val yPos = size.height - (dataPoint * yStep)

            if (index == 0) {
                linePath.moveTo(xPos, yPos)
            } else {
                val prevDataPoint = dataPoints[index - 1]
                val prevXPos = (index - 1) * xStep
                val prevYPos = size.height - (prevDataPoint * yStep)
                val controlX = prevXPos + (xPos - prevXPos) / 2
                linePath.quadraticBezierTo(controlX, prevYPos, xPos, yPos)
            }
        }

        drawPath(
            path = linePath,
            color = color,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}


@Preview
@Composable
fun LineChartCurvedPrev() {
    LineChartCurved(dataPoints = listOf(0.5f, 0.4f, 0.6f, 0.8f, 0.4f, 0.7f, 0.2f))
}
