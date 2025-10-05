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
@Entity(name = "publicacao")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "Publicacao.comArtigos",
                attributeNodes = {
                        @NamedAttributeNode("artigoList")
                }
        ),
        @NamedEntityGraph(
                name = "Publicacao.comArtigosEComentarios",
                attributeNodes = {
                        @NamedAttributeNode(
                                value = "artigoList",
                                subgraph = "subgrafo-artigoList"
                        )
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "subgrafo-artigoList",
                                attributeNodes = {
                                        @NamedAttributeNode("comentarioList")
                                }
                        )
                }
        )
})
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publicacao_id", nullable = false)
    private Long publicacaoId;

    @Column(name = "titulo")
    private String titulo;

    @ToString.Exclude
    @OneToMany(mappedBy = "publicacao", fetch = FetchType.LAZY)
    private List<Artigo> artigoList = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "publicacao", fetch = FetchType.LAZY)
    private List<Curtida> curtidaList = new ArrayList<>();
}
