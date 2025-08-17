package com.eduardo.fluxostatrategy.model.request.processo;

import com.eduardo.fluxostatrategy.model.enums.Acao;

public class ProtocolarRequest {
    private Acao acao;
    private ProcessoRequest processoRequest;

    public ProcessoRequest getProcessoRequest() {
        return processoRequest;
    }

    public void setProcessoRequest(ProcessoRequest processoRequest) {
        this.processoRequest = processoRequest;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }
}
