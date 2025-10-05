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
@Entity(name = "curtida")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long curtidaId;

    @Column(nullable = false)
    private boolean curtida;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacao_id", nullable = false)
    private Publicacao publicacao;
}
