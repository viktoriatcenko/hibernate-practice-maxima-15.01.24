package ru.maxima.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String name;

    // owning side
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person ownerOfItem;

    public Item(String name, Person ownerOfItem) {
        this.name = name;
        this.ownerOfItem = ownerOfItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
