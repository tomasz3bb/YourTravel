package pl.edu.wszib.yourtravel.model;

import javax.persistence.*;

@Entity(name = "orderposition")
public class OrderPositions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pieces;
    @ManyToOne(fetch = FetchType.EAGER)
    private Tour tour;
    @ManyToOne( fetch = FetchType.EAGER)
    private Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderPositions{" +
                "id=" + id +
                ", pieces=" + pieces +
                ", tour=" + tour +
                ", order=" + order +
                '}';
    }
}
