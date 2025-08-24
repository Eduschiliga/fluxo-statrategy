package com.eduardo.fluxostatrategy.model.request.processo;

import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;
import com.eduardo.fluxostatrategy.model.enums.TipoLinha;
import lombok.Data;

@Data
public class ProcessoRequest {
    private boolean automacaoAtiva;
    private Long linhaId;
    private TipoLinha tipoLinha;
    private StatusFluxo statusAtual;
}
