package ru.gb.Dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.SessionFactoryUtils;
import ru.gb.model.Client;
import ru.gb.model.Product;
import java.util.List;

@Component
public class ClientDaoImpl implements ClientDao{

   private final SessionFactoryUtils sessionFactoryUtils;
    public ClientDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> purchasedProducts(int id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            List<Product> purchasedProducts = client.getProducts();
            session.getTransaction().commit();
            return purchasedProducts;
        }
    }
}