package tn.indigo.msstock.services;

import tn.indigo.msstock.entities.Stock;

import java.util.Map;

public interface IStockService {

    Stock CreateStock(Stock stock);

    Stock UpdateStock(Map<Object, Object> fields, Long id);

    boolean removeStock(Stock stock);

    Stock findStockById(Long stockId);

}
