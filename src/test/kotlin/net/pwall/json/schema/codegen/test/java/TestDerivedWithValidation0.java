/*
 * TestDerivedWithValidation0.java
 *
 * This code was generated by json-kotlin-schema-codegen - JSON Schema Code Generator
 * See https://github.com/pwall567/json-kotlin-schema-codegen
 *
 * It is not advisable to modify generated code as any modifications will be lost
 * when the generation process is re-run.
 */
package net.pwall.json.schema.codegen.test.java;

/**
 * No additional validations
 */
public class TestDerivedWithValidation0 extends TestBaseWithValidation {

    private final String payload;

    public TestDerivedWithValidation0(
            Type type,
            int quantity,
            String name,
            String payload
    ) {
        super(type, quantity, name);
        if (payload == null)
            throw new IllegalArgumentException("Must not be null - payload");
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof TestDerivedWithValidation0))
            return false;
        if (!super.equals(other))
            return false;
        TestDerivedWithValidation0 typedOther = (TestDerivedWithValidation0)other;
        return payload.equals(typedOther.payload);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return hash ^ payload.hashCode();
    }

}
