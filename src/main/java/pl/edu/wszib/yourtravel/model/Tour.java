package pl.edu.wszib.yourtravel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "ttour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String country;
    private Date startDate;
    private Date endDate;
    private double price;
    private int seats;

    public Tour() {
    }

    public Tour(int id, String title, String country, Date startDate, Date endDate, double price, int seats) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.seats = seats;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Tour clone (){
        return new Tour(this.id, this.title, this.country, this.startDate, this.endDate, this.price, this.seats);
    }

    @Override
    public String toString() {
        return title + ", " + country;
    }
}
