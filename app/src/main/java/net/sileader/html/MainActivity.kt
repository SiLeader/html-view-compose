package net.sileader.html

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.sileader.html.ui.theme.HtmlTheme

const val HTML_TEXT =
    """
        <h1
    style="border-left: 0px solid black; border-bottom: thin solid silver; margin: 15px 0px; padding: 0px; font-weight: normal;">
    見出し１</h1>
<h2
    style="border-left: 10px solid silver; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px 5px; font-weight: normal;">
    見出し2</h2>
<h3
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 5px 0px; padding: 0px; font-weight: bold;">
    見出し3</h3>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    段落</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <span style="font-size: 24pt;">フォントサイズ24pt</span>
</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <strong>
        <span style="font-size: 12pt;">BOLD</span>
    </strong>
</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <em>
        <span style="font-size: 12pt;">Italic</span>
    </em>
</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <span style="text-decoration: underline;">
        <span style="font-size: 12pt;">Underline</span>
    </span>
</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <span style="text-decoration: line-through;">Strikethrough</span>
</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <span style="color: #ff0000;">RED</span>
</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <span style="background-color: #ff0000;">BACK_RED</span>
</p>
<p style="text-align: right;">右よせ</p>
<p style="text-align: center;">中央よせ</p>
<p style="text-align: left;">左よせ</p>
<ul>
    <li>箇条書き1</li>
    <li>箇条書き2</li>
</ul>
<div>
    <ol>
        <li>数字箇条書き1</li>
        <li>数字箇条書き2</li>
    </ol>
    <div>
        <a href="https://www.google.co.jp">ハイパーリンク(to Google)</a>
    </div>
    <div><a href="https://www.google.co.jp" target="_blank">ハイパーリンク(新規ウインドウ(to Google))</a>
    </div>
    <blockquote
        style="border-left: 5px solid silver; border-bottom: 0px solid black; margin: 15px 0px 15px 15px; padding: 0px 0px 0px 15px; font-weight: normal;">
        <div>引用</div>
        <div>引用テキストです</div>
    </blockquote>
</div>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    <span style="text-decoration: line-through;">
        <span style="text-decoration: underline;">
            <em>Italic-Underline-Strikethrough</em>
        </span>
    </span>
</p>
<p
    style="border-left: 0px solid black; border-bottom: 0px solid black; margin: 15px 0px; padding: 0px; font-weight: normal;">
    abcd
    <strong>efgh</strong>
    <br>
    abcd
    <em>efgh</em>
    <br>
    abcd
    <span style="text-decoration: line-through;">efgh</span>
</p>

<div>
    5x5の表
</div>
<div>&nbsp;</div>
<table style="border-color: #2c2c2c;" border="1" width="200">
    <tbody>
        <tr>
            <td>&nbsp;</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
        </tr>
        <tr>
            <td>1</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
        </tr>
        <tr>
            <td>2</td>
            <td>2</td>
            <td>4</td>
            <td>6</td>
            <td>8</td>
        </tr>
        <tr>
            <td>3</td>
            <td>3</td>
            <td>6</td>
            <td>9</td>
            <td>12</td>
        </tr>
        <tr>
            <td>4</td>
            <td>4</td>
            <td>8</td>
            <td>12</td>
            <td>16</td>
        </tr>
    </tbody>
</table>

    """

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HtmlTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        Html(HTML_TEXT)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HtmlTheme {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Html(HTML_TEXT)
        }
    }
}