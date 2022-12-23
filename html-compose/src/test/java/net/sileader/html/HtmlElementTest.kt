package net.sileader.html

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HtmlElementTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun div_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<div>html</div>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.div).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun h1_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<h1>html</h1>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.h1).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun h2_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<h2>html</h2>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.h2).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun h3_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<h3>html</h3>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.h3).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun h4_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<h4>html</h4>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.h4).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun ol_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<ol><li>html<li></ol>")
        }
        println(composeRule.onRoot().printToString())
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.ol).assertExists()
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.li).assertExists()
        composeRule.onNodeWithText("html").assertExists()
        composeRule.onNodeWithText("1.").assertExists()
    }

    @Test
    fun ul_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<ul><li>html<li></ul>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.ul).assertExists()
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.li).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun blockquote_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<blockquote>html</blockquote>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.blockquote).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun p_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<p>html</p>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.p).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun body_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<body>html</body>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.body).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }

    @Test
    fun table_tag_is_exists() {
        composeRule.setContent {
            Html(html = "<table>html</table>")
        }
        composeRule.onNodeWithTag(HtmlComposeTestTags.HtmlElements.table).assertExists()
        composeRule.onNodeWithText("html").assertExists()
    }
}