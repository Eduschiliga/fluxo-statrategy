package com.eduardo.fluxostatrategy.controller;


import com.eduardo.fluxostatrategy.model.enums.StatusFluxo;
import com.eduardo.fluxostatrategy.model.request.processo.ProtocolarRequest;
import com.eduardo.fluxostatrategy.service.fluxo.CalcularFluxo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/strategy/fluxo")
public class FluxoController {
    private final CalcularFluxo calcularFluxo;

    public FluxoController(CalcularFluxo calcularFluxo) {
        this.calcularFluxo = calcularFluxo;
    }

    @PostMapping("/processar")
    public ResponseEntity<StatusFluxo> processar(@RequestBody ProtocolarRequest request) {
        return ResponseEntity.ok().body(calcularFluxo.processarFluxo(request));
    }
}
