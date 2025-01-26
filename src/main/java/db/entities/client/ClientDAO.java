package db.entities.client;

import db.DBUtils;
import db.entities.vehicle.Vehicle;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDAO implements IDAO<Client> {
    private static ClientDAO instance;

    private ClientDAO() {
    }

    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }

        return instance;
    }

    @Override
    public void save(Client client) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    @Override
    public Client getById(Long id) {
        Transaction transaction = null;

        Client client;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            client = session.get(Client.class, id);
            transaction.commit();
        }

        return client;
    }

    @Override
    public List<Client> getAll() {
        Transaction transaction = null;

        List<Client> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Client", Client.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    @Override
    public void update(Client client) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;

        Client client;
        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            client = session.get(Client.class, id);
            session.delete(client);
            transaction.commit();
        }
    }
}
