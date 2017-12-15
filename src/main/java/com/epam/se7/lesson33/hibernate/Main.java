package com.epam.se7.lesson33.hibernate;

//import com.epam.se7.lesson33.hibernate.annotaions.Department;
//import com.fasterxml.classmate.AnnotationConfiguration;
//import lombok.extern.log4j.Log4j2;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import java.util.List;
//
//@Log4j2
//public class Main {
//
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        log.info("Application started");
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
//            Department newDepartment = new Department(3, "Тестовый", "test");
//            int generatedID = create(sessionFactory, newDepartment);
//            System.out.println(generatedID);
//
//            Department department = read(sessionFactory, 0);
//            System.out.println(department);
//
//            department.setName("Test");
//            update(sessionFactory, department);
//            System.out.println(read(sessionFactory, 0));
//
//            delete(sessionFactory, newDepartment);
//
//            getAll(sessionFactory).forEach(System.out::println);
//            log.info("Application successfully end!");
//        } catch (Exception ex) {
//            log.error(ex);
//        }
//    }
//
//
//    private static int create(SessionFactory sessionFactory, Department department) {
//        try (Session session = sessionFactory.openSession()) {
//            return (Integer) session.save(department);
//        }
//    }
//
//    private static Department read(SessionFactory sessionFactory, int id) {
//        try (Session session = sessionFactory.openSession()) {
//            return session.get(Department.class, id);
//        }
//    }
//
//    private static void update(SessionFactory sessionFactory, Department department) {
//        try (Session session = sessionFactory.openSession()) {
//            session.update(department);
//        }
//    }
//
//    private static void delete(SessionFactory sessionFactory, Department department) {
//        try (Session session = sessionFactory.openSession()) {
//            session.delete(department);
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    private static List<Department> getAll(SessionFactory sessionFactory) {
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery("from Department").list();
//        }
//    }
//}
//
