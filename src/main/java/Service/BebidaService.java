/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author safon
 */
public class BebidaService {
      public List<String> listarNomesBebidas() {
        Transaction transaction = null;
        List<String> nomesBebida = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            nomesBebida = session.createQuery("SELECT b.nome FROM bebida b", String.class)
                                    .getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return nomesBebida;
    } 
      
public double getPrecoCustoByNome(String nome) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();
    double precoCusto = 0.0;

    try {
        Query<Double> query = session.createQuery("SELECT b.precoCusto FROM bebida b WHERE b.nome = :nome", Double.class);
        query.setParameter("nome", nome);
        precoCusto = query.uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
        sessionFactory.close();
    }

    return precoCusto;
}
      
}
