package db.entities.vehicle;

import db.DBUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleDAO {
    public static void save(Vehicle vehicle) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(vehicle);
            transaction.commit();
        }
    }

    public static Vehicle getVehicleById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Vehicle.class, id);
        }
    }

    public static List<Vehicle> getAllVehicle() {
        Transaction transaction = null;

        List<Vehicle> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Vehicle", Vehicle.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    public static void updateVehicle(Vehicle vehicle) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.merge(vehicle);
            transaction.commit();
        }
    }

    public static void deleteVehicleById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Vehicle vehicle = session.get(Vehicle.class, id);
            if (vehicle != null) {
                session.remove(vehicle);
            }
        }
    }
}
