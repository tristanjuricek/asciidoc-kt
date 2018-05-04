package online.tristanmumbles.asciidoc

/**
 * Scan the asciidoc text buffer into a basic set of "lines" with positional information.
 *
 * @param text Assumed to be an asciidoc document, right now using '\n' as delimiters
 */
fun scanText(text: String): List<Line> {
    val lines = mutableListOf<Line>()

    var lastLine : Line? = null
    var lineIndex = 0

    text.forEachIndexed { index, ch ->
        // TODO: Not totally sure if we want "newline" fanciness or not, documents can get awful dirty
        if (ch == '\n') {
            val charStart = lastLine?.let { it.charEnd + 1 } ?: 0
            val charEnd = index
            val content = text.substring(charStart, charEnd)
            val line = Line(content, lineIndex, charStart, charEnd)

            lines.add(line)
            lineIndex++
            lastLine = line
        }
    }

    val lastPos = lastLine?.let { it.charEnd + 1 } ?: 0
    if (lastPos < text.length) {
        val charStart = lastPos
        val charEnd = text.length
        val content = text.substring(charStart, charEnd)
        val line = Line(content, lineIndex, charStart, charEnd)
        lines.add(line)
    }

    return lines
}