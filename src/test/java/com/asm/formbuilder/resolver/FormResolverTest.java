package com.asm.formbuilder.resolver;

import com.asm.formbuilder.model.Form;
import com.asm.formbuilder.model.FormField;
import com.asm.formbuilder.repository.FormRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FormResolverTest {

    @Mock
    private FormRepository formRepository;

    @InjectMocks
    private FormResolver formResolver;


    @Test
    void testGetFormByIdExists() {
        Form sample = new Form();
        sample.setId("1");
        sample.setTitle("Test Form");
        sample.setFields(List.of(new FormField("name", "text")));

        when(formRepository.findById("1")).thenReturn(Optional.of(sample));

        Form form = formResolver.getForm("1");

        assertThat(form).isNotNull();
        assertThat(form.getTitle()).isEqualTo("Test Form");

        verify(formRepository).findById("1");
    }

    @Test
    void testGetFormByIdNotFound() {
        when(formRepository.findById("999")).thenReturn(Optional.empty());

        Form form = formResolver.getForm("999");

        assertThat(form).isNull();

        verify(formRepository).findById("999");
    }

    @Test
    void testCreateFormAddsNewForm() {
        Form input = new Form();
        input.setTitle("New Form");
        input.setFields(List.of(new FormField("email", "text")));

        Form saved = new Form();
        saved.setId("1");
        saved.setTitle("New Form");
        saved.setFields(input.getFields());

        when(formRepository.save(input)).thenReturn(saved);

        Form created = formResolver.createForm(input);

        assertThat(created.getId()).isEqualTo("1");
        assertThat(created.getTitle()).isEqualTo("New Form");
        assertThat(created.getFields()).hasSize(1);

        verify(formRepository).save(input);
    }

    @Test
    void testGetAllFormsReturnsAll() {
        Form sample1 = new Form();
        sample1.setId("1");
        sample1.setTitle("Form 1");
        sample1.setFields(List.of(new FormField("phone", "text")));

        Form sample2 = new Form();
        sample2.setId("2");
        sample2.setTitle("Form 2");
        sample2.setFields(List.of(new FormField("email", "text")));

        when(formRepository.findAll()).thenReturn(List.of(sample1, sample2));

        List<Form> forms = formResolver.getAllForms();

        assertThat(forms).hasSize(2);

        verify(formRepository).findAll();
    }
}
