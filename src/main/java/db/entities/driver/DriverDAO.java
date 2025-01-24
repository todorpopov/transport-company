package db.entities.driver;

import db.DBUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DriverDAO {
    public static void save(Driver driver) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(driver);
            transaction.commit();
        }
    }

    public static Driver getDriverById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Driver.class, id);
        }
    }

    public static List<Driver> getAllDrivers() {
        Transaction transaction = null;

        List<Driver> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Driver", Driver.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    public static void updateDriver(Driver driver) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.merge(driver);
            transaction.commit();
        }
    }

    public static void deleteDriverById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Driver driver = session.get(Driver.class, id);
            if (driver != null) {
                session.remove(driver);
            }
        }
    }
}
