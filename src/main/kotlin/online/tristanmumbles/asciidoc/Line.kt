package online.tristanmumbles.asciidoc

/**
 *
 * @param content "Real" content of line, sans newline
 * @param index Line index within document
 * @param charStart Index start of character inside document
 * @param charEnd Index end of character inside document relevant to content
 */
data class Line(val content: String, val index: Int, val charStart: Int, val charEnd: Int)
