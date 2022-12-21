package ru.gb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product(String title, Integer price) {
        this.title = title;
        this.price = price;
    }
    public Product() {  }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getprice() {
        return price;
    }
    public void setprice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id = " + id + "   "+ title + "   price = " + price;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_clients",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;
    public List<Client> getClients() {
        return clients;
    }
}