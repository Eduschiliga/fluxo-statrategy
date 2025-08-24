package com.eduardo.fluxostatrategy.model.request.processo;

import com.eduardo.fluxostatrategy.model.enums.Acao;
import lombok.Data;

@Data
public class ProtocolarRequest {
    private Acao acao;
    private ProcessoRequest processoRequest;
}
