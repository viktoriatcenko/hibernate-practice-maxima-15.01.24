package ru.maxima.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "ownerOfItem", fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToMany(mappedBy = "memberOfFamily", fetch = FetchType.LAZY)
    private List<Sibling> siblings;

    @OneToMany(mappedBy = "ownerOfCar", fetch = FetchType.LAZY)
    private List<Car> cars;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
