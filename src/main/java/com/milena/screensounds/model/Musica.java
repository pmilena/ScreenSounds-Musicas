package com.milena.screensounds.model;

import jakarta.persistence.*;

@Entity
@Table(name="musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @ManyToOne
    private Artista artista;

    public Musica(){}

    public Musica(String nomeMusica) {
        this.nome=nomeMusica;
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

    @Override
    public String toString() {
        return "Título='" + nome + '\'' +
                ", artista=" + artista.getNome();
    }
}
