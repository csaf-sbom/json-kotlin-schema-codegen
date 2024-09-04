/*
 * TestApTrueExtraArrayOpt.kt
 *
 * This code was generated by json-kotlin-schema-codegen - JSON Schema Code Generator
 * See https://github.com/pwall567/json-kotlin-schema-codegen
 *
 * It is not advisable to modify generated code as any modifications will be lost
 * when the generation process is re-run.
 */
package net.pwall.json.schema.codegen.test.kotlin

/**
 * Test use of additionalProperties true with optional extra list field.
 */
class TestApTrueExtraArrayOpt(
    private val cg_map: Map<String, Any?>
) : Map<String, Any?> by cg_map {

    init {
        if (cg_map.containsKey("extra")) {
            require(cg_map["extra"] is List<*>) { "extra is not the correct type, expecting List<String>?" }
            (cg_map["extra"] as List<*>).forEach { cg_0 ->
                require(cg_0 is String) { "extra item is not the correct type, expecting String" }
            }
        }
    }

    val extra: List<String>?
        @Suppress("unchecked_cast")
        get() = cg_map["extra"] as List<String>?

    override fun toString(): String = "TestApTrueExtraArrayOpt(${cg_map.entries.joinToString { "${it.key}=${it.value}" }})"

    override fun equals(other: Any?): Boolean = this === other || other is TestApTrueExtraArrayOpt && cg_map == other.cg_map

    override fun hashCode(): Int = cg_map.hashCode()

}
