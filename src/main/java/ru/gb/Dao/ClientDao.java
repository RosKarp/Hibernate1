package ru.gb.Dao;

import org.springframework.stereotype.Component;
import ru.gb.model.Product;
import java.util.List;

@Component
public interface ClientDao {
    List<Product> purchasedProducts (int idClient);
}