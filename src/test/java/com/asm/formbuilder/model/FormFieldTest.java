//package com.asm.formbuilder.model;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FormFieldTest {
//
//    @Test
//    void constructor_shouldInitializeWithLabelAndType() {
//        FormField field = new FormField("Name", "text");
//
//        assertEquals("Name", field.getLabel());
//        assertEquals("text", field.getType());
//        assertFalse(field.isRequired());
//        assertNotNull(field.getValidationRules());
//        assertTrue(field.getValidationRules().isEmpty());
//    }
//
//    @Test
//    void setLabel_shouldUpdateLabel() {
//        FormField field = new FormField("Name", "text");
//        field.setLabel("Email");
//
//        assertEquals("Email", field.getLabel());
//    }
//
//    @Test
//    void setType_shouldUpdateType() {
//        FormField field = new FormField("Name", "text");
//        field.setType("email");
//
//        assertEquals("email", field.getType());
//    }
//
//    @Test
//    void setRequired_shouldUpdateRequired() {
//        FormField field = new FormField("Name", "text");
//        field.setRequired(true);
//
//        assertTrue(field.isRequired());
//    }
//
//    @Test
//    void setValidationRules_shouldUpdateRules() {
//        FormField field = new FormField("Name", "text");
//
//        ValidationRule rule = new ValidationRule();
//        field.setValidationRules(List.of(rule));
//
//        assertEquals(1, field.getValidationRules().size());
//        assertSame(rule, field.getValidationRules().get(0));
//    }
//}
