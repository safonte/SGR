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
public class SobremesaService {
    public List<String> listarNomesSobremesas() {
        Transaction transaction = null;
        List<String> nomesSobr = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            nomesSobr = session.createQuery("SELECT s.nome FROM sobremesa s", String.class)
                                    .getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return nomesSobr;
    } 
    
public double getPrecoCustoByNome(String nome) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();
    double precoCusto = 0.0;

    try {
        Query<Double> query = session.createQuery("SELECT s.precoCusto FROM sobremesa s WHERE s.nome = :nome", Double.class);
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
