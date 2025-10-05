package com.eduardo.fluxostatrategy.service.graph;

import com.eduardo.fluxostatrategy.entity.Publicacao;
import com.eduardo.fluxostatrategy.repository.PublicacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GraphService {
    private final PublicacaoRepository publicacaoRepository;

    @Transactional(readOnly = true)
    public void processar() {
        // A "1" consulta é executada aqui
        List<Publicacao> publicacoes = publicacaoRepository.findAll();

        log.info("Total de publicações encontradas: {}", publicacoes.size());

        // O loop itera sobre as N publicações
        for (Publicacao pub : publicacoes) {
            // Acessar.getArtigos().size() dispara uma consulta adicional para cada publicação
            // Esta's são as "N" consultas
            log.info("Publicação '{}' tem {} artigos.", pub.getTitulo(), pub.getArtigoList().size());
        }
    }
}
