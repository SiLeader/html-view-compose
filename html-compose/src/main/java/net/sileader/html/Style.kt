package net.sileader.html

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
    val borders: Borders,
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

    data class Borders(val left: Border, val top: Border, val bottom: Border, val right: Border) {
        val padding = EdgeInsets(
            left = left.width,
            top = top.width,
            bottom = bottom.width,
            right = right.width,
        )
    }

    data class Border(val type: Type, val width: Float, val color: Color) {
        enum class Type {
            SOLID,
        }

        val isSpecified = width > 0f

        companion object {
            val Unspecified = Border(Type.SOLID, 0f, Color.Unspecified)
        }
    }

    companion object {
        fun fromCssStyle(style: String, colorPalette: ColorPalette = ColorPalette.Html): Style {
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

            val textAlign = parseTextAlign(styleKv["text-align"])
            val color = parseColor(styleKv["color"], Color.Unspecified, colorPalette)
            val backgroundColor =
                parseColor(styleKv["background-color"], Color.Unspecified, colorPalette)

            val textDecoration = styleKv["text-decoration"]
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

            val borderAll = parseBorder(styleKv["border"], colorPalette)
            val borders = if (borderAll == Border.Unspecified) {
                Borders(
                    parseBorder(styleKv["border-left"], colorPalette),
                    parseBorder(styleKv["border-top"], colorPalette),
                    parseBorder(styleKv["border-bottom"], colorPalette),
                    parseBorder(styleKv["border-right"], colorPalette),
                )
            } else {
                Borders(borderAll, borderAll, borderAll, borderAll)
            }

            return Style(
                textAlign,
                color,
                backgroundColor,
                fontSize,
                decoration,
                padding,
                margin,
                borders,
            )
        }

        private fun parseBorder(border: String?, colorPalette: ColorPalette): Border {
            if (border == null) {
                return Border.Unspecified
            }
            val spl = border.split(" ").map { it.trim() }
            return when (spl.size) {
                1 -> Border.Unspecified.copy(type = Border.Type.valueOf(spl[0].uppercase()))
                2 -> {
                    val width = parseBorderWidth(spl[0])
                    if (width != null) {
                        val type = Border.Type.valueOf(spl[1].uppercase())
                        Border(type, width, Color.Black)
                    }

                    val type = Border.Type.valueOf(spl[1].uppercase())
                    val color = parseColor(spl[2], Color.Unspecified, colorPalette)
                    Border(type, 1f, color)
                }
                3 -> {
                    val width = parseBorderWidth(spl[0]) ?: return Border.Unspecified
                    val type = Border.Type.valueOf(spl[1].uppercase())
                    val color = parseColor(spl[2], Color.Unspecified, colorPalette)
                    Border(type, width, color)
                }
                else -> Border.Unspecified
            }
        }

        private fun parseBorderWidth(borderWidth: String): Float? {
            val numberWidth = parseNumber(borderWidth)
            if (numberWidth != null) {
                return numberWidth
            }
            return when (borderWidth) {
                "thin" -> 1f
                "medium" -> 3f
                "thick" -> 5f
                else -> null
            }
        }

        private fun parseNumber(numString: String): Float? {
            val numberRegex = Regex("""(\d+).+""")
            return numberRegex.matchEntire(numString)?.groups?.get(1)?.value?.toFloat()
        }

        private fun parsePadding(padding: String?): EdgeInsets {
            if (padding == null) {
                return EdgeInsets()
            }
            val elements =
                padding.split(" ")
                    .filter { it.isNotBlank() }
                    .mapNotNull { parseNumber(it) }

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

        private fun parseColor(
            color: String?,
            defaultColor: Color,
            colorPalette: ColorPalette,
        ): Color {
            if (color == null) {
                return defaultColor
            }
            val paletteColor = colorPalette[color]
            if (paletteColor != null) {
                return paletteColor
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
            return parseNumber(fontSizeText)?.sp ?: TextUnit.Unspecified
        }
    }
}