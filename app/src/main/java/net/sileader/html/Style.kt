package net.sileader.html

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Style(
    val textAlign: TextAlign,
    val color: Color,
    val backgroundColor: Color,
    val fontSize: TextUnit,
    val textDecoration: TextDecoration?,
    val padding: EdgeInsets,
    val margin: EdgeInsets,
) {
    data class EdgeInsets(val left: Float, val top: Float, val bottom: Float, val right: Float) {
        constructor() : this(0f, 0f, 0f, 0f)
        constructor(horizontal: Float, vertical: Float) : this(
            horizontal,
            vertical,
            vertical,
            horizontal
        )

        constructor(all: Float) : this(all, all)

        operator fun plus(rhs: EdgeInsets) =
            EdgeInsets(left + rhs.left, top + rhs.top, bottom + rhs.bottom, right + rhs.right)

        val padding = PaddingValues(left.dp, top.dp, bottom.dp, right.dp)

        override fun toString(): String =
            "EdgeInsets (left = $left, top = $top, bottom = $bottom, right = $right)"
    }

    companion object {
        fun fromCssStyle(style: String): Style {
            val styleKv = style
                .split(";")
                .map { it.trim() }
                .map {
                    it
                        .split(":")
                        .map { st -> st.trim() }
                }
                .filter { it.size == 2 }
                .associate { Pair(it[0], it[1]) }

            Log.d("CSS", "$styleKv")
            val textAlign = parseTextAlign(styleKv["text-align"])
            val color = parseColor(styleKv["color"], Color.Unspecified)
            val backgroundColor = parseColor(styleKv["background-color"], Color.Unspecified)

            val textDecoration = styleKv["text-decoration"]
            Log.d("CSS Decoration", "$textDecoration")
            val decorations = mutableListOf<TextDecoration>()
            if (textDecoration == "line-through") {
                decorations.add(TextDecoration.LineThrough)
            }
            if (textDecoration == "underline") {
                decorations.add(TextDecoration.Underline)
            }

            val fontSize = parseFontSize(styleKv["font-size"])

            val decoration = if (decorations.isEmpty()) {
                null
            } else {
                TextDecoration.combine(decorations)
            }

            val padding = parsePadding(styleKv["padding"])
            val margin = parsePadding(styleKv["margin"])

            return Style(
                textAlign,
                color,
                backgroundColor,
                fontSize,
                decoration,
                padding,
                margin,
            )
        }

        private fun parsePadding(padding: String?): EdgeInsets {
            if (padding == null) {
                return EdgeInsets()
            }
            val numberRegex = Regex("""(\d+).+""")
            val elements =
                padding.split(" ")
                    .filter { it.isNotBlank() }
                    .mapNotNull { numberRegex.matchEntire(it)?.groups?.get(1)?.value }
                    .map { it.toFloat() }

            return when (elements.size) {
                1 -> EdgeInsets(elements[0])
                2 -> EdgeInsets(elements[1], elements[0]) // padding: ↑↓, ←→
                3 -> EdgeInsets(
                    elements[1],
                    elements[0],
                    elements[1],
                    elements[2],
                ) // padding: ↑, ←→, ↓
                4 -> EdgeInsets(
                    elements[3],
                    elements[0],
                    elements[2],
                    elements[1],
                ) // padding: ↑, →, ↓, ←
                else -> EdgeInsets()
            }
        }

        private fun parseTextAlign(align: String?): TextAlign {
            return when (align) {
                "start" -> TextAlign.Start
                "end" -> TextAlign.End
                "right" -> TextAlign.Right
                "left" -> TextAlign.Left
                "center" -> TextAlign.Center
                else -> TextAlign.Start
            }
        }

        private fun parseColor(color: String?, defaultColor: Color): Color {
            if (color == null) {
                return defaultColor
            }
            val colorCodeRegex = Regex("#([0-9aa-fA-F]{2})([0-9aa-fA-F]{2})([0-9aa-fA-F]{2})")
            val match = colorCodeRegex.matchEntire(color) ?: return defaultColor

            val r = match.groups[1] ?: return defaultColor
            val g = match.groups[2] ?: return defaultColor
            val b = match.groups[3] ?: return defaultColor
            return Color(r.value.toInt(16), g.value.toInt(16), b.value.toInt(16))
        }

        private fun parseFontSize(fontSizeText: String?): TextUnit {
            if (fontSizeText == null) {
                return TextUnit.Unspecified
            }
            val numberRegex = Regex("""(\d+).+""")
            val match = numberRegex.matchEntire(fontSizeText) ?: return TextUnit.Unspecified
            val number = match.groups[1]?.value ?: return TextUnit.Unspecified
            return number.toFloat().sp
        }
    }
}