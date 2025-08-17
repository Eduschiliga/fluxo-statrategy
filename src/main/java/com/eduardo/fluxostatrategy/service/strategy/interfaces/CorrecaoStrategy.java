package com.eduardo.fluxostatrategy.service.strategy.interfaces;

import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;

public interface CorrecaoStrategy {
    boolean aplicarPara(boolean automacaoAtiva);

    StatusFluxo calcularDestino(StatusFluxo statusFluxo);
}
