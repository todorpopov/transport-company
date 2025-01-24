package db.entities.company;

import db.DBUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyDAO {
    public static void save(Company company) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(company);
            transaction.commit();
        }
    }

//    public static Company getCompanyId(Long id) {
//
//    }
}
