package com.eduardo.fluxostatrategy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comentario_id", nullable = false)
    private Long comentarioId;

    @Column(name = "observacao", length = 1500)
    private String observacao;

    @Column(name = "autor")
    private String autor;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artigo_id", nullable = false)
    private Artigo artigo;
}
