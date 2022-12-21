package ru.gb.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.Dao.ClientDao;
import ru.gb.Dao.ProductDao;
import ru.gb.model.Client;
import ru.gb.model.Product;
import java.util.List;

@Component
public class ServiceClientProduct {
    ClientDao clientDao;
    ProductDao productDao;
    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> purchasedProducts(int idClient) {
        return clientDao.purchasedProducts(idClient);
    }

    public List<Client> clientsBoughtProduct(int idProduct) {
        return productDao.clientsBoughtProduct(idProduct);
    }
}