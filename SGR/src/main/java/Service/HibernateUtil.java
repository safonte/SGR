package Service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Carrega as configurações do hibernate.cfg.xml e cria a SessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Loga a exceção e relança como uma exceção de inicialização
            System.err.println("Falha ao criar a SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Fecha a SessionFactory ao encerrar a aplicação
        getSessionFactory().close();
    }
}