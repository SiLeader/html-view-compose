package net.sileader.html

import androidx.compose.ui.graphics.Color

data class ColorPalette(
    val unspecified: Color,
    val black: Color,
    val dimGray: Color,
    val gray: Color,
    val darkGray: Color,
    val silver: Color,
    val lightGray: Color,
    val gainsboro: Color,
    val whiteSmoke: Color,
    val white: Color,
    val snow: Color,
    val ghostWhite: Color,
    val floralWhite: Color,
    val linen: Color,
    val antiqueWhite: Color,
    val papayaWhip: Color,
    val blanchedAlmond: Color,
    val bisque: Color,
    val moccasin: Color,
    val navajoWhite: Color,
    val peachPuff: Color,
    val mistyRose: Color,
    val lavenderBlush: Color,
    val seashell: Color,
    val oldLace: Color,
    val ivory: Color,
    val honeydew: Color,
    val mintCream: Color,
    val azure: Color,
    //
    val aliceBlue: Color,
    val lavender: Color,
    val lightSteelBlue: Color,
    val lightSlateGray: Color,
    val slateGray: Color,
    val steelBlue: Color,
    val royalBlue: Color,
    val midnightBlue: Color,
    val navy: Color,
    val darkBlue: Color,
    val mediumBlue: Color,
    val blue: Color,
    val dodgerBlue: Color,
    val cornflowerBlue: Color,
    val deepSkyBlue: Color,
    val lightSkyBlue: Color,
    val skyBlue: Color,
    val lightBlue: Color,
    val powderBlue: Color,
    val paleTurquoise: Color,
    val lightCyan: Color,
    val cyan: Color,
    val aqua: Color,
    val turquoise: Color,
    val mediumTurquoise: Color,
    val darkTurquoise: Color,
    val lightSeaGreen: Color,
    val cadetBlue: Color,
    //
    val darkCyan: Color,
    val teal: Color,
    val darkSlateGray: Color,
    val darkGreen: Color,
    val green: Color,
    val forestGreen: Color,
    val seaGreen: Color,
    val mediumSeaGreen: Color,
    val mediumAquamarine: Color,
    val darkSeaGreen: Color,
    val aquamarine: Color,
    val paleGreen: Color,
    val lightGreen: Color,
    val springGreen: Color,
    val mediumSpringGreen: Color,
    val lawnGreen: Color,
    val chartreuse: Color,
    val greenYellow: Color,
    val lime: Color,
    val limeGreen: Color,
    val yellowGreen: Color,
    val darkOliveGreen: Color,
    val oliveDrab: Color,
    val olive: Color,
    val darkKhaki: Color,
    val paleGoldenrod: Color,
    val cornSilk: Color,
    val beige: Color,
    //
    val lightYellow: Color,
    val lightGoldenrodYellow: Color,
    val lemonChiffon: Color,
    val wheat: Color,
    val burlyWood: Color,
    val tan: Color,
    val khaki: Color,
    val yellow: Color,
    val gold: Color,
    val orange: Color,
    val sandyBrown: Color,
    val darkOrange: Color,
    val goldenrod: Color,
    val peru: Color,
    val darkGoldenrod: Color,
    val chocolate: Color,
    val sienna: Color,
    val saddleBrown: Color,
    val maroon: Color,
    val darkRed: Color,
    val brown: Color,
    val firebrick: Color,
    val indianRed: Color,
    val rosyBrown: Color,
    val darkSalmon: Color,
    val lightCoral: Color,
    val salmon: Color,
    val lightSalmon: Color,
    //
    val coral: Color,
    val tomato: Color,
    val orangeRed: Color,
    val red: Color,
    val crimson: Color,
    val mediumVioletRed: Color,
    val deepPink: Color,
    val hotPink: Color,
    val paleVioletRed: Color,
    val pink: Color,
    val lightPink: Color,
    val thistle: Color,
    val magenta: Color,
    val fuchsia: Color,
    val violet: Color,
    val plum: Color,
    val orchid: Color,
    val mediumOrchid: Color,
    val darkOrchid: Color,
    val darkViolet: Color,
    val darkMagenta: Color,
    val purple: Color,
    val indigo: Color,
    val darkSlateBlue: Color,
    val blueViolet: Color,
    val mediumPurple: Color,
    val slateBlue: Color,
    val mediumSlateBlue: Color,
) {
    companion object {
        val Html = ColorPalette(
            unspecified = Color.Unspecified,
            black = Color(0xff000000),
            dimGray = Color(0xff696969),
            gray = Color(0xff808080),
            darkGray = Color(0xffa9a9a9),
            silver = Color(0xffc0c0c0),
            lightGray = Color(0xffd3d3d3),
            gainsboro = Color(0xffdcdcdc),
            whiteSmoke = Color(0xfff5f5f5),
            white = Color(0xffffffff),
            snow = Color(0xfffffafa),
            ghostWhite = Color(0xfff8f8ff),
            floralWhite = Color(0xfffffaf0),
            linen = Color(0xfffaf0e6),
            antiqueWhite = Color(0xfffaebd7),
            papayaWhip = Color(0xffffefd5),
            blanchedAlmond = Color(0xffffebcd),
            bisque = Color(0xffffe4c4),
            moccasin = Color(0xffffe4b5),
            navajoWhite = Color(0xffffdead),
            peachPuff = Color(0xffffdab9),
            mistyRose = Color(0xffffe4e1),
            lavenderBlush = Color(0xfffff0f5),
            seashell = Color(0xfffff5ee),
            oldLace = Color(0xfffdf5e6),
            ivory = Color(0xfffffff0),
            honeydew = Color(0xfff0fff0),
            mintCream = Color(0xfff5fffa),
            azure = Color(0xfff0ffff),
            //
            aliceBlue = Color(0xfff0f8ff),
            lavender = Color(0xffe6e6fa),
            lightSteelBlue = Color(0xffb0c4de),
            lightSlateGray = Color(0xff778899),
            slateGray = Color(0xff708090),
            steelBlue = Color(0xff4682b4),
            royalBlue = Color(0xff4169e1),
            midnightBlue = Color(0xff191970),
            navy = Color(0xff000080),
            darkBlue = Color(0xff00008b),
            mediumBlue = Color(0xff0000cd),
            blue = Color(0xff0000ff),
            dodgerBlue = Color(0xff1e90ff),
            cornflowerBlue = Color(0xff6495ed),
            deepSkyBlue = Color(0xff00bfff),
            lightSkyBlue = Color(0xff87cefa),
            skyBlue = Color(0xff87ceeb),
            lightBlue = Color(0xffadd8e6),
            powderBlue = Color(0xffb0e0e6),
            paleTurquoise = Color(0xffafeeee),
            lightCyan = Color(0xffe0ffff),
            cyan = Color(0xff00ffff),
            aqua = Color(0xff00ffff),
            turquoise = Color(0xff40e0d0),
            mediumTurquoise = Color(0xff48d1cc),
            darkTurquoise = Color(0xff00ced1),
            lightSeaGreen = Color(0xff20b2aa),
            cadetBlue = Color(0xff5f9ea0),
            //
            darkCyan = Color(0xff008b8b),
            teal = Color(0xff008080),
            darkSlateGray = Color(0xff2f4f4f),
            darkGreen = Color(0xff006400),
            green = Color(0xff008000),
            forestGreen = Color(0xff228b22),
            seaGreen = Color(0xff2e8b57),
            mediumSeaGreen = Color(0xff3cb371),
            mediumAquamarine = Color(0xff66cdaa),
            darkSeaGreen = Color(0xff8fbc8f),
            aquamarine = Color(0xff7fffd4),
            paleGreen = Color(0xff98fb98),
            lightGreen = Color(0xff90ee90),
            springGreen = Color(0xff00ff7f),
            mediumSpringGreen = Color(0xff00fa9a),
            lawnGreen = Color(0xff7cfc00),
            chartreuse = Color(0xff7fff00),
            greenYellow = Color(0xffadff2f),
            lime = Color(0xff00ff00),
            limeGreen = Color(0xff32cd32),
            yellowGreen = Color(0xff9acd32),
            darkOliveGreen = Color(0xff556b2f),
            oliveDrab = Color(0xff6b8e23),
            olive = Color(0xff808000),
            darkKhaki = Color(0xffbdb76b),
            paleGoldenrod = Color(0xffeee8aa),
            cornSilk = Color(0xfffff8dc),
            beige = Color(0xfff5f5dc),
            //
            lightYellow = Color(0xffffffe0),
            lightGoldenrodYellow = Color(0xfffafad2),
            lemonChiffon = Color(0xfffffacd),
            wheat = Color(0xfff5deb3),
            burlyWood = Color(0xffdeb887),
            tan = Color(0xffd2b48c),
            khaki = Color(0xfff0e68c),
            yellow = Color(0xffffff00),
            gold = Color(0xffffd700),
            orange = Color(0xffffa500),
            sandyBrown = Color(0xfff4a460),
            darkOrange = Color(0xffff8c00),
            goldenrod = Color(0xffdaa520),
            peru = Color(0xffcd853f),
            darkGoldenrod = Color(0xffb8860b),
            chocolate = Color(0xffd2691e),
            sienna = Color(0xffa0522d),
            saddleBrown = Color(0xff8b4513),
            maroon = Color(0xff800000),
            darkRed = Color(0xff8b0000),
            brown = Color(0xffa52a2a),
            firebrick = Color(0xffb22222),
            indianRed = Color(0xffcd5c5c),
            rosyBrown = Color(0xffbc8f8f),
            darkSalmon = Color(0xffe9967a),
            lightCoral = Color(0xfff08080),
            salmon = Color(0xfffa8072),
            lightSalmon = Color(0xffffa07a),
            //
            coral = Color(0xffff7f50),
            tomato = Color(0xffff6347),
            orangeRed = Color(0xffff4500),
            red = Color(0xffff0000),
            crimson = Color(0xffdc143c),
            mediumVioletRed = Color(0xffc71585),
            deepPink = Color(0xffff1493),
            hotPink = Color(0xffff69b4),
            paleVioletRed = Color(0xffdb7093),
            pink = Color(0xffffcdcb),
            lightPink = Color(0xffffb6c1),
            thistle = Color(0xffd8bfd8),
            magenta = Color(0xffff00ff),
            fuchsia = Color(0xffff00ff),
            violet = Color(0xffee82ee),
            plum = Color(0xffdda0dd),
            orchid = Color(0xffda70d6),
            mediumOrchid = Color(0xffba55d3),
            darkOrchid = Color(0xff9932cc),
            darkViolet = Color(0xff9400d3),
            darkMagenta = Color(0xff8b008b),
            purple = Color(0xff800080),
            indigo = Color(0xff4b0082),
            darkSlateBlue = Color(0xff483d8b),
            blueViolet = Color(0xff8a2be2),
            mediumPurple = Color(0xff9370db),
            slateBlue = Color(0xff6a5acd),
            mediumSlateBlue = Color(0xff7b68ee),
        )
    }

    private val paletteMap = mapOf(
        "black" to black,
        "dimgray" to dimGray,
        "gray" to gray,
        "darkgray" to darkGray,
        "silver" to silver,
        "lightgray" to lightGray,
        "gainsboro" to gainsboro,
        "whitesmoke" to whiteSmoke,
        "white" to white,
        "snow" to snow,
        "ghostwhite" to ghostWhite,
        "floralwhite" to floralWhite,
        "linen" to linen,
        "antiquewhite" to antiqueWhite,
        "papayawhip" to papayaWhip,
        "blanchedalmond" to blanchedAlmond,
        "bisque" to bisque,
        "moccasin" to moccasin,
        "navajowhite" to navajoWhite,
        "peachpuff" to peachPuff,
        "mistyrose" to mistyRose,
        "lavenderblush" to lavenderBlush,
        "seashell" to seashell,
        "oldlace" to oldLace,
        "ivory" to ivory,
        "honeydew" to honeydew,
        "mintcream" to mintCream,
        "azure" to azure,
        "aliceblue" to aliceBlue,
        "lavender" to lavender,
        "lightsteelblue" to lightSteelBlue,
        "lightslategray" to lightSlateGray,
        "slategray" to slateGray,
        "steelblue" to steelBlue,
        "royalblue" to royalBlue,
        "midnightblue" to midnightBlue,
        "navy" to navy,
        "darkblue" to darkBlue,
        "mediumblue" to mediumBlue,
        "blue" to blue,
        "dodgerblue" to dodgerBlue,
        "cornflowerblue" to cornflowerBlue,
        "deepskyblue" to deepSkyBlue,
        "lightskyblue" to lightSkyBlue,
        "skyblue" to skyBlue,
        "lightblue" to lightBlue,
        "powderblue" to powderBlue,
        "paleturquoise" to paleTurquoise,
        "lightcyan" to lightCyan,
        "cyan" to cyan,
        "aqua" to aqua,
        "turquoise" to turquoise,
        "mediumturquoise" to mediumTurquoise,
        "darkturquoise" to darkTurquoise,
        "lightseagreen" to lightSeaGreen,
        "cadetblue" to cadetBlue,
        "darkcyan" to darkCyan,
        "teal" to teal,
        "darkslategray" to darkSlateGray,
        "darkgreen" to darkGreen,
        "green" to green,
        "forestgreen" to forestGreen,
        "seagreen" to seaGreen,
        "mediumseagreen" to mediumSeaGreen,
        "mediumaquamarine" to mediumAquamarine,
        "darkseagreen" to darkSeaGreen,
        "aquamarine" to aquamarine,
        "palegreen" to paleGreen,
        "lightgreen" to lightGreen,
        "springgreen" to springGreen,
        "mediumspringgreen" to mediumSpringGreen,
        "lawngreen" to lawnGreen,
        "chartreuse" to chartreuse,
        "greenyellow" to greenYellow,
        "lime" to lime,
        "limegreen" to limeGreen,
        "yellowgreen" to yellowGreen,
        "darkolivegreen" to darkOliveGreen,
        "olivedrab" to oliveDrab,
        "olive" to olive,
        "darkkhaki" to darkKhaki,
        "palegoldenrod" to paleGoldenrod,
        "cornsilk" to cornSilk,
        "beige" to beige,
        "lightyellow" to lightYellow,
        "lightgoldenrodyellow" to lightGoldenrodYellow,
        "lemonchiffon" to lemonChiffon,
        "wheat" to wheat,
        "burlywood" to burlyWood,
        "tan" to tan,
        "khaki" to khaki,
        "yellow" to yellow,
        "gold" to gold,
        "orange" to orange,
        "sandybrown" to sandyBrown,
        "darkorange" to darkOrange,
        "goldenrod" to goldenrod,
        "peru" to peru,
        "darkgoldenrod" to darkGoldenrod,
        "chocolate" to chocolate,
        "sienna" to sienna,
        "saddlebrown" to saddleBrown,
        "maroon" to maroon,
        "darkred" to darkRed,
        "brown" to brown,
        "firebrick" to firebrick,
        "indianred" to indianRed,
        "rosybrown" to rosyBrown,
        "darksalmon" to darkSalmon,
        "lightcoral" to lightCoral,
        "salmon" to salmon,
        "lightsalmon" to lightSalmon,
        "coral" to coral,
        "tomato" to tomato,
        "orangered" to orangeRed,
        "red" to red,
        "crimson" to crimson,
        "mediumvioletred" to mediumVioletRed,
        "deeppink" to deepPink,
        "hotpink" to hotPink,
        "palevioletred" to paleVioletRed,
        "pink" to pink,
        "lightpink" to lightPink,
        "thistle" to thistle,
        "magenta" to magenta,
        "fuchsia" to fuchsia,
        "violet" to violet,
        "plum" to plum,
        "orchid" to orchid,
        "mediumorchid" to mediumOrchid,
        "darkorchid" to darkOrchid,
        "darkviolet" to darkViolet,
        "darkmagenta" to darkMagenta,
        "purple" to purple,
        "indigo" to indigo,
        "darkslateblue" to darkSlateBlue,
        "blueviolet" to blueViolet,
        "mediumpurple" to mediumPurple,
        "slateblue" to slateBlue,
        "mediumslateblue" to mediumSlateBlue,
    )

    operator fun get(colorName: String): Color? = paletteMap[colorName.lowercase()]
    fun get(colorName: String, defaultColor: Color): Color = get(colorName) ?: defaultColor
}