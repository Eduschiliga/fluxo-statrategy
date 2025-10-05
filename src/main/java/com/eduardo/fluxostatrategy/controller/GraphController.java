package com.eduardo.fluxostatrategy.controller;


import com.eduardo.fluxostatrategy.service.graph.GraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/modelo/graph")
public class GraphController {
    private final GraphService graphService;

    @GetMapping("/processar")
    public ResponseEntity<Void> processar() {
        graphService.processar();
        return ResponseEntity.noContent().build();
    }
}
