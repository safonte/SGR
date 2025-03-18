/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import org.hibernate.Session;


import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProteinaService {
    public List<String> listarNomesProteinas() {
        // Transaction transaction = null;
        List<String> nomesProteinas = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           // transaction = session.beginTransaction();

            nomesProteinas = session.createQuery("SELECT p.nome FROM proteina p", String.class)
                                    .getResultList();

            // transaction.commit();
        } catch (Exception e) {
            //if (transaction != null) {
            //    transaction.rollback();
            //}
            e.printStackTrace();
        }

        return nomesProteinas;
    }
    
public double getPrecoCustoByNome(String nome) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();
    double precoCusto = 0.0;

    try {
        Query<Double> query = session.createQuery("SELECT p.precoCusto FROM proteina p WHERE p.nome = :nome", Double.class);
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
