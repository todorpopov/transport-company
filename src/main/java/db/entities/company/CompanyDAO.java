package db.entities.company;

import db.DBUtils;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAO implements IDAO<Company> {
    @Override
    public void save(Company company) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(company);
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
            session.merge(company);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Company company = session.get(Company.class, id);
            if (company != null) {
                session.remove(company);
            }
        }
    }

    // Sort companies by name

    // Sort companies by profits

    // Filter companies by profits
}
