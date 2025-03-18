package Service;

import Model.pedido;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Service.HibernateUtil;

public class PedidoService {

    public void salvarPedido(pedido pedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pedido); // Salva o pedido no banco de dados
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

public void excluirPedido(Integer idPedido) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();

        // Recupera o pedido pelo ID
        pedido pedido = session.get(pedido.class, idPedido);

        if (pedido != null) {
            // Exclui o pedido
            session.delete(pedido);
            System.out.println("Pedido excluído com sucesso!");
        }

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
}



}
