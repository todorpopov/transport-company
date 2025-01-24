package db.entities.freight;

import db.DBUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FreightDAO {
    public static void save(Freight freight) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(freight);
            transaction.commit();
        }
    }

    public static Freight getFreightById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Freight.class, id);
        }
    }

    public static List<Freight> getAllFreight() {
        Transaction transaction = null;

        List<Freight> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Freight", Freight.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    public static void updateFreight(Freight freight) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.merge(freight);
            transaction.commit();
        }
    }

    public static void deleteFreightById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Freight freight = session.get(Freight.class, id);
            if (freight != null) {
                session.remove(freight);
            }
        }
    }
}
