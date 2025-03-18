/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Service.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProteinaDAO {

    // Método para salvar uma proteína no banco de dados
    public void salvar(proteina proteina) {
        Session session = null;
        Transaction transaction = null;

        try {
            // 1. Abre uma sessão com o banco de dados
            session = HibernateUtil.getSessionFactory().openSession();

            // 2. Inicia uma transação
            transaction = session.beginTransaction();

            // 3. Salva a proteína no banco de dados
            session.save(proteina);

            // 4. Confirma a transação
            transaction.commit();
        } catch (Exception e) {
            // 5. Em caso de erro, faz rollback da transação
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar proteína: " + e.getMessage());
        } finally {
            // 6. Fecha a sessão
            if (session != null) {
                session.close();
            }
        }
    }

    // Método para listar todas as proteínas
    public List<proteina> listarTodos() {
        List<proteina> proteinas = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            proteinas = session.createQuery("FROM proteina", proteina.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proteinas;
    }

    // Método para excluir uma proteína pelo ID
    public void excluir(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            proteina proteina = session.get(proteina.class, id);
            if (proteina != null) {
                session.delete(proteina);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir proteína: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}