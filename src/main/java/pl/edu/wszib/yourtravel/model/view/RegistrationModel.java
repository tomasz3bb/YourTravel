package pl.edu.wszib.yourtravel.model.view;

import java.sql.Date;

public class RegistrationModel {
    private String login;
    private String pass;
    private String pass2;
    private String name;
    private String surname;
    private Date birthdate;
    private String address;

    public RegistrationModel(String login, String pass, String pass2, String name, String surname, Date birthdate, String address) {
        this.login = login;
        this.pass = pass;
        this.pass2 = pass2;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
    }

    public RegistrationModel() {
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

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
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
}
