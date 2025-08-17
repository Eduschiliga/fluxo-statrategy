package com.eduardo.fluxostatrategy.service.strategy.factory;

import com.eduardo.fluxostatrategy.model.enums.TipoLinha;
import com.eduardo.fluxostatrategy.service.strategy.interfaces.CorrecaoStrategy;
import com.eduardo.fluxostatrategy.service.strategy.interfaces.DestinoStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FluxoStrategyFactory {
    private final List<DestinoStrategy> strategyDestino;
    private final List<CorrecaoStrategy> strategyCorrecao;

    public FluxoStrategyFactory(List<DestinoStrategy> strategyDestino, List<CorrecaoStrategy> strategyCorrecao) {
        this.strategyDestino = strategyDestino;
        this.strategyCorrecao = strategyCorrecao;
    }

    public DestinoStrategy getStrategyDestino(boolean automacaoAtiva, Long linhaId, TipoLinha tipoLinha) {
        return strategyDestino.stream()
                .filter(strategy -> strategy.aplicarPara(automacaoAtiva, linhaId, tipoLinha))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Nenhuma estratégia encontrada para os parâmetros: automacaoAtiva="
                                + automacaoAtiva + ", linhaId=" + linhaId));
    }

    public CorrecaoStrategy getStrategyCorrecao(boolean automacaoAtiva) {
        return strategyCorrecao.stream()
                .filter(strategy -> strategy.aplicarPara(automacaoAtiva))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Nenhuma estratégia encontrada para os parâmetros: automacaoAtiva="
                                + automacaoAtiva));
    }
}
