package ru.gb.Dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.SessionFactoryUtils;
import ru.gb.model.Client;
import ru.gb.model.Product;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao{

    private final SessionFactoryUtils sessionFactoryUtils;
    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Client> clientsBoughtProduct(int id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            List<Client> clientsBoughtProduct = product.getClients();
            session.getTransaction().commit();
            return clientsBoughtProduct;
        }
    }
}