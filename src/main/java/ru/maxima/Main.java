package ru.maxima;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.maxima.model.*;

import java.util.List;

// CRUD

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Sibling.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Citizen.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Person person = session.get(Person.class, 4);

            List<Item> items = person.getItems();

            System.out.println(items);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


//            Получение человека
//            Person person = session.get(Person.class, 1);
//
//            System.out.println(person.getName());

//            Сохранение данных
//            Person person1 = new Person("Pavel", "pavel@mail.ru", 25);
//            Person person2 = new Person("Sergey", "segey@mail.ru", 25);
//            Person person3 = new Person("Ivan", "ivan@mail.ru", 25);
//
//            Person save = (Person) session.save(person1);
//            session.save(person2);
//            session.save(person3);

//            // Обновление данных
//
//            Person person = session.get(Person.class, 1);
//
//            person.setName("New Viktor");
//            person.setEmail("new@mail.ru");
//
//
//            session.getTransaction().commit();

//            // Удаление данных
//            Person person = session.get(Person.class, 3);
//
//            session.delete(person);
//
//    List<Person> people = session.createQuery("from Person where email like '%mail.ru' ").getResultList();
//
//            System.out.println(people);

//            Person person = session.get(Person.class, 4);
//
//            List<Item> items = person.getItems();

//            System.out.println(items);

//            Item item = session.get(Item.class, 4);
//
//            System.out.println(item.getOwnerOfItem());

//            Person person = session.get(Person.class, 4);
//
//            Item car = new Item("Ferrari", person);
//
//            session.save(car);

//            Citizen citizen = session.get(Citizen.class, 1);
//
//            Passport passport = citizen.getPassport();
//
//            System.out.println(passport.getNumber());