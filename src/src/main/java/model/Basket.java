package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketId")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "product_basket",
            joinColumns = {@JoinColumn(name = "basketId")},
            inverseJoinColumns = {@JoinColumn(name = "productId")})
    private List<Product> products;

    public Basket() {
    }

    public Basket(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public int getSizeOfBasket() {
        return products.size();
    }

    public void resetBasket(){
        products = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id = " + id +
                ", user = " + user +
                ", products = " + products +
                '}';
    }
}
