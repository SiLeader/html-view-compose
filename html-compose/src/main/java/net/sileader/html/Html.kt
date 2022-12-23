package net.sileader.html

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

@Composable
fun Html(
    html: String,
    modifier: Modifier = Modifier,
    colorPalette: ColorPalette = ColorPalette.Html
) {
    val doc = Jsoup.parse(html)
    doc.body().children()
    val scope = HtmlElementsScope(colorPalette = colorPalette)
    SelectionContainer(modifier = modifier.fillMaxWidth()) {
        scope.Block(element = doc.body())
    }
}

private fun HtmlElementsScope.parseStyle(element: Element) =
    Style.fromCssStyle(element.attr("style"), colorPalette = colorPalette)

private data class HtmlElementsScope(val colorPalette: ColorPalette)

private fun Modifier.blockElementPadding() = this.padding(PaddingValues(vertical = 5.dp))

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
private fun HtmlElementsScope.Block(element: Element) {
    when (element.tagName().lowercase()) {
        "p" -> P(element)
        "h1" -> Text(
            element.text(),
            style = MaterialTheme.typography.h1.copy(fontSize = 32.sp),
            modifier = Modifier
                .blockElementPadding()
                .borderAndPadding(parseStyle(element))
                .testTag(HtmlComposeTestTags.HtmlElements.h1),
        )
        "h2" -> Text(
            element.text(),
            style = MaterialTheme.typography.h2.copy(fontSize = 26.sp),
            modifier = Modifier
                .blockElementPadding()
                .borderAndPadding(parseStyle(element))
                .testTag(HtmlComposeTestTags.HtmlElements.h2),
        )
        "h3" -> Text(
            element.text(),
            style = MaterialTheme.typography.h3.copy(fontSize = 22.sp),
            modifier = Modifier
                .blockElementPadding()
                .borderAndPadding(parseStyle(element))
                .testTag(HtmlComposeTestTags.HtmlElements.h3),
        )
        "h4" -> Text(
            element.text(),
            style = MaterialTheme.typography.h4.copy(fontSize = 20.sp),
            modifier = Modifier
                .blockElementPadding()
                .borderAndPadding(parseStyle(element))
                .testTag(HtmlComposeTestTags.HtmlElements.h4),
        )
        "div" -> Div(element)
        "ol" -> OlUl(element, isOrdered = true)
        "ul" -> OlUl(element, isOrdered = false)
        "table" -> Table(element)
        "blockquote" -> Column(
            modifier = Modifier
                .blockElementPadding()
                .borderAndPadding(parseStyle(element))
                .testTag(HtmlComposeTestTags.HtmlElements.blockquote)
        ) {
            for (e in element.children()) {
                Block(element = e)
            }
        }
        "body" -> Column(
            modifier = Modifier
                .borderAndPadding(parseStyle(element))
                .testTag(HtmlComposeTestTags.HtmlElements.body)
        ) {
            for (node in element.childNodes()) {
                if (node is TextNode) {
                    val text = node.text()
                    if (text.isNotBlank()) {
                        Text(node.text())
                    }
                } else if (node is Element) {
                    Block(node)
                }
            }
        }
    }
}

@Composable
private fun HtmlElementsScope.Table(element: Element) {
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

    Grid(
        columnCount = columnCount,
        modifier = Modifier
            .blockElementPadding()
            .testTag(HtmlComposeTestTags.HtmlElements.table)
    ) {
        for (row in tbody) {
            items(values = row.children()) {
                Block(element = it)
            }
        }
    }
}

@Composable
private fun HtmlElementsScope.Div(element: Element) {
    Column(
        modifier = Modifier
            .blockElementPadding()
            .testTag(HtmlComposeTestTags.HtmlElements.div)
    ) {
        for (node in element.childNodes()) {
            if (node is TextNode) {
                val text = node.text()
                if (text.isNotBlank()) {
                    Text(node.text())
                }
            } else if (node is Element) {
                if (node.isBlock) {
                    Block(element = node)
                } else {
                    val annotatedString = buildAnnotatedString {
                        inlineText(node, this@Div)
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
}

@Composable
private fun HtmlElementsScope.OlUl(element: Element, isOrdered: Boolean) {
    val testTag = if (isOrdered) {
        HtmlComposeTestTags.HtmlElements.ol
    } else {
        HtmlComposeTestTags.HtmlElements.ul
    }

    val children = element.children()
    Column(
        modifier = Modifier
            .blockElementPadding()
            .testTag(testTag)
    ) {
        children.forEachIndexed { index, element ->
            Li(
                element = element,
                index = if (isOrdered) index + 1 else null
            )
        }
    }
}

@Composable
private fun HtmlElementsScope.Li(element: Element, index: Int? = null) {
    Row(
        modifier = Modifier.testTag(HtmlComposeTestTags.HtmlElements.li),
        verticalAlignment = Alignment.CenterVertically
    ) {
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
    scope: HtmlElementsScope,
    decoration: TextDecoration? = null
) {
    when (element.tagName().lowercase()) {
        "br" -> {
            append('\n')
        }
        "span" -> {
            val style = scope.parseStyle(element)

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
                        inlineText(node, scope, textDecoration)
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
                        inlineText(node, scope)
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
                        inlineText(node, scope)
                    }
                }
            }
        }
        "a" -> {
            val href = element.attr("href")
            pushStringAnnotation(tag = "URL", annotation = href)
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

@Composable
private fun HtmlElementsScope.P(element: Element) {
    val style = parseStyle(element)
    val uriHandler = LocalUriHandler.current

    val annotatedString = buildAnnotatedString {
        withStyle(style = ParagraphStyle(style.textAlign)) {
            for (node in element.childNodes()) {
                if (node is TextNode) {
                    append(node.text())
                } else if (node is Element) {
                    inlineText(node, this@P)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .blockElementPadding()
            .borderAndPadding(style)
            .testTag(HtmlComposeTestTags.HtmlElements.p),
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

@Preview
@Composable
fun DefaultPreviewHtml() {
    MaterialTheme {
        Html("<ol><li>preview</li><li>preview</li><li>preview</li></ol>")
    }
}