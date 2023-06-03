package com.paparazziteam.cryptoserviceapp.modules

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LineChartFullCurved(
    dataPoints: List<Float>,
    color: Color = Color(0xFF453DE0),
    height: Dp = 200.dp
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height).padding(5.dp)
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

                val controlX1 = prevXPos + (xPos - prevXPos) / 2
                val controlY1 = prevYPos
                val controlX2 = prevXPos + (xPos - prevXPos) / 2
                val controlY2 = yPos

                linePath.cubicTo(controlX1, controlY1, controlX2, controlY2, xPos, yPos)

                drawCircle(
                    color = color,
                    radius = 4.dp.toPx(),
                    center = Offset(xPos, yPos)
                )
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
fun LineChartFullCurvedPrev() {
    LineChartFullCurved(
        dataPoints = listOf(0f, 0.4f, 0.6f, 0.8f, 0.4f, 0.7f, 0.5f),
        color = Color(0xFF453DE0)
    )
}
