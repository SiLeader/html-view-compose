package net.sileader.html

object HtmlComposeTestTags {
    const val testTagPrefix = "html_compose_test_tags"

    object HtmlElements {
        const val htmlElementsPrefix = "${testTagPrefix}_html"
        const val blockElementsTestTagPrefix = "${htmlElementsPrefix}_block_elements"

        // Block elements
        const val div = "${blockElementsTestTagPrefix}_div"

        const val h1 = "${blockElementsTestTagPrefix}_h1"
        const val h2 = "${blockElementsTestTagPrefix}_h2"
        const val h3 = "${blockElementsTestTagPrefix}_h3"
        const val h4 = "${blockElementsTestTagPrefix}_h4"

        const val ol = "${blockElementsTestTagPrefix}_ol"
        const val ul = "${blockElementsTestTagPrefix}_ul"

        const val blockquote = "${blockElementsTestTagPrefix}_blockquote"

        const val p = "${blockElementsTestTagPrefix}_p"
        const val body = "${blockElementsTestTagPrefix}_body"
        const val table = "${blockElementsTestTagPrefix}_table"

        // li tag
        const val li = "${htmlElementsPrefix}_ul_ol_dir_menu_elements_li"
    }
}