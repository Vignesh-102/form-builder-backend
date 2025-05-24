package com.asm.formbuilder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationRuleTest {

    @Test
    void testGetType() {
        ValidationRule rule = new ValidationRule();
        rule.setType("required");

        assertEquals("required", rule.getType());
    }

    @Test
    void testSetType() {
        ValidationRule rule = new ValidationRule();
        rule.setType("email");

        assertEquals("email", rule.getType());
    }

    @Test
    void testGetValue() {
        ValidationRule rule = new ValidationRule();
        rule.setValue("true");

        assertEquals("true", rule.getValue());
    }

    @Test
    void testSetValue() {
        ValidationRule rule = new ValidationRule();
        rule.setValue("false");

        assertEquals("false", rule.getValue());
    }

    @Test
    void testConstructorWithValues() {
        ValidationRule rule = new ValidationRule();
        rule.setType("pattern");
        rule.setValue("\\d{10}");

        assertEquals("pattern", rule.getType());
        assertEquals("\\d{10}", rule.getValue());
    }

    @Test
    void testValidationRuleDefaultValues() {
        ValidationRule rule = new ValidationRule();

        assertNull(rule.getType());  // Default value is null
        assertNull(rule.getValue()); // Default value is null
    }
}
