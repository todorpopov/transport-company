package db.entities.freight;

import db.DBUtils;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FreightDAO implements IDAO<Freight> {
    @Override
    public void save(Freight freight) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(freight);
            transaction.commit();
        }
    }

    @Override
    public Freight getById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Freight.class, id);
        }
    }

    @Override
    public List<Freight> getAll() {
        Transaction transaction = null;

        List<Freight> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Freight", Freight.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    @Override
    public void update(Freight freight) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.merge(freight);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Freight freight = session.get(Freight.class, id);
            if (freight != null) {
                session.remove(freight);
            }
        }
    }

    // Method for calculating the total profits from all freights of the company

    // Method for filtering freights by start and end date

    // Method for filtering freights by their price

    // Filter by destination
}
