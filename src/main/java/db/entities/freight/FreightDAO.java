package db.entities.freight;

import db.DBUtils;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FreightDAO implements IDAO<Freight> {
    private static FreightDAO instance;

    private FreightDAO() {
    }

    public static FreightDAO getInstance() {
        if (instance == null) {
            instance = new FreightDAO();
        }

        return instance;
    }

    @Override
    public void save(Freight freight) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(freight);
            transaction.commit();
        }
    }

    @Override
    public Freight getById(Long id) {
        Transaction transaction = null;

        Freight freight;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            freight = session.get(Freight.class, id);
            transaction.commit();
        }

        return freight;
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
            session.saveOrUpdate(freight);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;

        Freight freight;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            freight = session.get(Freight.class, id);
            session.delete(freight);
            transaction.commit();
        }
    }

    public List<Freight> getAllFreightsSorted() {
        Transaction transaction = null;

        List<Freight> freights;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            freights = session.createQuery("from Freight order by startLocation asc, endLocation asc", Freight.class).getResultList();
            transaction.commit();
        }

        return freights;
    }

    public List<Freight> filterByLocation(String keyword) {
        Transaction transaction = null;

        List<Freight> freights;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "from Freight where lower(startLocation) like lower(:keyword) or lower(endLocation) like lower(:keyword)";
            Query<Freight> query = session.createQuery(hql, Freight.class);
            query.setParameter("keyword", keyword);
            freights = query.list();
            transaction.commit();
        }

        return freights;
    }

    public Long getNumberOfFreights() {
        Transaction transaction = null;

        Long result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            result = session.createQuery("select count(*) from Freight", Long.class).getSingleResult();
            transaction.commit();
        }

        return result;
    }

    public Double getTotalProfits() {
        Transaction transaction = null;

        Double result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            result = session.createQuery("select sum(profit) from Freight", Double.class).getSingleResult();
            transaction.commit();
        }

        return result;
    }
}
