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
public class BebidaDAO {
    
    // Método para salvar uma bebida no banco de dados
    public void salvar(bebida bebida) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(bebida);
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

    // Método para listar todas bebidas:
    public List<bebida> listarTodos() {
        List<bebida> bebida = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            bebida = session.createQuery("FROM bebida", bebida.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bebida;
    }

    // Método para excluir uma bebida pelo ID
    public void excluir(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            bebida bebida = session.get(bebida.class, id);
            if (bebida != null) {
                session.delete(bebida);
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
