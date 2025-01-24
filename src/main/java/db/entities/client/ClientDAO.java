package db.entities.client;

import db.DBUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDAO {
    public static void save(Client client) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public static Client getClientById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            return session.get(Client.class, id);
        }
    }

    public static List<Client> getAllClients() {
        Transaction transaction = null;

        List<Client> companies;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            companies = session.createQuery("from Client", Client.class).getResultList();
            transaction.commit();
        }

        return companies;
    }

    public static void updateClient(Client client) {
        Transaction transaction = null;

        try (Session session = DBUtils.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }
    }

    public static void deleteClientById(Long id) {
        try (Session session = DBUtils.getCurrentSession()) {
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
            }
        }
    }
}
