/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;



import Model.pedido;
import Model.usuario;
import Service.AcompanhamentoService;
import Service.BebidaService;
import Service.PedidoService;
import Service.ProteinaService;
import Service.SobremesaService;
import Util.Contexto;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author safon
 */
public class TelaPedido extends javax.swing.JFrame {

  // Variáveis de gorjeta e margem
    private final double gorjeta = 0.10; // 10%
    private final double margem = 0.20;  // 20%
    
    public TelaPedido() {
        
        initComponents();
        atualizarProteinas();
        atualizarAcompanhamento();
        atualizarBebida();
        atualizarSobremesa();
        adicionarListeners();
        atualizarValorTotal(); // Atualiza o valor total inicial
        preencherJTable(pedidosJTable);
        
        // Verifica se o usuário logado é do tipo "gerente"
        usuario usuarioLogado = Contexto.getUsuarioLogado();
        if (usuarioLogado != null && "gerente".equals(usuarioLogado.getTipo())) {
        adminBotao.setVisible(true);
        excluirBotao.setVisible(true);
        } else {
        adminBotao.setVisible(false);
        excluirBotao.setVisible(false);
        }
        
    }

public void preencherJTable(javax.swing.JTable pedidosJTable) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    try (Session session = sessionFactory.openSession()) {
        // Recuperar os dados da entidade 'pedido'
        List<pedido> lista = session.createQuery("FROM pedido", pedido.class).getResultList();

        // Log para depuração
        System.out.println("Número de pedidos encontrados: " + lista.size());

        // Obter o modelo da JTable
        DefaultTableModel modelo = (DefaultTableModel) pedidosJTable.getModel();

        // Limpar dados existentes na tabela (opcional)
        modelo.setRowCount(0);

        // Definir as colunas do modelo (se necessário)
        modelo.setColumnIdentifiers(new String[]{
            "ID", "Mesa", "Proteína", "Acompanhamento 1", "Acompanhamento 2", "Bebida", "Sobremesa", "Garçom", "Valor"
        });

        // Adicionar os dados ao modelo
        for (pedido pedido : lista) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa(),
                pedido.getProteina(),
                pedido.getAcompanhamento1() != null ? pedido.getAcompanhamento1() : "",
                pedido.getAcompanhamento2() != null ? pedido.getAcompanhamento2() : "",
                pedido.getBebida() != null ? pedido.getBebida() : "",
                pedido.getSobremesa() != null ? pedido.getSobremesa() : "",
                pedido.getGarcon(),
                pedido.getValorPedido()
            });
        }

        // Atualizar a interface gráfica
        pedidosJTable.revalidate();
        pedidosJTable.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao carregar pedidos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    } finally {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
private void atualizarProteinas() {
    ProteinaService service = new ProteinaService();
    List<String> nomesProteinas = service.listarNomesProteinas();

    // Atualizar os itens do JComboBox
    proteinaCombobox.removeAllItems();
    for (String nome : nomesProteinas) {
        proteinaCombobox.addItem(nome);
    }
}

private void atualizarAcompanhamento() {
    AcompanhamentoService service = new AcompanhamentoService();
    List<String> nomesAcomp = service.listarNomesAcompanhamentos();

    // Atualizar os itens do JComboBox
    acomp1Combobox.removeAllItems();
    acomp2Combobox.removeAllItems();
    for (String nome : nomesAcomp) {
        acomp1Combobox.addItem(nome);
        acomp2Combobox.addItem(nome);
    }
}

private void atualizarBebida() {
    BebidaService service = new BebidaService();
    List<String> nomesBebida = service.listarNomesBebidas();

    // Atualizar os itens do JComboBox
    bebidaCombobox.removeAllItems();
    
    for (String nome : nomesBebida) {
        bebidaCombobox.addItem(nome);
        }
}

private void atualizarSobremesa() {
    SobremesaService service = new SobremesaService();
    List<String> nomesSobr = service.listarNomesSobremesas();

    // Atualizar os itens do JComboBox
    sobremesaCombobox.removeAllItems();
    
    for (String nome : nomesSobr) {
        sobremesaCombobox.addItem(nome);
        }
}

private void adicionarListeners() {
    // Adiciona listeners para atualizar o valor total dinamicamente
    proteinaCombobox.addActionListener(e -> atualizarValorTotal());
    acomp1Combobox.addActionListener(e -> atualizarValorTotal());
    acomp2Combobox.addActionListener(e -> atualizarValorTotal());
    bebidaCombobox.addActionListener(e -> atualizarValorTotal());
    sobremesaCombobox.addActionListener(e -> atualizarValorTotal());
}

private void atualizarValorTotal() {
    try {
        // Recuperar os preços de custo
        ProteinaService proteinaService = new ProteinaService();
        AcompanhamentoService acompanhamentoService = new AcompanhamentoService();
        BebidaService bebidaService = new BebidaService();
        SobremesaService sobremesaService = new SobremesaService();

        double precoProteina = proteinaService.getPrecoCustoByNome((String) proteinaCombobox.getSelectedItem());
        double precoAcomp1 = acompanhamentoService.getPrecoCustoByNome((String) acomp1Combobox.getSelectedItem());
        double precoAcomp2 = acompanhamentoService.getPrecoCustoByNome((String) acomp2Combobox.getSelectedItem());
        double precoBebida = bebidaService.getPrecoCustoByNome((String) bebidaCombobox.getSelectedItem());
        double precoSobremesa = sobremesaService.getPrecoCustoByNome((String) sobremesaCombobox.getSelectedItem());

        // Calcular o valor total
        double valorTotal = precoProteina + precoAcomp1 + precoAcomp2 + precoBebida + precoSobremesa;
        valorTotal += valorTotal * gorjeta; // Adicionar gorjeta
        valorTotal += valorTotal * margem;  // Adicionar margem

        // Atualizar a interface
        jLabel10.setText(String.format("R$ %.2f", valorTotal));
    } catch (Exception e) {
        e.printStackTrace();
        jLabel10.setText("Erro ao calcular valor");
    }
}

private void limparCampos() {
    // Limpar os campos de texto
    jTextField1.setText(""); // Garçom
    jTextField2.setText(""); // Mesa

    // Limpar as comboboxes
    proteinaCombobox.setSelectedIndex(0); // Define o primeiro item como selecionado
    acomp1Combobox.setSelectedIndex(0);
    acomp2Combobox.setSelectedIndex(0);
    bebidaCombobox.setSelectedIndex(0);
    sobremesaCombobox.setSelectedIndex(0);
    formaPgtoCombobox.setSelectedIndex(0);

    // Limpar o valor do pedido
    jLabel10.setText("R$ 0,00");
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        acomp1Combobox = new javax.swing.JComboBox<>();
        acomp2Combobox = new javax.swing.JComboBox<>();
        proteinaCombobox = new javax.swing.JComboBox<>();
        formaPgtoCombobox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        bebidaCombobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        sobremesaCombobox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        adminBotao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidosJTable = new javax.swing.JTable();
        gravarPedido = new javax.swing.JButton();
        excluirBotao = new javax.swing.JButton();
        limparCamposBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Proteína:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Acomp 2:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Forma Pagamento:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Acomp 1:");

        acomp1Combobox.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        acomp1Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        acomp1Combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acomp1ComboboxActionPerformed(evt);
            }
        });

        acomp2Combobox.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        acomp2Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        acomp2Combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acomp2ComboboxActionPerformed(evt);
            }
        });

        proteinaCombobox.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        proteinaCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        proteinaCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proteinaComboboxActionPerformed(evt);
            }
        });

        formaPgtoCombobox.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        formaPgtoCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Pix", "Credito", "Debito" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Bebida:");

        bebidaCombobox.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bebidaCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bebidaCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebidaComboboxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SGR - Módulo de Pedidos");

        sobremesaCombobox.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sobremesaCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sobremesaCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobremesaComboboxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Sobremesa:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Mesa:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Garçon:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setText("0,00");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setText("Valor do Pedido R$:");

        adminBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adminBotao.setText("Módulo Administrativo");
        adminBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBotaoActionPerformed(evt);
            }
        });

        pedidosJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(pedidosJTable);

        gravarPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gravarPedido.setForeground(new java.awt.Color(51, 204, 0));
        gravarPedido.setText("Gravar Pedido");
        gravarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravarPedidoActionPerformed(evt);
            }
        });

        excluirBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        excluirBotao.setForeground(new java.awt.Color(204, 0, 0));
        excluirBotao.setText("Excluir Pedido Selecionado");
        excluirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirBotaoActionPerformed(evt);
            }
        });

        limparCamposBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        limparCamposBotao.setForeground(new java.awt.Color(204, 0, 0));
        limparCamposBotao.setText("Limpar Campos");
        limparCamposBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(adminBotao)
                        .addGap(72, 72, 72)
                        .addComponent(excluirBotao))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2))
                                        .addGap(37, 37, 37)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(acomp2Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(acomp1Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(proteinaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4))
                                        .addGap(5, 5, 5))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(formaPgtoCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bebidaCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sobremesaCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(limparCamposBotao)
                                .addGap(18, 18, 18)
                                .addComponent(gravarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(proteinaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(acomp1Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(acomp2Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(56, 56, 56))
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(bebidaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addComponent(sobremesaCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(formaPgtoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(32, 32, 32)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10))
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gravarPedido)
                        .addComponent(limparCamposBotao)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminBotao)
                    .addComponent(excluirBotao))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adminBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBotaoActionPerformed
    TelaAdministracao telaAdmin = new TelaAdministracao();
    telaAdmin.setVisible(true);
    


// TODO add your handling code here:
    }//GEN-LAST:event_adminBotaoActionPerformed

    private void gravarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarPedidoActionPerformed

   
    try {
        // Validação dos campos obrigatórios
        String garcon = jTextField1.getText().trim(); // Nome do garçom
        String mesaTexto = jTextField2.getText().trim(); // Número da mesa

        if (garcon.isEmpty() || mesaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Os campos 'Mesa' e 'Garçom' são obrigatórios.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Interrompe o método se algum campo estiver vazio
        }

        // Converte o número da mesa para inteiro
        int mesa;
        try {
            mesa = Integer.parseInt(mesaTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O campo 'Mesa' deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Interrompe o método se o número da mesa for inválido
        }

        // Recuperar os valores das comboboxes
        String proteina = (String) proteinaCombobox.getSelectedItem();
        String acomp1 = (String) acomp1Combobox.getSelectedItem();
        String acomp2 = (String) acomp2Combobox.getSelectedItem();
        String bebida = (String) bebidaCombobox.getSelectedItem();
        String sobremesa = (String) sobremesaCombobox.getSelectedItem();
        String formaPagamento = (String) formaPgtoCombobox.getSelectedItem();

        // Converter o valor do pedido para double
        String valorTexto = jLabel10.getText().replace("R$ ", "").replace(",", ".");
        double valorTotal = Double.parseDouble(valorTexto);

        // Criar um objeto pedido
        pedido pedido = new pedido();
        pedido.setMesa(mesa);
        pedido.setProteina(proteina);
        pedido.setAcompanhamento1(acomp1);
        pedido.setAcompanhamento2(acomp2);
        pedido.setBebida(bebida);
        pedido.setSobremesa(sobremesa);
        pedido.setGarcon(garcon);
        pedido.setDataEHora(LocalDateTime.now()); // Data e hora atual
        pedido.setValorPedido(valorTotal);
        pedido.setFormaPagamento(formaPagamento);

        // Salvar o pedido no banco de dados
        PedidoService pedidoService = new PedidoService();
        pedidoService.salvarPedido(pedido);

        // Atualizar a JTable
        preencherJTable(pedidosJTable);

        // Exibir mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Pedido registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Erro ao converter o valor do pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao registrar pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

// TODO add your handling code here:
    }//GEN-LAST:event_gravarPedidoActionPerformed

    private void excluirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBotaoActionPerformed
  // Verifica se uma linha foi selecionada na JTable
    int linhaSelecionada = pedidosJTable.getSelectedRow();

    if (linhaSelecionada == -1) {
        // Nenhuma linha selecionada
        JOptionPane.showMessageDialog(this, "Selecione um pedido para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtém o ID do pedido selecionado
    DefaultTableModel modelo = (DefaultTableModel) pedidosJTable.getModel();
    Integer idPedido = (Integer) modelo.getValueAt(linhaSelecionada, 0); // A coluna 0 contém o ID

    // Confirma a exclusão com o usuário
    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir este pedido?",
        "Confirmar Exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            // Exclui o pedido do banco de dados
            PedidoService pedidoService = new PedidoService();
            pedidoService.excluirPedido(idPedido);

            // Remove a linha da JTable
            modelo.removeRow(linhaSelecionada);

            // Atualiza a interface
            pedidosJTable.revalidate();
            pedidosJTable.repaint();

            JOptionPane.showMessageDialog(this, "Pedido excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_excluirBotaoActionPerformed

    private void proteinaComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proteinaComboboxActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_proteinaComboboxActionPerformed

    private void acomp1ComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acomp1ComboboxActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_acomp1ComboboxActionPerformed

    private void acomp2ComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acomp2ComboboxActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_acomp2ComboboxActionPerformed

    private void bebidaComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebidaComboboxActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_bebidaComboboxActionPerformed

    private void sobremesaComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobremesaComboboxActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_sobremesaComboboxActionPerformed

    private void limparCamposBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposBotaoActionPerformed
limparCampos();         // TODO add your handling code here:
    }//GEN-LAST:event_limparCamposBotaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> acomp1Combobox;
    private javax.swing.JComboBox<String> acomp2Combobox;
    private javax.swing.JButton adminBotao;
    private javax.swing.JComboBox<String> bebidaCombobox;
    private javax.swing.JButton excluirBotao;
    private javax.swing.JComboBox<String> formaPgtoCombobox;
    private javax.swing.JButton gravarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton limparCamposBotao;
    private java.awt.Panel panel1;
    private javax.swing.JTable pedidosJTable;
    private javax.swing.JComboBox<String> proteinaCombobox;
    private javax.swing.JComboBox<String> sobremesaCombobox;
    // End of variables declaration//GEN-END:variables
}
