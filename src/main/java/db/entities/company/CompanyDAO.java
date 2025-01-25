package db.entities.company;

import db.DBUtils;
import db.entities.driver.DriverDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAO {
    public static void save(Company company) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(company);
            transaction.commit();
        }
    }

    public static Company getCompanyById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Company.class, id);
        }
    }

    public static List<Company> getAllCompanies() {
        Transaction transaction = null;

        List<Company> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Company", Company.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    public static void updateCompany(Company company) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.merge(company);
            transaction.commit();
        }
    }

    public static void deleteCompanyById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Company company = session.get(Company.class, id);
            if (company != null) {
                session.remove(company);
            }
        }
    }

    // Method for calculating the total profits from all freights of the company

    // Method for getting the count of all freights

    // Method for listing all drivers with their representative number of freights

    // Method for filtering freights by start and end date and combining their profits

    // Method for listing all profits by individual drivers
}
