# Html Composable for Android Jetpack Compose

&copy; 2022 SiLeader.

## Features

+ Display HTML document

### Supporting HTML tags

+ block elements
    + `body`
    + `h1`
    + `h2`
    + `h3`
    + `h4`
    + `ol`
    + `ul`
    + `p`
    + `table` (Using `AndroidView`)
    + `blockquote`
+ inline elements
    + `span`
    + `a`
    + `em`
    + `strong`
    + `br`

### Supporting inline style

+ `color` and `background-color`
    + `#000000` style
    + colors name like `red`, `navy`
        + customizable color palette (use `net.sileader.html.ColorPalette`'s `copy` method)
+ `margin`, `padding`
+ `font-size`
+ `text-decoration`
    + `line-through`
    + `underline`
+ `text-align`
+ `border`, `border-left`, `border-top`, `border-bottom`, and `border-right`

## License

Mozilla Public License 2.0

See LICENSE
