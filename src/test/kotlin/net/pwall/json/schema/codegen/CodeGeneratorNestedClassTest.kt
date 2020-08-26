/*
 * @(#) CodeGeneratorNestedClassTest.kt
 *
 * json-kotlin-schema-codegen  JSON Schema Code Generation
 * Copyright (c) 2020 Peter Wall
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.pwall.json.schema.codegen

import kotlin.test.Test
import kotlin.test.expect

import java.io.File
import java.io.StringWriter

class CodeGeneratorNestedClassTest {

    @Test fun `should output deeply nested class`() {
        val input = File("src/test/resources/test-nested-object.schema.json")
        val codeGenerator = CodeGenerator()
        codeGenerator.baseDirectoryName = "dummy"
        val stringWriter = StringWriter()
        codeGenerator.outputResolver =
                CodeGeneratorTestUtil.outputCapture("dummy", emptyList(), "TestNestedObject", "kt", stringWriter)
        codeGenerator.basePackageName = "com.example"
        codeGenerator.generate(input)
        expect(expectedNested) { stringWriter.toString() }
    }

    @Test fun `should output deeply nested class in Java`() {
        val input = File("src/test/resources/test-nested-object.schema.json")
        val codeGenerator = CodeGenerator(templates = "java", suffix = "java")
        codeGenerator.baseDirectoryName = "dummy"
        val stringWriter = StringWriter()
        codeGenerator.outputResolver =
                CodeGeneratorTestUtil.outputCapture("dummy", emptyList(), "TestNestedObject", "java", stringWriter)
        codeGenerator.basePackageName = "com.example"
        codeGenerator.generate(input)
        expect(expectedNestedJava) { stringWriter.toString() }
    }

    companion object {

        const val expectedNested =
"""package com.example

data class TestNestedObject(
        val nested: Nested
) {

    data class Nested(
            val deeper: Deeper
    )

    data class Deeper(
            val deepest: String
    )

}
"""

        const val expectedNestedJava =
"""package com.example;

public class TestNestedObject {

    private final Nested nested;

    public TestNestedObject(
            Nested nested
    ) {
        if (nested == null)
            throw new IllegalArgumentException("Must not be null - nested");
        this.nested = nested;
    }

    public Nested getNested() {
        return nested;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof TestNestedObject))
            return false;
        TestNestedObject typedOther = (TestNestedObject)other;
        if (!nested.equals(typedOther.nested))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash ^= nested.hashCode();
        return hash;
    }

    public static class Nested {

        private final Deeper deeper;

        public Nested(
                Deeper deeper
        ) {
            if (deeper == null)
                throw new IllegalArgumentException("Must not be null - deeper");
            this.deeper = deeper;
        }

        public Deeper getDeeper() {
            return deeper;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other)
                return true;
            if (!(other instanceof Nested))
                return false;
            Nested typedOther = (Nested)other;
            if (!deeper.equals(typedOther.deeper))
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash ^= deeper.hashCode();
            return hash;
        }

    }

    public static class Deeper {

        private final String deepest;

        public Deeper(
                String deepest
        ) {
            if (deepest == null)
                throw new IllegalArgumentException("Must not be null - deepest");
            this.deepest = deepest;
        }

        public String getDeepest() {
            return deepest;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other)
                return true;
            if (!(other instanceof Deeper))
                return false;
            Deeper typedOther = (Deeper)other;
            if (!deepest.equals(typedOther.deepest))
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash ^= deepest.hashCode();
            return hash;
        }

    }

}
"""

    }

}
