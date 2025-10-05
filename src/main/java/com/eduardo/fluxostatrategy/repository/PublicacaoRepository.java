package com.eduardo.fluxostatrategy.repository;

import com.eduardo.fluxostatrategy.entity.Publicacao;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    @Override
    @EntityGraph(value = "Publicacao.comArtigos")
    List<Publicacao> findAll();

    @EntityGraph(value = "Publicacao.comArtigos")
    Optional<Publicacao> findById(Long publicacaoId);

    @EntityGraph(value = "Publicacao.comArtigosEComentarios")
    List<Publicacao> findByIdComArtigosEComentarios(Long publicacaoId);
}
