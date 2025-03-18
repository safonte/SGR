package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class pedidoDAO {
    private final SessionFactory sessionFactory;

    public pedidoDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void adicionarPedido(pedido pedido) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(pedido);
            session.getTransaction().commit();
        }
    }

    public void atualizarPedido(pedido pedido) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(pedido);
            session.getTransaction().commit();
        }
    }

    public pedido encontrarPedidoPorId(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(pedido.class, id);
        }
    }

    public List<pedido> listarTodosOsPedidos() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from pedido", pedido.class).list();
        }
    }

    public void deletarPedido(pedido pedido) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(pedido);
            session.getTransaction().commit();
        }
    }
}
