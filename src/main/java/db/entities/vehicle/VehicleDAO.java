package db.entities.vehicle;

import db.DBUtils;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleDAO implements IDAO<Vehicle> {
    @Override
    public void save(Vehicle vehicle) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(vehicle);
            transaction.commit();
        }
    }

    @Override
    public Vehicle getById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Vehicle.class, id);
        }
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
            session.merge(vehicle);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Vehicle vehicle = session.get(Vehicle.class, id);
            if (vehicle != null) {
                session.remove(vehicle);
            }
        }
    }
}
