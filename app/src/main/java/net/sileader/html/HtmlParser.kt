package net.sileader.html

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

@Composable
fun Html(html: String, modifier: Modifier = Modifier) {
    val doc = Jsoup.parse(html)
    doc.body().children()
    SelectionContainer(modifier = modifier.fillMaxWidth()) {
        Block(element = doc.body())
    }
}

private fun Modifier.borderAndPadding(style: Style) = this
    .padding(style.margin.padding)
    .drawBehind {
        val marginOffsetX = style.margin.left
        val marginOffsetY = style.margin.top

        if (style.borders.left.isSpecified) {
            val border = style.borders.left

            val strokeWidth = border.width.dp.toPx()
            val strokeOffsetX = strokeWidth / 2
            val y = size.height + style.borders.bottom.width.dp.toPx()
            drawLine(
                border.color,
                Offset(marginOffsetX + strokeOffsetX, marginOffsetY),
                Offset(marginOffsetX + strokeOffsetX, marginOffsetY + y),
                strokeWidth
            )
        }
        if (style.borders.right.isSpecified) {
            val border = style.borders.right

            val strokeWidth = border.width.dp.toPx()
            val strokeOffsetX = strokeWidth / 2
            val y = size.height + style.borders.bottom.width.dp.toPx()
            val x = size.width
            drawLine(
                border.color,
                Offset(marginOffsetX + strokeOffsetX + x, marginOffsetY),
                Offset(marginOffsetX + strokeOffsetX + x, marginOffsetY + y),
                strokeWidth
            )
        }
        if (style.borders.top.isSpecified) {
            val border = style.borders.top

            val strokeWidth = border.width.dp.toPx()
            val strokeOffsetY = strokeWidth / 2
            val x = size.width + style.borders.right.width.dp.toPx()
            drawLine(
                border.color,
                Offset(marginOffsetX, marginOffsetY + strokeOffsetY),
                Offset(marginOffsetX + x, marginOffsetY + strokeOffsetY),
                strokeWidth
            )
        }
        if (style.borders.bottom.isSpecified) {
            val border = style.borders.bottom

            val strokeWidth = border.width.dp.toPx()
            val strokeOffsetY = strokeWidth / 2
            val x = size.width + style.borders.right.width.dp.toPx()
            val y = size.height
            drawLine(
                border.color,
                Offset(marginOffsetX, marginOffsetY + strokeOffsetY + y),
                Offset(marginOffsetX + x, marginOffsetY + strokeOffsetY + y),
                strokeWidth
            )
        }
    }
    .padding((style.padding + style.borders.padding).padding)


@Composable
private fun Block(element: Element) {
    Log.d("HHHH", element.tagName())
    when (element.tagName().lowercase()) {
        "p" -> P(element)
        "h1" -> Text(
            element.text(),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.borderAndPadding(parseStyle(element)),
        )
        "h2" -> Text(
            element.text(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.borderAndPadding(parseStyle(element)),
        )
        "h3" -> Text(
            element.text(),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.borderAndPadding(parseStyle(element)),
        )
        "h4" -> Text(
            element.text(),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.borderAndPadding(parseStyle(element)),
        )
        "div" -> Div(element)
        "ol" -> OlUl(element, isOrdered = true)
        "ul" -> OlUl(element, isOrdered = false)
        "table" -> Table(element)
        "blockquote" -> Column(
            modifier = Modifier
                .borderAndPadding(parseStyle(element))
        ) {
            for (e in element.children()) {
                Block(element = e)
            }
        }
        "body" -> Column(
            modifier = Modifier
                .borderAndPadding(parseStyle(element))
        ) {
            for (node in element.childNodes()) {
                if (node is TextNode) {
                    Text(node.text())
                } else if (node is Element) {
                    Block(node)
                }
            }
        }
    }
}

private class InScrollableGridView(context: Context?) : GridView(context) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightSpec = MeasureSpec.makeMeasureSpec(Int.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, heightSpec)
        layoutParams.height = measuredHeight
    }
}

@Composable
private fun Table(element: Element) {
    val thead =
        element.getElementsByTag("thead").first()?.getElementsByTag("tr")?.first()?.children()
    val tbody = element.getElementsByTag("tbody").first()?.getElementsByTag("tr") ?: return

    val columnCount = if (thead == null) {
        val tbodyTrTds =
            tbody.first()?.getElementsByTag("td") ?: throw RuntimeException("bad table")
        tbodyTrTds.size
    } else {
        thead.size
    }
    val rowCount = tbody.size

    Log.d("Table", "column: $columnCount, row: $rowCount")

    AndroidView(
        factory = { context -> InScrollableGridView(context) },
        update = {
            it.numColumns = columnCount
            it.adapter = object : BaseAdapter() {
                override fun getCount() = columnCount * rowCount

                override fun getItem(position: Int): String {
                    val posX = position % columnCount
                    val posY = position / columnCount
                    Log.d("HTML::adapter::getItem", "pos: $position, X: $posX, Y: $posY")
                    val columns = tbody[posY].children()

                    return columns[posX].ownText()
                }

                override fun getItemId(position: Int): Long {
                    return 0
                }

                override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                    return TextView(it.context).apply {
                        text = getItem(position)
                    }
                }
            }
        },
    )
}

@Composable
private fun Div(element: Element) {
    for (node in element.childNodes()) {
        if (node is TextNode) {
            Text(node.text())
        } else if (node is Element) {
            if (node.isBlock) {
                Block(element = node)
            } else {
                val annotatedString = buildAnnotatedString {
                    inlineText(node)
                }
                val uriHandler = LocalUriHandler.current
                ClickableText(
                    modifier = Modifier.fillMaxWidth(),
                    text = annotatedString,
                    onClick = { offset ->
                        annotatedString.getStringAnnotations(
                            tag = "URL",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let {
                            uriHandler.openUri(it.item)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun OlUl(element: Element, isOrdered: Boolean) {
    val children = element.children()
    Column {
        for (index in 0..children.lastIndex) {
            Li(
                element = children[index],
                index = if (isOrdered) index + 1 else null
            )
        }
    }
}

@Composable
private fun Li(element: Element, index: Int? = null) {
    Row {
        DisableSelection {
            if (index == null) {
                Text("・")
            } else {
                Text("${index}.")
            }
        }
        P(element = element)
    }
}

private fun AnnotatedString.Builder.inlineText(
    element: Element,
    decoration: TextDecoration? = null
) {
    Log.d("inlineText", "tag: ${element.tagName()}")
    when (element.tagName().lowercase()) {
        "span" -> {
            val style = parseStyle(element)

            val textDecoration = if (decoration != null) {
                val currentDecoration = style.textDecoration
                if (currentDecoration != null) {
                    TextDecoration.combine(listOf(decoration, currentDecoration))
                } else {
                    decoration
                }
            } else {
                style.textDecoration
            }
            withStyle(
                style = SpanStyle(
                    color = style.color,
                    fontSize = style.fontSize,
                    background = style.backgroundColor,
                    textDecoration = textDecoration,
                )
            ) {
                for (node in element.childNodes()) {
                    if (node is TextNode) {
                        append(node.text())
                    } else if (node is Element) {
                        inlineText(node, textDecoration)
                    }
                }
            }
        }
        "em" -> {
            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                for (node in element.childNodes()) {
                    if (node is TextNode) {
                        append(node.text())
                    } else if (node is Element) {
                        inlineText(node)
                    }
                }
            }
        }
        "strong" -> {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                for (node in element.childNodes()) {
                    if (node is TextNode) {
                        append(node.text())
                    } else if (node is Element) {
                        inlineText(node)
                    }
                }
            }
        }
        "a" -> {
            val href = element.attr("href")
            pushStringAnnotation(tag = "URL", annotation = href)
            Log.d("a tag", "href: $href")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(element.ownText())
            }
            pop()
        }
    }
}

private fun parseStyle(element: Element) = Style.fromCssStyle(element.attr("style"))

@Composable
private fun P(element: Element) {
    val style = parseStyle(element)
    val uriHandler = LocalUriHandler.current

    val annotatedString = buildAnnotatedString {
        withStyle(style = ParagraphStyle(style.textAlign)) {
            for (node in element.childNodes()) {
                if (node is TextNode) {
                    append(node.text())
                } else if (node is Element) {
                    inlineText(node)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .borderAndPadding(style),
    ) {
        ClickableText(
            modifier = Modifier.fillMaxWidth(),
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(
                    tag = "URL",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let {
                    uriHandler.openUri(it.item)
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewHtml() {
    MaterialTheme {
        Html(HTML_TEXT)
    }
}