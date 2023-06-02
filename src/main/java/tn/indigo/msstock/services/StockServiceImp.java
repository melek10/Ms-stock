package tn.indigo.msstock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import tn.indigo.msstock.entities.Stock;
import tn.indigo.msstock.repositories.StockRepository;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class StockServiceImp implements IStockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock CreateStock(Stock stock) {
        stock.setCreatdedAt(LocalDate.now());
        return stockRepository.save(stock);
    }

    @Override
    public Stock UpdateStock(Map<Object, Object> fields, Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Stock.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, stock.get(), value);
        });
        return stockRepository.save(stock.get());
    }

    @Override
    public boolean removeStock(Stock stock) {
        return false;
    }

    @Override
    public Stock findStockById(Long stockId) {
        Optional<Stock> stock = stockRepository.findById(stockId);
        Assert.isTrue(stock.isPresent(), "There is no item for this Id");
        return stock.get();
    }

}
