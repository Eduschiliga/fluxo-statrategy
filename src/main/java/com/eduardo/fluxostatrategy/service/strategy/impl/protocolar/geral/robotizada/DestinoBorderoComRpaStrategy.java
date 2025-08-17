package com.eduardo.fluxostatrategy.service.strategy.impl.protocolar.geral.robotizada;

import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;
import com.eduardo.fluxostatrategy.model.enums.TipoLinha;
import com.eduardo.fluxostatrategy.service.strategy.interfaces.DestinoStrategy;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DestinoBorderoComRpaStrategy implements DestinoStrategy {
    private static final Set<Long> LINHAS_FLUXO = Set.of(170L);
    private static final TipoLinha TIPO_LINHA = TipoLinha.GERAL;

    @Override
    public boolean aplicarPara(boolean automacaoAtiva, Long linhaId, TipoLinha tipoLinha) {
        return automacaoAtiva && LINHAS_FLUXO.contains(linhaId) && TIPO_LINHA.equals(tipoLinha);
    }

    @Override
    public StatusFluxo calcularDestino(StatusFluxo statusFluxo) {
        System.out.println("Calculando destino FLUXO BORDERO com RPA - GERAL");

        return switch (statusFluxo) {
            case RASCUNHO, CORRECAO -> StatusFluxo.EM_PROCESSAMENTO;
            case EM_PROCESSAMENTO -> StatusFluxo.CONCLUIDO;

            default -> throw new IllegalStateException("Erro ao calcular destino: " + statusFluxo);
        };
    }
}
