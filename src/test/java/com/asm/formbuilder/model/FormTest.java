//package com.asm.formbuilder.model;
//
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class FormTest {
//
//    private static Validator validator;
//
//    @BeforeAll
//    static void setupValidator() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    @Test
//    void testTitleIsBlank() {
//        Form form = new Form();
//        form.setTitle("");
//        form.setFields(List.of(new FormField("field1", "Text")));
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations)
//                .anyMatch(v -> v.getPropertyPath().toString().equals("title")
//                        && v.getMessage().equals("Title is required"));
//    }
//
//    @Test
//    void testTitleIsNull() {
//        Form form = new Form();
//        form.setTitle(null);
//        form.setFields(List.of(new FormField("field1", "Text")));
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations)
//                .anyMatch(v -> v.getPropertyPath().toString().equals("title")
//                        && v.getMessage().equals("Title is required"));
//    }
//
//    @Test
//    void testTitleTooShort() {
//        Form form = new Form();
//        form.setTitle("abc");
//        form.setFields(List.of(new FormField("field1", "Text")));
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations)
//                .anyMatch(v -> v.getPropertyPath().toString().equals("title")
//                        && v.getMessage().contains("between 5 and 50"));
//    }
//
//    @Test
//    void testTitleTooLong() {
//        Form form = new Form();
//        form.setTitle("a".repeat(60));
//        form.setFields(List.of(new FormField("field1", "Text")));
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations)
//                .anyMatch(v -> v.getPropertyPath().toString().equals("title")
//                        && v.getMessage().contains("between 5 and 50"));
//    }
//
//    @Test
//    void testFieldsListIsEmpty() {
//        Form form = new Form();
//        form.setTitle("Valid Title");
//        form.setFields(List.of());
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations)
//                .anyMatch(v -> v.getPropertyPath().toString().equals("fields")
//                        && v.getMessage().contains("at least one field"));
//    }
//
//    @Test
//    void testFieldsListIsNull() {
//        Form form = new Form();
//        form.setTitle("Valid Title");
//        form.setFields(null);
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations)
//                .anyMatch(v -> v.getPropertyPath().toString().equals("fields")
//                        && v.getMessage().contains("at least one field"));
//    }
//
//    @Test
//    void testFormWithInvalidFieldInside() {
//        FormField invalidField = new FormField("", "");
//        Form form = new Form();
//        form.setTitle("Valid Title");
//        form.setFields(List.of(invalidField));
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations)
//                .anyMatch(v -> v.getPropertyPath().toString().contains("fields[0].label")
//                        && v.getMessage().equals("Label is required"))
//                .anyMatch(v -> v.getPropertyPath().toString().contains("fields[0].type")
//                        && v.getMessage().equals("Type is required"));
//    }
//
//    @Test
//    void testFormValid() {
//        Form form = new Form();
//        form.setTitle("Valid Form Title");
//        form.setFields(List.of(new FormField("Name", "Text")));
//
//        Set<ConstraintViolation<Form>> violations = validator.validate(form);
//
//        assertThat(violations).isEmpty();
//    }
//
//    @Test
//    void testGettersAndSetters() {
//        Form form = new Form();
//        form.setId("123");
//        form.setTitle("Test Title");
//        FormField field = new FormField("Label", "Text");
//        form.setFields(List.of(field));
//
//        assertThat(form.getId()).isEqualTo("123");
//        assertThat(form.getTitle()).isEqualTo("Test Title");
//        assertThat(form.getFields()).containsExactly(field);
//    }
//
//}
