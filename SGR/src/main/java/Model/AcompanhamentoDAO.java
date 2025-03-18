package Model;

import Service.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AcompanhamentoDAO {

    // Método para salvar um acompanhamento no banco de dados
    public void salvar(acompanhamento acompanhamento) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(acompanhamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar acompanhamento: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Método para listar todos os acompanhamentos
    public List<acompanhamento> listarTodos() {
        List<acompanhamento> acompanhamento = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            acompanhamento = session.createQuery("FROM acompanhamento", acompanhamento.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acompanhamento;
    }

    // Método para excluir um acompanhamento pelo ID
    public void excluir(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            acompanhamento acompanhamento = session.get(acompanhamento.class, id);
            if (acompanhamento != null) {
                session.delete(acompanhamento);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir acompanhamento: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
