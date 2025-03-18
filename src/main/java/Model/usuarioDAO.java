package Model;

        
import Service.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class usuarioDAO {
    private static final SessionFactory sessionFactory;

  static {
        try {
            // Configura a SessionFactory a partir do hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falha ao criar SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }   
    
    

    
     public void salvar(usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        
    }
     }

     // Método para excluir um usuário pelo ID
    public void excluir(int idUsuario) {
        Session session = null;
        try {
            // 1. Abre uma sessão com o banco de dados
            session = HibernateUtil.getSessionFactory().openSession();

            // 2. Inicia uma transação
            session.beginTransaction();

            // 3. Busca o usuário pelo ID
            usuario usuario = session.get(usuario.class, idUsuario);

            // 4. Se o usuário existir, remove-o do banco de dados
            if (usuario != null) {
                session.delete(usuario);
            }

            // 5. Confirma a transação
            session.getTransaction().commit();
        } catch (Exception e) {
            // 6. Em caso de erro, faz rollback da transação
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir usuário: " + e.getMessage());
        } finally {
            // 7. Fecha a sessão
            if (session != null) {
                session.close();
            }
        }
    }
   
public usuario buscarPorNomeESenha(String nome, String senha) { // Retorno "usuario" (minúsculo)
        usuario usuarioEncontrado = null; // Nome da variável diferente do nome da classe
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM usuario WHERE nome = :nome AND senha = :senha"; // HQL com "usuario"
            Query<usuario> query = session.createQuery(hql, usuario.class); // Query com "usuario.class"
            query.setParameter("nome", nome);
            query.setParameter("senha", senha);
            usuarioEncontrado = query.uniqueResult(); // Atribuição correta
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioEncontrado; // Retorno da variável correta
    }
       
public List<usuario> listarTodos() {
        List<usuario> usuarios = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            usuarios = session.createQuery("FROM usuario", usuario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }    


    
}

