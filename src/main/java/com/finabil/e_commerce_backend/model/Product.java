package com.finabil.e_commerce_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "short_description", nullable = false, unique = true)
    private String short_description;

    @Column(name = "long_description", nullable = false, unique = true)
    private String long_description;

    @Column(name = "price", nullable = false)
    private Double price;
    /*mappedBy = "product": This attribute defines the inverse side of the relationship.
     It means that the Inventory entity has a field (typically named product) that maps to
     this relationship. Essentially, this indicates that the Inventory entity is the owner
      of the relationship, and this side is the inverse or dependent side.*/

  /*CascadeType.REMOVE: This ensures that when the current entity (the owning entity) is deleted,
   the associated Inventory entity will also be deleted automatically. In other words,
  deleting the Product entity will trigger the removal of its associated Inventory entity as well.*/

    /*Optional = false: This implies that the association between the current entity and the Inventory entity is mandatory.
    It enforces that the Inventory object must always be present (i.e., cannot be null).
    The current entity cannot exist without a corresponding Inventory.*/

    /*Orphan Removal: This attribute ensures that if the Inventory reference is disassociated from
    the Product entity (set to null),the Inventory entity itself is automatically deleted from the database.
    It ensures the Inventory entity does not become an orphan when its relationship with the parent entity is severed.*/
    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}