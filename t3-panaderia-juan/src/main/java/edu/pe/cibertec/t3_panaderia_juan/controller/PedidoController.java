package edu.pe.cibertec.t3_panaderia_juan.controller;

import edu.pe.cibertec.t3_panaderia_juan.dto.GenericResponseDto;
import edu.pe.cibertec.t3_panaderia_juan.dto.PedidoDTO;
import edu.pe.cibertec.t3_panaderia_juan.service.impl.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedido(@PathVariable Integer id) {
        PedidoDTO pedidoDTO = pedidoService.obtenerPedidoPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> obtenerTodosLosPedidos() {
        List<PedidoDTO> pedidos = pedidoService.obtenerTodosLosPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto> registrarPedido(@RequestBody PedidoDTO pedidoDto) {
        GenericResponseDto respuesta = pedidoService.registrarPedido(pedidoDto);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

}
