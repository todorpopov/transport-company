package db.entities.driver;

import db.DBUtils;
import db.entities.vehicle.Vehicle;
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
            session.save(driver);
            transaction.commit();
        }
    }

    @Override
    public Driver getById(Long id) {
        Transaction transaction = null;

        Driver driver;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            transaction.commit();
        }

        return driver;
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
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;

        Driver driver;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            session.delete(driver);
            transaction.commit();
        }
    }

    // Filter by qualification

    // Sort by salary

    // Filter by salary

    // Map of all drivers with their representative number of freights

    // All profits a driver has brought in to the company
}
