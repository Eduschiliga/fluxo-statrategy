package com.eduardo.fluxostatrategy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity(name = "artigo")
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artigo_id", nullable = false)
    private Long artigoId;

    @Column(name = "titulo")
    private String manchete;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacao_id", nullable = false)
    private Publicacao publicacao;

    @ToString.Exclude
    @OneToMany(mappedBy = "artigo", fetch = FetchType.LAZY)
    private List<Comentario> comentarioList = new ArrayList<>();
}
