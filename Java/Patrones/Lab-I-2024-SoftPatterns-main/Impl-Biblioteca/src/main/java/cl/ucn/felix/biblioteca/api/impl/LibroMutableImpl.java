package cl.ucn.felix.biblioteca.api.impl;

import cl.ucn.felix.biblioteca.api.LibroMutable;

public class LibroMutableImpl implements LibroMutable {
    private String titulo;
    private String autor;
    private String categoria;
    private String isbn;

    public LibroMutableImpl(String isbn) {
        this.isbn = isbn;
    }
    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void setTitulo(String titulo) {
     this.titulo = titulo;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.getCategoria()).append(": ");
        buf.append(this.getTitulo()).append(" de ").append(this.getAutor());
        return buf.toString();
    }
}
