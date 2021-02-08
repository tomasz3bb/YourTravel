package pl.edu.wszib.yourtravel.model;

import javax.persistence.*;

@Entity(name = "torderposition")
public class OrderPositions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pieces;
    @ManyToOne(fetch = FetchType.EAGER)
    private Tour tour;
    @ManyToOne( fetch = FetchType.EAGER)
    private Order order;

    public OrderPositions() {
    }

    public OrderPositions(int id, int pieces, Tour tour, Order order) {
        this.id = id;
        this.pieces = pieces;
        this.tour = tour;
        this.order = order;
    }

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
        return
                "Ilość osób: " + pieces + " " + "Wycieczka: " + tour ;
    }

}
