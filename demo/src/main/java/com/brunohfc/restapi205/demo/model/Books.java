package com.brunohfc.restapi205.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="author" , length = 100)
    private String autor;
    @Column(nullable = false, name = "launch_date")
    private LocalDateTime lancamento;
    @Column(length = 6, name = "price")
    private Double preco;
    @Column(length = 100, name = "title")
    private String titulo;

    public Books() {
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
        if (!(o instanceof Books books)) return false;
        return id == books.id && Objects.equals(autor, books.autor) && Objects.equals(lancamento, books.lancamento) && Objects.equals(preco, books.preco) && Objects.equals(titulo, books.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, lancamento, preco, titulo);
    }
}
