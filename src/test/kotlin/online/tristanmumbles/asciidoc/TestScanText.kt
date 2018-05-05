package online.tristanmumbles.asciidoc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestScanText {

    @Test
    fun `two lines`() {
        val allContent = "one\ntwo\n"

        val actual = scanText(allContent)

        val expected = listOf(Line("one", 0, 0, "one".length),
                Line("two", 1, "one".length + 1, allContent.length - 1))

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `two lines, no EOL`() {
        val allContent = "one\ntwo"

        val actual = scanText(allContent)

        val expected = listOf(Line("one", 0, 0, "one".length),
                Line("two", 1, "one".length + 1, allContent.length))

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `one line`() {
        val allContent = "one\n"

        val actual = scanText(allContent)

        val expected = listOf(Line("one", 0, 0, "one".length))

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `one line, no EOL`() {
        val allContent = "one"

        val actual = scanText(allContent)

        val expected = listOf(Line("one", 0, 0, "one".length))

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `empty string`() {
        val allContent = ""

        val actual = scanText(allContent)

        val expected = emptyList<Line>()

        Assertions.assertEquals(expected, actual)
    }
}