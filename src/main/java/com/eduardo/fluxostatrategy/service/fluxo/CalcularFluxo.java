package com.eduardo.fluxostatrategy.service.fluxo;

import com.eduardo.fluxostatrategy.model.enums.Acao;
import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;
import com.eduardo.fluxostatrategy.model.enums.TipoLinha;
import com.eduardo.fluxostatrategy.model.request.processo.ProcessoRequest;
import com.eduardo.fluxostatrategy.model.request.processo.ProtocolarRequest;
import com.eduardo.fluxostatrategy.service.strategy.factory.FluxoStrategyFactory;
import com.eduardo.fluxostatrategy.service.strategy.interfaces.CorrecaoStrategy;
import com.eduardo.fluxostatrategy.service.strategy.interfaces.DestinoStrategy;
import org.springframework.stereotype.Service;

@Service
public class CalcularFluxo {
    private final FluxoStrategyFactory strategyFactory;

    public CalcularFluxo(FluxoStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    /**
     * orquestra a execução do fluxo.
     *
     * @param request contendo todos os atributos necessários para executar o fluxo correto
     */
    public StatusFluxo processarFluxo(ProtocolarRequest request) {
        Acao acao = request.getAcao();

        return switch (acao) {
            case PROTOCOLAR -> handleDestino(request.getProcessoRequest());
            case CORRECAO -> handleCorrecao(request.getProcessoRequest());

            default -> throw new IllegalArgumentException("Sem processamento para as demais ações");
        };
    }

    private StatusFluxo handleCorrecao(ProcessoRequest processoRequest) {
        boolean automacaoAtiva = processoRequest.isAutomacaoAtiva();
        StatusFluxo statusAtual = processoRequest.getStatusAtual();

        CorrecaoStrategy correcaoStrategy = strategyFactory.getStrategyCorrecao(automacaoAtiva);

        return correcaoStrategy.calcularDestino(statusAtual);
    }

    private StatusFluxo handleDestino(ProcessoRequest processoRequest) {
        boolean automacaoAtiva = processoRequest.isAutomacaoAtiva();
        StatusFluxo statusAtual = processoRequest.getStatusAtual();
        Long linhaId = processoRequest.getLinhaId();
        TipoLinha tipoLinha = processoRequest.getTipoLinha();

        DestinoStrategy destinoStrategy = strategyFactory.getStrategyDestino(automacaoAtiva, linhaId, tipoLinha);

        return destinoStrategy.calcularDestino(statusAtual);

    }
}
