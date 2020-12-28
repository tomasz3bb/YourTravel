package pl.edu.wszib.yourtravel.model;


import java.sql.Date;

public class User {
    private int id;
    private String login;
    private String pass;
    private Role role;
    private String name;
    private String surname;
    private Date birthdate;
    private String address;

    public User() {
    }

    public User(int id, String login, String pass, Role role, String name, String surname, Date birthdate, String address) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                '}';
    }

    public enum Role{
        ADMIN,
        USER
    }

}
