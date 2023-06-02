package tn.indigo.msstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.indigo.msstock.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {


}
