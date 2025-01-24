package db.entities.vehicle;

import db.DBUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VehicleDAO {
    public static void save(VehicleDTO dto) {
        Vehicle vehicle = VehicleDTO.toEntity(dto);

        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(vehicle);
            transaction.commit();
        }
    }
}
