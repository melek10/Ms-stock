package tn.indigo.msstock.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.indigo.msstock.entities.Stock;
import tn.indigo.msstock.services.IStockService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("stock")
public class StockController {
    private final IStockService stockService;

    @PatchMapping("{id}")
    Stock updateStock(
            @RequestBody Map<Object, Object> fields,
            @PathVariable Long id
    ){
        return stockService.UpdateStock(fields, id);
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable("id") Long id){
        return stockService.findStockById(id);
    }

}
