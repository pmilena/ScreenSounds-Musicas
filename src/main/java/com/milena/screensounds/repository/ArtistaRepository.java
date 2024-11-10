package com.milena.screensounds.repository;

import com.milena.screensounds.model.Artista;
import com.milena.screensounds.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista,Long> {

    @Query("SELECT a FROM Artista a WHERE a.nome ILIKE %:nome%")
    Optional<Artista> findByName(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musica> findMusicaByArtista(String nome);
}
