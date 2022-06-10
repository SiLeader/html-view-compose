package net.sileader.html

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

@Composable
fun Html(html: String, modifier: Modifier = Modifier) {
    val doc = Jsoup.parse(html)
    doc.body().children()
    SelectionContainer(modifier = modifier.fillMaxWidth()) {
        HtmlElement(element = doc.body())
    }
}

@Composable
private fun HtmlElement(element: Element) {
    Log.d("HHHH", element.tagName())
    when (element.tagName().lowercase()) {
        "p" -> HtmlPTag(element)
        "h1" -> Text(element.text(), style = MaterialTheme.typography.h1)
        "h2" -> Text(element.text(), style = MaterialTheme.typography.h2)
        "h3" -> Text(element.text(), style = MaterialTheme.typography.h3)
        "h4" -> Text(element.text(), style = MaterialTheme.typography.h4)
        "div" -> Div(element)
        "ol" -> OlUl(element = element, isOrdered = true)
        "ul" -> OlUl(element = element, isOrdered = false)
        "body" -> Column {
            for (node in element.childNodes()) {
                if (node is TextNode) {
                    Text(node.text())
                } else if (node is Element) {
                    HtmlElement(node)
                }
            }
        }
    }
}

@Composable
private fun Div(element: Element) {
    for (node in element.childNodes()) {
        if (node is TextNode) {
            Text(node.text())
        } else if (node is Element) {
            if (node.isBlock) {
                when (node.tagName()) {
                    "div" -> Div(node)
                    "ol" -> OlUl(node, isOrdered = true)
                    "ul" -> OlUl(node, isOrdered = false)
                }
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
        HtmlPTag(element = element)
    }
}

private fun AnnotatedString.Builder.inlineText(
    element: Element,
    decoration: TextDecoration? = null
) {
    Log.d("inlineText", "tag: ${element.tagName()}")
    when (element.tagName()) {
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
private fun HtmlPTag(element: Element) {
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

    Box(modifier = Modifier.padding((style.padding + style.margin).padding)) {
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