package db.entities.company;

import db.DBUtils;
import db.entities.vehicle.Vehicle;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAO implements IDAO<Company> {
    private static CompanyDAO instance;

    private CompanyDAO() {
    }

    public static CompanyDAO getInstance() {
        if (instance == null) {
            instance = new CompanyDAO();
        }

        return instance;
    }

    @Override
    public void save(Company company) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    @Override
    public Company getById(Long id) {
        Transaction transaction = null;
        Company company;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }
        return company;
    }

    @Override
    public List<Company> getAll() {
        Transaction transaction = null;

        List<Company> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Company", Company.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    @Override
    public void update(Company company) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;

        Company company;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            session.delete(company);
            transaction.commit();
        }
    }

    // Sort by name

    // Sort by profits

    // Filter by profits

    // All profits for a range of dates
}
