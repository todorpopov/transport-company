package db.entities.vehicle;

import db.DBUtils;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleDAO implements IDAO<Vehicle> {
    private static VehicleDAO instance;

    private VehicleDAO() {
    }

    public static VehicleDAO getInstance() {
        if (instance == null) {
            instance = new VehicleDAO();
        }

        return instance;
    }

    @Override
    public void save(Vehicle vehicle) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }

    @Override
    public Vehicle getById(Long id) {
        Transaction transaction = null;

        Vehicle vehicle;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            vehicle = session.get(Vehicle.class, id);
            transaction.commit();
        }

        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        Transaction transaction = null;

        List<Vehicle> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Vehicle", Vehicle.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    @Override
    public void update(Vehicle vehicle) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;

        Vehicle vehicle;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            vehicle = session.get(Vehicle.class, id);
            session.delete(vehicle);
            transaction.commit();
        }
    }
}
