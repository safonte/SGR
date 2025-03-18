/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Service.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author safon
 */
public class SobremesaDAO {
        // Método para salvar uma sobremesa no banco de dados
    public void salvar(sobremesa sobremesa) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(sobremesa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar bebida: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Método para listar todas sobremesas:
    public List<sobremesa> listarTodos() {
        List<sobremesa> sobremesa = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sobremesa = session.createQuery("FROM sobremesa", sobremesa.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sobremesa;
    }

    // Método para excluir uma sobremesa pelo ID
    public void excluir(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            sobremesa sobremesa = session.get(sobremesa.class, id);
            if (sobremesa != null) {
                session.delete(sobremesa);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir bebida: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
