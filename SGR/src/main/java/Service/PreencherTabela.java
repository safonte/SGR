/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.pedido;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author safon
 */
public class PreencherTabela {

public void preencherJTable(javax.swing.JTable pedidosJTable) {
        // Configuração do Hibernate
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            // Recuperar os dados da entidade 'peido'
            List<pedido> lista = session.createQuery("FROM pedido", pedido.class).getResultList();

            // Obter o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) pedidosJTable.getModel();

            // Limpar dados existentes na tabela (opcional)
            modelo.setRowCount(0);

            // Adicionar os dados ao modelo
            for (pedido pedido : lista) {
                modelo.addRow(new Object[]{
                        pedido.getIdPedido(),
                        pedido.getMesa(),
                        pedido.getProteina(),
                        pedido.getAcompanhamento1(),
                        pedido.getAcompanhamento2(),
                        pedido.getBebida(),
                        pedido.getSobremesa(),
                        pedido.getGarcon(),
                        pedido.getValorPedido()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    

    
}
