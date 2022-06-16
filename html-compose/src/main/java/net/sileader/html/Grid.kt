package net.sileader.html

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class GridRowScope(private val columnCount: Int) {
    private val contents = mutableListOf<@androidx.compose.runtime.Composable () -> Unit>()

    fun item(content: @Composable () -> Unit) {
        contents.add(content)
    }

    fun <T> items(values: List<T>, content: @Composable (T) -> Unit) {
        for (value in values) {
            item {
                content(value)
            }
        }
    }

    fun <T> items(values: Array<T>, content: @Composable (T) -> Unit) {
        for (value in values) {
            item {
                content(value)
            }
        }
    }

    fun <T> itemsIndexed(values: List<T>, content: @Composable (Int, T) -> Unit) {
        for (index in 0..values.lastIndex) {
            item {
                content(index, values[index])
            }
        }
    }

    fun <T> itemsIndexed(values: Array<T>, content: @Composable (Int, T) -> Unit) {
        for (index in 0..values.lastIndex) {
            item {
                content(index, values[index])
            }
        }
    }

    @Composable
    internal fun Compose() {
        val rowCount = contents.size / columnCount
        for (rowIndex in 0 until rowCount) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (columnIndex in 0 until columnCount) {
                    Box(modifier = Modifier.weight(1f)) {
                        contents[rowIndex * columnCount + columnIndex]()
                    }
                }
            }
        }
    }
}

@Composable
internal fun Grid(
    columnCount: Int,
    modifier: Modifier = Modifier,
    content: GridRowScope.() -> Unit
) {
    val scope = GridRowScope(columnCount)
    scope.content()

    Column(modifier = modifier) {
        scope.Compose()
    }
}
