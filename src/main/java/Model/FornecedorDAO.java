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
public class FornecedorDAO {
    
// Método para listar todos os fornecedores
    public List<Fornecedor> listarTodos() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            fornecedores = session.createQuery("FROM Fornecedor", Fornecedor.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedores;
    }
    
    
// Método para salvar um fornecedor no banco de dados
    public void salvar(Fornecedor fornecedor) {
        Session session = null;
        Transaction transaction = null;

        try {
            // 1. Abre uma sessão com o banco de dados
            session = HibernateUtil.getSessionFactory().openSession();

            // 2. Inicia uma transação
            transaction = session.beginTransaction();

            // 3. Salva o fornecedor no banco de dados
            session.save(fornecedor);

            // 4. Confirma a transação
            transaction.commit();
        } catch (Exception e) {
            // 5. Em caso de erro, faz rollback da transação
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar fornecedor: " + e.getMessage());
        } finally {
            // 6. Fecha a sessão
            if (session != null) {
                session.close();
            }
        }
    }    
    
 public Fornecedor buscarPorId(int id) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.get(Fornecedor.class, id);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
 
public void excluir(int id) {
    Session session = null;
    Transaction transaction = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Fornecedor fornecedor = session.get(Fornecedor.class, id);
        if (fornecedor != null) {
            session.delete(fornecedor);
        }
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        throw new RuntimeException("Erro ao excluir fornecedor: " + e.getMessage());
    } finally {
        if (session != null) {
            session.close();
        }
    }
}
    
}
