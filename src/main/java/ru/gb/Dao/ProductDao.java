package ru.gb.Dao;

import org.springframework.stereotype.Component;
import ru.gb.model.Client;
import java.util.List;

@Component
public interface ProductDao {
    List<Client> clientsBoughtProduct (int idProduct);
}