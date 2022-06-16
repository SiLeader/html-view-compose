package net.sileader.html

import androidx.compose.ui.graphics.Color

interface ColorPalette {
    val black: Color
    val dimGray: Color
    val gray: Color
    val darkGray: Color
    val silver: Color
    val lightGray: Color
    val gainsboro: Color
    val whiteSmoke: Color
    val white: Color
    val snow: Color
    val ghostWhite: Color
    val floralWhite: Color
    val linen: Color
    val antiqueWhite: Color
    val papayaWhip: Color
    val blanchedAlmond: Color
    val bisque: Color
    val moccasin: Color
    val navajoWhite: Color
    val peachPuff: Color
    val mistyRose: Color
    val lavenderBlush: Color
    val seashell: Color
    val oldLace: Color
    val ivory: Color
    val honeydew: Color
    val mintCream: Color
    val azure: Color

    val aliceBlue: Color
    val lavender: Color
    val lightSteelBlue: Color
    val lightSlateGray: Color
    val slateGray: Color
    val steelBlue: Color
    val royalBlue: Color
    val midnightBlue: Color
    val navy: Color
    val darkBlue: Color
    val mediumBlue: Color
    val blue: Color
    val dodgerBlue: Color
    val cornflowerBlue: Color
    val deepSkyBlue: Color
    val lightSkyBlue: Color
    val skyBlue: Color
    val lightBlue: Color
    val powderBlue: Color
    val paleTurquoise: Color
    val lightCyan: Color
    val cyan: Color
    val aqua: Color
    val turquoise: Color
    val mediumTurquoise: Color
    val darkTurquoise: Color
    val lightSeaGreen: Color
    val cadetBlue: Color

    val darkCyan: Color
    val teal: Color
    val darkSlateGray: Color
    val darkGreen: Color
    val green: Color
    val forestGreen: Color
    val seaGreen: Color
    val mediumSeaGreen: Color
    val mediumAquamarine: Color
    val darkSeaGreen: Color
    val aquamarine: Color
    val paleGreen: Color
    val lightGreen: Color
    val springGreen: Color
    val mediumSpringGreen: Color
    val lawnGreen: Color
    val chartreuse: Color
    val greenYellow: Color
    val lime: Color
    val limeGreen: Color
    val yellowGreen: Color
    val darkOliveGreen: Color
    val oliveDrab: Color
    val olive: Color
    val darkKhaki: Color
    val paleGoldenrod: Color
    val cornSilk: Color
    val beige: Color

    val lightYellow: Color
    val lightGoldenrodYellow: Color
    val lemonChiffon: Color
    val wheat: Color
    val burlyWood: Color
    val tan: Color
    val khaki: Color
    val yellow: Color
    val gold: Color
    val orange: Color
    val sandyBrown: Color
    val darkOrange: Color
    val goldenrod: Color
    val peru: Color
    val darkGoldenrod: Color
    val chocolate: Color
    val sienna: Color
    val saddleBrown: Color
    val maroon: Color
    val darkRed: Color
    val brown: Color
    val firebrick: Color
    val indianRed: Color
    val rosyBrown: Color
    val darkSalmon: Color
    val lightCoral: Color
    val salmon: Color
    val lightSalmon: Color

    val coral: Color
    val tomato: Color
    val orangeRed: Color
    val red: Color
    val crimson: Color
    val mediumVioletRed: Color
    val deepPink: Color
    val hotPink: Color
    val paleVioletRed: Color
    val pink: Color
    val lightPink: Color
    val thistle: Color
    val magenta: Color
    val fuchsia: Color
    val violet: Color
    val plum: Color
    val orchid: Color
    val mediumOrchid: Color
    val darkOrchid: Color
    val darkViolet: Color
    val darkMagenta: Color
    val purple: Color
    val indigo: Color
    val darkSlateBlue: Color
    val blueViolet: Color
    val mediumPurple: Color
    val slateBlue: Color
    val mediumSlateBlue: Color


    companion object {
        val Html: ColorPalette = MutableColorPalette.Html
    }

    operator fun get(colorName: String): Color?
}


class MutableColorPalette : ColorPalette {
    override var black = Color.Unspecified
    override var dimGray = Color.Unspecified
    override var gray = Color.Unspecified
    override var darkGray = Color.Unspecified
    override var silver = Color.Unspecified
    override var lightGray = Color.Unspecified
    override var gainsboro = Color.Unspecified
    override var whiteSmoke = Color.Unspecified
    override var white = Color.Unspecified
    override var snow = Color.Unspecified
    override var ghostWhite = Color.Unspecified
    override var floralWhite = Color.Unspecified
    override var linen = Color.Unspecified
    override var antiqueWhite = Color.Unspecified
    override var papayaWhip = Color.Unspecified
    override var blanchedAlmond = Color.Unspecified
    override var bisque = Color.Unspecified
    override var moccasin = Color.Unspecified
    override var navajoWhite = Color.Unspecified
    override var peachPuff = Color.Unspecified
    override var mistyRose = Color.Unspecified
    override var lavenderBlush = Color.Unspecified
    override var seashell = Color.Unspecified
    override var oldLace = Color.Unspecified
    override var ivory = Color.Unspecified
    override var honeydew = Color.Unspecified
    override var mintCream = Color.Unspecified
    override var azure = Color.Unspecified

    override var aliceBlue = Color.Unspecified
    override var lavender = Color.Unspecified
    override var lightSteelBlue = Color.Unspecified
    override var lightSlateGray = Color.Unspecified
    override var slateGray = Color.Unspecified
    override var steelBlue = Color.Unspecified
    override var royalBlue = Color.Unspecified
    override var midnightBlue = Color.Unspecified
    override var navy = Color.Unspecified
    override var darkBlue = Color.Unspecified
    override var mediumBlue = Color.Unspecified
    override var blue = Color.Unspecified
    override var dodgerBlue = Color.Unspecified
    override var cornflowerBlue = Color.Unspecified
    override var deepSkyBlue = Color.Unspecified
    override var lightSkyBlue = Color.Unspecified
    override var skyBlue = Color.Unspecified
    override var lightBlue = Color.Unspecified
    override var powderBlue = Color.Unspecified
    override var paleTurquoise = Color.Unspecified
    override var lightCyan = Color.Unspecified
    override var cyan = Color.Unspecified
    override var aqua = Color.Unspecified
    override var turquoise = Color.Unspecified
    override var mediumTurquoise = Color.Unspecified
    override var darkTurquoise = Color.Unspecified
    override var lightSeaGreen = Color.Unspecified
    override var cadetBlue = Color.Unspecified

    override var darkCyan = Color.Unspecified
    override var teal = Color.Unspecified
    override var darkSlateGray = Color.Unspecified
    override var darkGreen = Color.Unspecified
    override var green = Color.Unspecified
    override var forestGreen = Color.Unspecified
    override var seaGreen = Color.Unspecified
    override var mediumSeaGreen = Color.Unspecified
    override var mediumAquamarine = Color.Unspecified
    override var darkSeaGreen = Color.Unspecified
    override var aquamarine = Color.Unspecified
    override var paleGreen = Color.Unspecified
    override var lightGreen = Color.Unspecified
    override var springGreen = Color.Unspecified
    override var mediumSpringGreen = Color.Unspecified
    override var lawnGreen = Color.Unspecified
    override var chartreuse = Color.Unspecified
    override var greenYellow = Color.Unspecified
    override var lime = Color.Unspecified
    override var limeGreen = Color.Unspecified
    override var yellowGreen = Color.Unspecified
    override var darkOliveGreen = Color.Unspecified
    override var oliveDrab = Color.Unspecified
    override var olive = Color.Unspecified
    override var darkKhaki = Color.Unspecified
    override var paleGoldenrod = Color.Unspecified
    override var cornSilk = Color.Unspecified
    override var beige = Color.Unspecified

    override var lightYellow = Color.Unspecified
    override var lightGoldenrodYellow = Color.Unspecified
    override var lemonChiffon = Color.Unspecified
    override var wheat = Color.Unspecified
    override var burlyWood = Color.Unspecified
    override var tan = Color.Unspecified
    override var khaki = Color.Unspecified
    override var yellow = Color.Unspecified
    override var gold = Color.Unspecified
    override var orange = Color.Unspecified
    override var sandyBrown = Color.Unspecified
    override var darkOrange = Color.Unspecified
    override var goldenrod = Color.Unspecified
    override var peru = Color.Unspecified
    override var darkGoldenrod = Color.Unspecified
    override var chocolate = Color.Unspecified
    override var sienna = Color.Unspecified
    override var saddleBrown = Color.Unspecified
    override var maroon = Color.Unspecified
    override var darkRed = Color.Unspecified
    override var brown = Color.Unspecified
    override var firebrick = Color.Unspecified
    override var indianRed = Color.Unspecified
    override var rosyBrown = Color.Unspecified
    override var darkSalmon = Color.Unspecified
    override var lightCoral = Color.Unspecified
    override var salmon = Color.Unspecified
    override var lightSalmon = Color.Unspecified

    override var coral = Color.Unspecified
    override var tomato = Color.Unspecified
    override var orangeRed = Color.Unspecified
    override var red = Color.Unspecified
    override var crimson = Color.Unspecified
    override var mediumVioletRed = Color.Unspecified
    override var deepPink = Color.Unspecified
    override var hotPink = Color.Unspecified
    override var paleVioletRed = Color.Unspecified
    override var pink = Color.Unspecified
    override var lightPink = Color.Unspecified
    override var thistle = Color.Unspecified
    override var magenta = Color.Unspecified
    override var fuchsia = Color.Unspecified
    override var violet = Color.Unspecified
    override var plum = Color.Unspecified
    override var orchid = Color.Unspecified
    override var mediumOrchid = Color.Unspecified
    override var darkOrchid = Color.Unspecified
    override var darkViolet = Color.Unspecified
    override var darkMagenta = Color.Unspecified
    override var purple = Color.Unspecified
    override var indigo = Color.Unspecified
    override var darkSlateBlue = Color.Unspecified
    override var blueViolet = Color.Unspecified
    override var mediumPurple = Color.Unspecified
    override var slateBlue = Color.Unspecified
    override var mediumSlateBlue = Color.Unspecified


    companion object {
        val Html = MutableColorPalette().apply {
            black = Color(0xff000000)
            dimGray = Color(0xff696969)
            gray = Color(0xff808080)
            darkGray = Color(0xffa9a9a9)
            silver = Color(0xffc0c0c0)
            lightGray = Color(0xffd3d3d3)
            gainsboro = Color(0xffdcdcdc)
            whiteSmoke = Color(0xfff5f5f5)
            white = Color(0xffffffff)
            snow = Color(0xfffffafa)
            ghostWhite = Color(0xfff8f8ff)
            floralWhite = Color(0xfffffaf0)
            linen = Color(0xfffaf0e6)
            antiqueWhite = Color(0xfffaebd7)
            papayaWhip = Color(0xffffefd5)
            blanchedAlmond = Color(0xffffebcd)
            bisque = Color(0xffffe4c4)
            moccasin = Color(0xffffe4b5)
            navajoWhite = Color(0xffffdead)
            peachPuff = Color(0xffffdab9)
            mistyRose = Color(0xffffe4e1)
            lavenderBlush = Color(0xfffff0f5)
            seashell = Color(0xfffff5ee)
            oldLace = Color(0xfffdf5e6)
            ivory = Color(0xfffffff0)
            honeydew = Color(0xfff0fff0)
            mintCream = Color(0xfff5fffa)
            azure = Color(0xfff0ffff)

            aliceBlue = Color(0xfff0f8ff)
            lavender = Color(0xffe6e6fa)
            lightSteelBlue = Color(0xffb0c4de)
            lightSlateGray = Color(0xff778899)
            slateGray = Color(0xff708090)
            steelBlue = Color(0xff4682b4)
            royalBlue = Color(0xff4169e1)
            midnightBlue = Color(0xff191970)
            navy = Color(0xff000080)
            darkBlue = Color(0xff00008b)
            mediumBlue = Color(0xff0000cd)
            blue = Color(0xff0000ff)
            dodgerBlue = Color(0xff1e90ff)
            cornflowerBlue = Color(0xff6495ed)
            deepSkyBlue = Color(0xff00bfff)
            lightSkyBlue = Color(0xff87cefa)
            skyBlue = Color(0xff87ceeb)
            lightBlue = Color(0xffadd8e6)
            powderBlue = Color(0xffb0e0e6)
            paleTurquoise = Color(0xffafeeee)
            lightCyan = Color(0xffe0ffff)
            cyan = Color(0xff00ffff)
            aqua = Color(0xff00ffff)
            turquoise = Color(0xff40e0d0)
            mediumTurquoise = Color(0xff48d1cc)
            darkTurquoise = Color(0xff00ced1)
            lightSeaGreen = Color(0xff20b2aa)
            cadetBlue = Color(0xff5f9ea0)

            darkCyan = Color(0xff008b8b)
            teal = Color(0xff008080)
            darkSlateGray = Color(0xff2f4f4f)
            darkGreen = Color(0xff006400)
            green = Color(0xff008000)
            forestGreen = Color(0xff228b22)
            seaGreen = Color(0xff2e8b57)
            mediumSeaGreen = Color(0xff3cb371)
            mediumAquamarine = Color(0xff66cdaa)
            darkSeaGreen = Color(0xff8fbc8f)
            aquamarine = Color(0xff7fffd4)
            paleGreen = Color(0xff98fb98)
            lightGreen = Color(0xff90ee90)
            springGreen = Color(0xff00ff7f)
            mediumSpringGreen = Color(0xff00fa9a)
            lawnGreen = Color(0xff7cfc00)
            chartreuse = Color(0xff7fff00)
            greenYellow = Color(0xffadff2f)
            lime = Color(0xff00ff00)
            limeGreen = Color(0xff32cd32)
            yellowGreen = Color(0xff9acd32)
            darkOliveGreen = Color(0xff556b2f)
            oliveDrab = Color(0xff6b8e23)
            olive = Color(0xff808000)
            darkKhaki = Color(0xffbdb76b)
            paleGoldenrod = Color(0xffeee8aa)
            cornSilk = Color(0xfffff8dc)
            beige = Color(0xfff5f5dc)

            lightYellow = Color(0xffffffe0)
            lightGoldenrodYellow = Color(0xfffafad2)
            lemonChiffon = Color(0xfffffacd)
            wheat = Color(0xfff5deb3)
            burlyWood = Color(0xffdeb887)
            tan = Color(0xffd2b48c)
            khaki = Color(0xfff0e68c)
            yellow = Color(0xffffff00)
            gold = Color(0xffffd700)
            orange = Color(0xffffa500)
            sandyBrown = Color(0xfff4a460)
            darkOrange = Color(0xffff8c00)
            goldenrod = Color(0xffdaa520)
            peru = Color(0xffcd853f)
            darkGoldenrod = Color(0xffb8860b)
            chocolate = Color(0xffd2691e)
            sienna = Color(0xffa0522d)
            saddleBrown = Color(0xff8b4513)
            maroon = Color(0xff800000)
            darkRed = Color(0xff8b0000)
            brown = Color(0xffa52a2a)
            firebrick = Color(0xffb22222)
            indianRed = Color(0xffcd5c5c)
            rosyBrown = Color(0xffbc8f8f)
            darkSalmon = Color(0xffe9967a)
            lightCoral = Color(0xfff08080)
            salmon = Color(0xfffa8072)
            lightSalmon = Color(0xffffa07a)

            coral = Color(0xffff7f50)
            tomato = Color(0xffff6347)
            orangeRed = Color(0xffff4500)
            red = Color(0xffff0000)
            crimson = Color(0xffdc143c)
            mediumVioletRed = Color(0xffc71585)
            deepPink = Color(0xffff1493)
            hotPink = Color(0xffff69b4)
            paleVioletRed = Color(0xffdb7093)
            pink = Color(0xffffcdcb)
            lightPink = Color(0xffffb6c1)
            thistle = Color(0xffd8bfd8)
            magenta = Color(0xffff00ff)
            fuchsia = Color(0xffff00ff)
            violet = Color(0xffee82ee)
            plum = Color(0xffdda0dd)
            orchid = Color(0xffda70d6)
            mediumOrchid = Color(0xffba55d3)
            darkOrchid = Color(0xff9932cc)
            darkViolet = Color(0xff9400d3)
            darkMagenta = Color(0xff8b008b)
            purple = Color(0xff800080)
            indigo = Color(0xff4b0082)
            darkSlateBlue = Color(0xff483d8b)
            blueViolet = Color(0xff8a2be2)
            mediumPurple = Color(0xff9370db)
            slateBlue = Color(0xff6a5acd)
            mediumSlateBlue = Color(0xff7b68ee)
            rehash()
        }
    }

    private fun rehash() {
        paletteMap = mapOf(
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
    }

    private var paletteMap = mapOf<String, Color>()

    override operator fun get(colorName: String): Color? = paletteMap[colorName.lowercase()]

    fun copy(applier: MutableColorPalette.() -> Unit) = MutableColorPalette().also {
        it.black = this.black
        it.dimGray = this.dimGray
        it.gray = this.gray
        it.darkGray = this.darkGray
        it.silver = this.silver
        it.lightGray = this.lightGray
        it.gainsboro = this.gainsboro
        it.whiteSmoke = this.whiteSmoke
        it.white = this.white
        it.snow = this.snow
        it.ghostWhite = this.ghostWhite
        it.floralWhite = this.floralWhite
        it.linen = this.linen
        it.antiqueWhite = this.antiqueWhite
        it.papayaWhip = this.papayaWhip
        it.blanchedAlmond = this.blanchedAlmond
        it.bisque = this.bisque
        it.moccasin = this.moccasin
        it.navajoWhite = this.navajoWhite
        it.peachPuff = this.peachPuff
        it.mistyRose = this.mistyRose
        it.lavenderBlush = this.lavenderBlush
        it.seashell = this.seashell
        it.oldLace = this.oldLace
        it.ivory = this.ivory
        it.honeydew = this.honeydew
        it.mintCream = this.mintCream
        it.azure = this.azure

        it.aliceBlue = this.aliceBlue
        it.lavender = this.lavender
        it.lightSteelBlue = this.lightSteelBlue
        it.lightSlateGray = this.lightSlateGray
        it.slateGray = this.slateGray
        it.steelBlue = this.steelBlue
        it.royalBlue = this.royalBlue
        it.midnightBlue = this.midnightBlue
        it.navy = this.navy
        it.darkBlue = this.darkBlue
        it.mediumBlue = this.mediumBlue
        it.blue = this.blue
        it.dodgerBlue = this.dodgerBlue
        it.cornflowerBlue = this.cornflowerBlue
        it.deepSkyBlue = this.deepSkyBlue
        it.lightSkyBlue = this.lightSkyBlue
        it.skyBlue = this.skyBlue
        it.lightBlue = this.lightBlue
        it.powderBlue = this.powderBlue
        it.paleTurquoise = this.paleTurquoise
        it.lightCyan = this.lightCyan
        it.cyan = this.cyan
        it.aqua = this.aqua
        it.turquoise = this.turquoise
        it.mediumTurquoise = this.mediumTurquoise
        it.darkTurquoise = this.darkTurquoise
        it.lightSeaGreen = this.lightSeaGreen
        it.cadetBlue = this.cadetBlue

        it.darkCyan = this.darkCyan
        it.teal = this.teal
        it.darkSlateGray = this.darkSlateGray
        it.darkGreen = this.darkGreen
        it.green = this.green
        it.forestGreen = this.forestGreen
        it.seaGreen = this.seaGreen
        it.mediumSeaGreen = this.mediumSeaGreen
        it.mediumAquamarine = this.mediumAquamarine
        it.darkSeaGreen = this.darkSeaGreen
        it.aquamarine = this.aquamarine
        it.paleGreen = this.paleGreen
        it.lightGreen = this.lightGreen
        it.springGreen = this.springGreen
        it.mediumSpringGreen = this.mediumSpringGreen
        it.lawnGreen = this.lawnGreen
        it.chartreuse = this.chartreuse
        it.greenYellow = this.greenYellow
        it.lime = this.lime
        it.limeGreen = this.limeGreen
        it.yellowGreen = this.yellowGreen
        it.darkOliveGreen = this.darkOliveGreen
        it.oliveDrab = this.oliveDrab
        it.olive = this.olive
        it.darkKhaki = this.darkKhaki
        it.paleGoldenrod = this.paleGoldenrod
        it.cornSilk = this.cornSilk
        it.beige = this.beige

        it.lightYellow = this.lightYellow
        it.lightGoldenrodYellow = this.lightGoldenrodYellow
        it.lemonChiffon = this.lemonChiffon
        it.wheat = this.wheat
        it.burlyWood = this.burlyWood
        it.tan = this.tan
        it.khaki = this.khaki
        it.yellow = this.yellow
        it.gold = this.gold
        it.orange = this.orange
        it.sandyBrown = this.sandyBrown
        it.darkOrange = this.darkOrange
        it.goldenrod = this.goldenrod
        it.peru = this.peru
        it.darkGoldenrod = this.darkGoldenrod
        it.chocolate = this.chocolate
        it.sienna = this.sienna
        it.saddleBrown = this.saddleBrown
        it.maroon = this.maroon
        it.darkRed = this.darkRed
        it.brown = this.brown
        it.firebrick = this.firebrick
        it.indianRed = this.indianRed
        it.rosyBrown = this.rosyBrown
        it.darkSalmon = this.darkSalmon
        it.lightCoral = this.lightCoral
        it.salmon = this.salmon
        it.lightSalmon = this.lightSalmon

        it.coral = this.coral
        it.tomato = this.tomato
        it.orangeRed = this.orangeRed
        it.red = this.red
        it.crimson = this.crimson
        it.mediumVioletRed = this.mediumVioletRed
        it.deepPink = this.deepPink
        it.hotPink = this.hotPink
        it.paleVioletRed = this.paleVioletRed
        it.pink = this.pink
        it.lightPink = this.lightPink
        it.thistle = this.thistle
        it.magenta = this.magenta
        it.fuchsia = this.fuchsia
        it.violet = this.violet
        it.plum = this.plum
        it.orchid = this.orchid
        it.mediumOrchid = this.mediumOrchid
        it.darkOrchid = this.darkOrchid
        it.darkViolet = this.darkViolet
        it.darkMagenta = this.darkMagenta
        it.purple = this.purple
        it.indigo = this.indigo
        it.darkSlateBlue = this.darkSlateBlue
        it.blueViolet = this.blueViolet
        it.mediumPurple = this.mediumPurple
        it.slateBlue = this.slateBlue
        it.mediumSlateBlue = this.mediumSlateBlue
        it.applier()
        it.rehash()
    }
}
