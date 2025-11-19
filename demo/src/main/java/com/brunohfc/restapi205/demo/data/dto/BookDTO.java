package com.brunohfc.restapi205.demo.data.dto;

import com.brunohfc.restapi205.demo.model.Books;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {

    private int id;
    private String autor;
    private LocalDateTime lancamento;
    private Double preco;
    private String titulo;

    public BookDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDateTime lancamento) {
        this.lancamento = lancamento;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDTO bookDTO)) return false;
        return getId() == bookDTO.getId() && Objects.equals(getAutor(), bookDTO.getAutor()) && Objects.equals(getLancamento(), bookDTO.getLancamento()) && Objects.equals(getPreco(), bookDTO.getPreco()) && Objects.equals(getTitulo(), bookDTO.getTitulo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAutor(), getLancamento(), getPreco(), getTitulo());
    }
}
