package db.entities.driver;

import db.DBUtils;
import db.entities.driver.dtos.DriverShortDesciptionDTO;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverDAO implements IDAO<Driver> {
    private static DriverDAO instance;

    private DriverDAO() {
    }

    public static DriverDAO getInstance() {
        if (instance == null) {
            instance = new DriverDAO();
        }

        return instance;
    }

    @Override
    public void save(Driver driver) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(driver);
            transaction.commit();
        }
    }

    @Override
    public Driver getById(Long id) {
        Transaction transaction = null;

        Driver driver;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            transaction.commit();
        }

        return driver;
    }

    @Override
    public List<Driver> getAll() {
        Transaction transaction = null;

        List<Driver> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Driver", Driver.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    @Override
    public void update(Driver driver) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;

        Driver driver;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            session.delete(driver);
            transaction.commit();
        }
    }

    public List<Driver> filterByQualification(EDriverQualification qualification) {
        Transaction transaction = null;

        List<Driver> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "from Driver where qualification = :qualification";
            Query<Driver> query = session.createQuery(hql, Driver.class);
            query.setParameter("qualification", qualification);
            result = query.list();

            transaction.commit();
        }

        return result;
    }

    public List<Driver> sortBySalary() {
        Transaction transaction = null;

        List<Driver> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            result = session.createQuery("from Driver order by salary desc", Driver.class).getResultList();
            transaction.commit();
        }

        return result;
    }

    public List<Driver> filterBySalary(Double lowerBoundIncluded, Double upperBoundIncluded) {
        Transaction transaction = null;

        List<Driver> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "from Driver where salary >= :lowerBoundIncluded and salary <= :upperBoundIncluded";
            Query<Driver> query = session.createQuery(hql, Driver.class);
            query.setParameter("lowerBoundIncluded", lowerBoundIncluded);
            query.setParameter("upperBoundIncluded", upperBoundIncluded);
            result = query.list();

            transaction.commit();
        }

        return result;
    }

    public Map<DriverShortDesciptionDTO, Double> mapDriversByTotalProfits() {
        Transaction transaction = null;

        List<Object[]> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "SELECT d.id, d.name, SUM(f.profit) " +
                    "FROM Driver d " +
                    "JOIN d.freights f " +
                    "GROUP BY d.id";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            result = query.list();

            transaction.commit();
        }

        Map<DriverShortDesciptionDTO, Double> driverProfitsMap = new HashMap<>();
        for (Object[] objects : result) {
            Long driverId = (Long) objects[0];
            String driverName = (String) objects[1];
            Double profit = (Double) objects[2];

            DriverShortDesciptionDTO dto = new DriverShortDesciptionDTO(driverId, driverName);

            driverProfitsMap.put(dto, profit);
        }

        return driverProfitsMap;
    }

    public Map<DriverShortDesciptionDTO, Long> mapDriversByFreightCount() {
        Transaction transaction = null;

        List<Object[]> result;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();

            String hql = "SELECT d.id, d.name, COUNT(f) " +
                    "FROM Driver d " +
                    "JOIN d.freights f " +
                    "GROUP BY d.id";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            result = query.list();

            transaction.commit();
        }

        Map<DriverShortDesciptionDTO, Long> driverProfitsMap = new HashMap<>();
        for (Object[] objects : result) {
            Long driverId = (Long) objects[0];
            String driverName = (String) objects[1];
            Long count = (Long) objects[2];

            DriverShortDesciptionDTO dto = new DriverShortDesciptionDTO(driverId, driverName);

            driverProfitsMap.put(dto, count);
        }

        return driverProfitsMap;
    }
}
