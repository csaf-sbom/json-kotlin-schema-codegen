/*
 * TestApFalsePatternExtraOpt.kt
 *
 * This code was generated by json-kotlin-schema-codegen - JSON Schema Code Generator
 * See https://github.com/pwall567/json-kotlin-schema-codegen
 *
 * It is not advisable to modify generated code as any modifications will be lost
 * when the generation process is re-run.
 */
package net.pwall.json.schema.codegen.test.kotlin

/**
 * Test use of additionalProperties false with patternProperties and optional extra property.
 */
class TestApFalsePatternExtraOpt(
    private val cg_map: Map<String, Any?>
) : Map<String, Any?> by cg_map {

    init {
        if (cg_map.containsKey("extra")) {
            require(cg_map["extra"] is String?) { "extra is not the correct type, expecting String?" }
            (cg_map["extra"] as String?)?.let { extra ->
                require(extra.isNotEmpty()) { "extra length < minimum 1 - ${extra.length}" }
            }
        }
        cg_map.entries.forEach { (key, value) ->
            if (cg_regex0.containsMatchIn(key)) {
                require(value is Int) { "$key is not the correct type, expecting Int" }
                require(value in 0..99) { "$key not in range 0..99 - $value" }
            }
        }
        cg_map.keys.forEach { key ->
            if (key != "extra" && !cg_regex0.containsMatchIn(key))
                throw IllegalArgumentException("Unexpected field $key")
        }
    }

    /** Extra field */
    val extra: String?
        get() = cg_map["extra"] as String?

    override fun toString(): String = "TestApFalsePatternExtraOpt(${cg_map.entries.joinToString { "${it.key}=${it.value}" }})"

    override fun equals(other: Any?): Boolean = this === other || other is TestApFalsePatternExtraOpt && cg_map == other.cg_map

    override fun hashCode(): Int = cg_map.hashCode()

    companion object {
        private val cg_regex0 = Regex("^[A-Z]{3}\$")
    }

}
