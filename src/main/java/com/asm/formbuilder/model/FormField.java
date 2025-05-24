package com.asm.formbuilder.model;

import com.asm.formbuilder.model.ValidationRule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class FormField {

    @NotBlank(message = "Label is required")
    @Size(max = 50, message = "Label should not exceed 50 characters")
    private String label;

    @NotBlank(message = "Type is required")
    @Size(max = 25, message = "Type should not exceed 25 characters")
    private String type;

    private Boolean required;

    private List<ValidationRule> validationRules;

    public FormField(String label, String type) {
        this.label = label;
        this.type = type;
        this.required = false;
        this.validationRules = List.of();
    }


    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }
    public void setRequired(boolean required) {
        this.required = required;
    }

    public List<ValidationRule> getValidationRules() {
        return validationRules;
    }
    public void setValidationRules(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }
}
