package com.brunohfc.restapi205.demo.data.dto.v1;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.util.Objects;

@Relation(collectionRelation = "people")
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    private static final long serialVersionUID= 1L;
    private Long id;

    private String nome;
    private String sobrenome;

    private String endereco;

    private String genero;
    private Boolean enabled;

    public PersonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO personDTO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), personDTO.getId()) && Objects.equals(getNome(), personDTO.getNome()) && Objects.equals(getSobrenome(), personDTO.getSobrenome()) && Objects.equals(getEndereco(), personDTO.getEndereco()) && Objects.equals(getGenero(), personDTO.getGenero()) && Objects.equals(getEnabled(), personDTO.getEnabled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getNome(), getSobrenome(), getEndereco(), getGenero(), getEnabled());
    }
}
