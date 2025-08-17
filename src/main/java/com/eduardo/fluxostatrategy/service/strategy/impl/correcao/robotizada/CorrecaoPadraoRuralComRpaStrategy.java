package com.eduardo.fluxostatrategy.service.strategy.impl.correcao.robotizada;

import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;
import com.eduardo.fluxostatrategy.service.strategy.interfaces.CorrecaoStrategy;
import org.springframework.stereotype.Component;

@Component
public class CorrecaoPadraoRuralComRpaStrategy implements CorrecaoStrategy {
    @Override
    public boolean aplicarPara(boolean automacaoAtiva) {
        return automacaoAtiva;
    }

    @Override
    public StatusFluxo calcularDestino(StatusFluxo statusFluxo) {
        System.out.println("Calculando destino FLUXO PADRÃO sem RPA - GERAL");
        return StatusFluxo.CORRECAO;
    }
}
