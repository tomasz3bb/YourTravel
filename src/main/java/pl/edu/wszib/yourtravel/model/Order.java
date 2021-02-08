package pl.edu.wszib.yourtravel.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "torder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderPositions> positions = new HashSet<>();
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        ORDERED,
        ACCEPTED,
        ENDED
    }

    public Order() {
    }

    public Order(int id, User user, Set<OrderPositions> positions, double price, Status status) {
        this.id = id;
        this.user = user;
        this.positions = positions;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderPositions> getPositions() {
        return positions;
    }

    public void setPositions(Set<OrderPositions> positions) {
        this.positions = positions;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", positions=" + positions +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
