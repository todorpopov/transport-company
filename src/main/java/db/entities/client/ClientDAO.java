package db.entities.client;

import db.DBUtils;
import db.interfaces.IDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDAO implements IDAO<Client> {
    @Override
    public void save(Client client) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    @Override
    public Client getById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Client.class, id);
        }
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
            session.merge(client);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
            }
        }
    }
}
