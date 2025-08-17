package com.eduardo.fluxostatrategy.model.request.processo;

import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;
import com.eduardo.fluxostatrategy.model.enums.TipoLinha;

public class ProcessoRequest {
    private boolean automacaoAtiva;
    private Long linhaId;
    private TipoLinha tipoLinha;
    private StatusFluxo statusAtual;

    public boolean isAutomacaoAtiva() {
        return automacaoAtiva;
    }

    public void setAutomacaoAtiva(boolean automacaoAtiva) {
        this.automacaoAtiva = automacaoAtiva;
    }

    public Long getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(Long linhaId) {
        this.linhaId = linhaId;
    }

    public TipoLinha getTipoLinha() {
        return tipoLinha;
    }

    public void setTipoLinha(TipoLinha tipoLinha) {
        this.tipoLinha = tipoLinha;
    }

    public StatusFluxo getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(StatusFluxo statusAtual) {
        this.statusAtual = statusAtual;
    }
}
