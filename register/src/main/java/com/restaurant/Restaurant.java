package com.restaurant;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "restaurant")
public class Restaurant extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String owner;

    public String document;

    public String name;

    @OneToOne(cascade = CascadeType.ALL)
    public Location location;

    @CreationTimestamp
    public Date criationDate;

    @UpdateTimestamp
    public Date updateDate;
}
