package com.eduardo.fluxostatrategy.service.strategy.interfaces;

import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;
import com.eduardo.fluxostatrategy.model.enums.TipoLinha;

public interface DestinoStrategy {
    boolean aplicarPara(boolean automacaoAtiva, Long linhaId, TipoLinha tipoLinha);

    StatusFluxo calcularDestino(StatusFluxo statusFluxo);
}
