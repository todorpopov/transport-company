package db.entities.driver;

import db.DBUtils;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DriverDAO implements IDAO<Driver> {
    private static DriverDAO instance;

    private DriverDAO() {
    }

    public static DriverDAO getInstance() {
        if (instance == null) {
            instance = new DriverDAO();
        }

        return instance;
    }

    @Override
    public void save(Driver driver) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(driver);
            transaction.commit();
        }
    }

    @Override
    public Driver getById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Driver.class, id);
        }
    }

    @Override
    public List<Driver> getAll() {
        Transaction transaction = null;

        List<Driver> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Driver", Driver.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    @Override
    public void update(Driver driver) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.merge(driver);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Driver driver = session.get(Driver.class, id);
            if (driver != null) {
                session.remove(driver);
            }
        }
    }

    // Method for listing all drivers with their representative number of freights

    // Method for listing all profits by individual drivers

    // Filter drivers by qualification

    // Sort drivers by salary

    // Filter drivers by salary
}
