package online.tristanmumbles.asciidoc

import java.time.LocalDate

/*
 * This file defines the asciidoc object model we'll parse.
 *
 * <p> NOTE: Asciidoc isn't really a standard.
 * There are two implementations we're trying to generally meet:
 *
 * <ul>
 *     <li> The original (Python): http://asciidoc.org/ </li>
 *     <li> Asciidoctor: https://asciidoctor.org/docs/user-manual/ </li>
 * </ul>
 *
 * <p> For the most part, we try to stick to the original for the moment.
 * Asciidoctor tends to extend Asciidoc, so, I expect over time we'll add similar functionality.
 */

/**
 *
 * @param content "Real" content of line, sans newline
 * @param index Line index within document
 * @param charStart Index start of character inside document
 * @param charEnd Index end of character inside document relevant to content
 */
data class Line(val content: String, val index: Int, val charStart: Int, val charEnd: Int)

/**
 * Allows the header to specify a bunch of processing metadata.
 *
 * <p> See also <a href="https://asciidoctor.org/docs/user-manual/#attributes">asciidoctor attribute syntax</a>
 *
 * <p> The meaning of an attribute is really intended for the <em>client</em> of this library.
 *
 * @param name Pretty much any string, but convention currently is alphanumeric with hyphens. Defined within quotes.
 * @param value Optional value may exist on the rest of the line.
 * @param line Source line
 */
data class Attribute(val name: String, val value: String?, val line: Line)

/**
 *
 */
data class AuthorInfo(val firstName: String, val middleName: String?, val lastName: String?, val emailAddress: String?, val line: Line)

/**
 *
 */
data class RevisionInfo(val number: String?, val date: LocalDate?, val remark: String?, val lines: List<Line>)

data class Title(val content: String, val level: Int, val lines: List<Line>)

/**
 *
 */
data class Header(val title: Title, val authorInfos: List<AuthorInfo>?, val revisionInfo: RevisionInfo?, val attributes: List<Attribute>, val lines: List<String>)
