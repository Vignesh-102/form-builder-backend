package com.asm.formbuilder.resolver;

import com.asm.formbuilder.model.Form;
import com.asm.formbuilder.repository.FormRepository;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import java.util.List;

@Controller
public class FormResolver {

    private final FormRepository formRepository;

    public FormResolver(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @QueryMapping
    public Form getForm(String id) {
        return formRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    @MutationMapping
    public Form createForm(Form input) {
        return formRepository.save(input);
    }
}
