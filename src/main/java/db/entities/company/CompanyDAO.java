package db.entities.company;

import db.DBUtils;
import db.entities.company.dtos.CompanyProfitsByDateDTO;
import db.entities.company.dtos.CompanyProfitsDTO;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<Company> sortByName() {
        Transaction transaction = null;

        List<Company> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            result = session.createQuery("from Company order by name asc", Company.class).getResultList();
            transaction.commit();
        }

        return result;
    }

    public List<CompanyProfitsDTO> sortByProfits() {
        Transaction transaction = null;

        List<Object[]> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "select c.id, c.name, sum(f.profit) " +
                    "from Company c " +
                    "join c.freights f " +
                    "group by c.id " +
                    "order by sum(f.profit) desc";

            Query<Object[]> query = session.createQuery(hql);
            result = query.list();

            transaction.commit();
        }

        List<CompanyProfitsDTO> companyProfitsList = new ArrayList<>();
        for (Object[] row : result) {
            Long id = (Long) row[0];
            String name = (String) row[1];
            Double profits = (Double) row[2];

            CompanyProfitsDTO dto = new CompanyProfitsDTO(id, name, profits);
            companyProfitsList.add(dto);
        }

        return companyProfitsList;
    }

    public List<CompanyProfitsDTO> filterByProfits(Double lowerBoundInclusive, Double upperBoundInclusive) {
        Transaction transaction = null;

        List<Object[]> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "select c.id, c.name, sum(f.profit) as profit " +
                    "from Company c " +
                    "join c.freights f " +
                    "group by c.id " +
                    "having sum(f.profit) between :lower and :upper " +
                    "order by sum(f.profit) asc";

            Query<Object[]> query = session.createQuery(hql)
                    .setParameter("lower", lowerBoundInclusive)
                    .setParameter("upper", upperBoundInclusive);
            result = query.list();

            transaction.commit();
        }

        List<CompanyProfitsDTO> companyProfitsList = new ArrayList<>();
        for (Object[] row : result) {
            Long id = (Long) row[0];
            String name = (String) row[1];
            Double profits = (Double) row[2];

            CompanyProfitsDTO dto = new CompanyProfitsDTO(id, name, profits);
            companyProfitsList.add(dto);
        }

        return companyProfitsList;
    }

    public List<CompanyProfitsByDateDTO> filterProfitsByDate(LocalDate startDate, LocalDate endDate) {
        Transaction transaction = null;

        List<Object[]> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "select c.id, c.name, sum(f.profit) as profit, f.startDate, f.endDate " +
                    "from Company c " +
                    "join c.freights f " +
                    "where f.startDate >= :startDate and f.endDate <= :endDate " +
                    "group by c.id, c.name, f.startDate, f.endDate " +
                    "order by profit desc";

            Query<Object[]> query = session.createQuery(hql)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);
            result = query.list();

            transaction.commit();
        }

        List<CompanyProfitsByDateDTO> companyProfitsList = new ArrayList<>();
        for (Object[] row : result) {
            Long id = (Long) row[0];
            String name = (String) row[1];
            Double profits = (Double) row[2];
            LocalDate start = (LocalDate) row[3];
            LocalDate end = (LocalDate) row[4];

            CompanyProfitsByDateDTO dto = new CompanyProfitsByDateDTO(id, name, profits, start, end);
            companyProfitsList.add(dto);
        }

        return companyProfitsList;
    }
}
