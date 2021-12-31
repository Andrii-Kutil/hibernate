package com.gmail.kutilandrej;

import com.gmail.kutilandrej.entity.Child;
import com.gmail.kutilandrej.entity.Department;
import com.gmail.kutilandrej.entity.Detail;
import com.gmail.kutilandrej.entity.Employee;
import com.gmail.kutilandrej.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

  public static void main(String[] args) {
    try (SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Department.class)
        .addAnnotatedClass(Employee.class)
        .addAnnotatedClass(Detail.class)
        .addAnnotatedClass(Section.class)
        .addAnnotatedClass(Child.class)
        .buildSessionFactory()) {
//      Session session = factory.getCurrentSession();
//      session.beginTransaction();
//      Detail detail = new Detail("Kyiv", "0630636363", "example@gmail.com");
//      Department department = new Department("IT", 1500, 10000);
//      Employee employee = new Employee("Hugh", "Laurie", 1500);
//      employee.setDetail(detail);
//      employee.setDepartment(department);
//
//      session.save(employee);
//
//      Detail detail2 = new Detail("Odessa", "0630636363", "example@gmail.com");
//      Employee employee2 = new Employee("Hugh", "Laurie", 1500);
//      employee2.setDetail(detail2);
//      session.save(detail2);
//
//      session.getTransaction().commit();

      Session session = factory.getCurrentSession();
      session.beginTransaction();

      Section section1 = new Section("football");
      Section section2 = new Section("tennis");
      Section section3 = new Section("baseball");
      Child child1 = new Child("Andrii", 5);
      Child child2 = new Child("Vova", 13);
      Child child3 = new Child("Dima", 10);


//      section1.addChild(child1);
//      section1.addChild(child2);
//      section1.addChild(child3);

      child2.addSection(section1);
      child2.addSection(section2);
      child2.addSection(section3);

      session.save(child2);
      session.getTransaction().commit();
    }
  }
}
