package dev.manoj.h2demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {

    @Id
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

    public Employee(){

    }

    public Employee(long id, String firstname, String secondname) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
    }

    public long getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Override
    public String toString(){
        return "Employee [ id = "+this.id +" , firstname is "+this.firstname+"secondname = "+this.secondname+" ]";
    }
}
