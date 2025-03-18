/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.AcompanhamentoDAO;
import Model.BebidaDAO;
import Model.Fornecedor;
import Model.FornecedorDAO;
import Model.ProteinaDAO;
import Model.SobremesaDAO;
import Model.acompanhamento;
import Model.bebida;
import Model.proteina;
import Model.sobremesa;
import Model.usuario;
import Model.usuarioDAO;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author safon
 */
public class TelaAdministracao extends javax.swing.JFrame {

    /**
     * Creates new form TelaAdminintraçao
     */
    public TelaAdministracao() {
        initComponents();
        preencherUsuarioTabela();
        preencherFornecedorTabela();
        preencherProteinaTabela();
        preencherAcompanhamentoTabela();
        preencherBebidaTabela();
        preencherSobremesaTabela();
    }

public void preencherUsuarioTabela() {
    try {
        // 1. Recupera os dados da tabela 'usuario' do banco de dados
        usuarioDAO usuarioDAO = new usuarioDAO();
        List<usuario> listaUsuarios = usuarioDAO.listarTodos();

        // 2. Obtém o modelo da JTable
        DefaultTableModel modelo = (DefaultTableModel) usuarioTabela.getModel();

        // 3. Limpa os dados existentes na tabela
        modelo.setRowCount(0);

        // 4. Adiciona os dados ao modelo da tabela
        for (usuario usuario : listaUsuarios) {
            modelo.addRow(new Object[]{
                usuario.getId(),       // 
                usuario.getNome(),    // 
                usuario.getSenha(),   // 
                usuario.getTipo(),    // 
                usuario.getDataHora() // 
            });
        }

        // 5. Atualiza a interface gráfica
        usuarioTabela.revalidate();
        usuarioTabela.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar usuários: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
    
public void preencherFornecedorTabela() {
    try {
        // 1. Recupera os dados da tabela 'fornecedor' do banco de dados
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> listaFornecedores = fornecedorDAO.listarTodos();

        // 2. Obtém o modelo da JTable
        DefaultTableModel modelo = (DefaultTableModel) tabelaFornecedor.getModel();

        // 3. Limpa os dados existentes na tabela
        modelo.setRowCount(0);

        // 4. Adiciona os dados ao modelo da tabela
        for (Fornecedor fornecedor : listaFornecedores) {
            modelo.addRow(new Object[]{
                fornecedor.getId(),          // ID do fornecedor
                fornecedor.getCnpj(),       // CNPJ
                fornecedor.getRazaoSocial(),// Razão Social
                fornecedor.getLogradouro(), // Logradouro
                fornecedor.getCidade(),     // Cidade
                fornecedor.getEstado(),         // UF
                fornecedor.getContato(),    // Contato
                fornecedor.getTelefone()    // Telefone
            });
        }

        // 5. Atualiza a interface gráfica
        tabelaFornecedor.revalidate();
        tabelaFornecedor.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar fornecedores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}    

public void preencherProteinaTabela() {
    try {
        // 1. Recupera os dados da tabela 'proteina' do banco de dados
        ProteinaDAO proteinaDAO = new ProteinaDAO();
        List<proteina> listaProteinas = proteinaDAO.listarTodos();

        // 2. Obtém o modelo da JTable
        DefaultTableModel modelo = (DefaultTableModel) tabelaProteina.getModel();

        // 3. Limpa os dados existentes na tabela
        modelo.setRowCount(0);

        // 4. Adiciona os dados ao modelo da tabela
        for (proteina proteina : listaProteinas) {
            modelo.addRow(new Object[]{
                proteina.getIdproteina(), // ID da proteína
                proteina.getNome(),      // Nome da proteína
                proteina.getPrecoCusto() // Preço de custo
            });
        }

        // 5. Atualiza a interface gráfica
        tabelaProteina.revalidate();
        tabelaProteina.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar proteínas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

public void preencherAcompanhamentoTabela() {
    try {
        // 1. Recupera os dados da tabela 'acompanhamento' do banco de dados
        AcompanhamentoDAO acompanhamentoDAO = new AcompanhamentoDAO();
        List<acompanhamento> listaAcompanhamentos = acompanhamentoDAO.listarTodos();

        // 2. Obtém o modelo da JTable
        DefaultTableModel modelo = (DefaultTableModel) tabelaAcompanhamento.getModel();

        // 3. Limpa os dados existentes na tabela
        modelo.setRowCount(0);

        // 4. Adiciona os dados ao modelo da tabela
        for (acompanhamento acomp : listaAcompanhamentos) {
            modelo.addRow(new Object[]{
                acomp.getIdacompanhamento(), // ID do acompanhamento
                acomp.getNome(),            // Nome do acompanhamento
                acomp.getPrecoCusto()       // Preço de custo
            });
        }

        // 5. Atualiza a interface gráfica
        tabelaAcompanhamento.revalidate();
        tabelaAcompanhamento.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar acompanhamentos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

public void preencherBebidaTabela(){
try {
        // 1. Recupera os dados da tabela 'acompanhamento' do banco de dados
        BebidaDAO bebDAO = new BebidaDAO();
        List<bebida> listaBebida = bebDAO.listarTodos();

        // 2. Obtém o modelo da JTable
        DefaultTableModel modelo = (DefaultTableModel) tabelaBebida.getModel();

        // 3. Limpa os dados existentes na tabela
        modelo.setRowCount(0);

        // 4. Adiciona os dados ao modelo da tabela
        for (bebida beb : listaBebida) {
            modelo.addRow(new Object[]{
                beb.getIdbebida(), 
                beb.getNome(),    
                beb.getPrecoCusto()
            });
        }

        // 5. Atualiza a interface gráfica
        tabelaBebida.revalidate();
        tabelaBebida.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar acompanhamentos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }


}

public void preencherSobremesaTabela(){
try {
        // 1. Recupera os dados da tabela 'acompanhamento' do banco de dados
        SobremesaDAO sobremDAO = new SobremesaDAO();
        List<sobremesa> listaSobremesa = sobremDAO.listarTodos();

        // 2. Obtém o modelo da JTable
        DefaultTableModel modelo = (DefaultTableModel) tabelaSobrem.getModel();

        // 3. Limpa os dados existentes na tabela
        modelo.setRowCount(0);

        // 4. Adiciona os dados ao modelo da tabela
        for (sobremesa sobrem : listaSobremesa) {
            modelo.addRow(new Object[]{
                sobrem.getIdsobremesa(), 
                sobrem.getNome(),            
                sobrem.getPrecoCusto()       
            });
        }

        // 5. Atualiza a interface gráfica
        tabelaSobrem.revalidate();
        tabelaSobrem.repaint();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar acompanhamentos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }


}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel2 = new java.awt.Panel();
        txtLogin2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tipoUsuarioCombobox = new javax.swing.JComboBox<>();
        eliminarBotao = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuarioTabela = new javax.swing.JTable();
        cadastrarBotao = new javax.swing.JToggleButton();
        panel3 = new java.awt.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFornecedor = new javax.swing.JTable();
        eliminarFornecBotao = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        txtLogin4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtLogin5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtLogin6 = new javax.swing.JTextField();
        txtLogin7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtLogin8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtLogin9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtLogin10 = new javax.swing.JTextField();
        cadastrarFornecBotao = new javax.swing.JButton();
        panel4 = new java.awt.Panel();
        jLabel33 = new javax.swing.JLabel();
        txtDescrProteina = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtPrecoProtein = new javax.swing.JTextField();
        cadastrarProtBotao = new javax.swing.JToggleButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaProteina = new javax.swing.JTable();
        eliminarProteinaBotao = new javax.swing.JToggleButton();
        panel5 = new java.awt.Panel();
        jLabel36 = new javax.swing.JLabel();
        txtDescrAcomp = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtPrecoAcomp = new javax.swing.JTextField();
        cadastrarAcomp = new javax.swing.JToggleButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaAcompanhamento = new javax.swing.JTable();
        eliminAcompBotao = new javax.swing.JToggleButton();
        panel6 = new java.awt.Panel();
        jLabel39 = new javax.swing.JLabel();
        txtDescrBebida = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtPrecoBebida = new javax.swing.JTextField();
        cadastrarBebidaBotao = new javax.swing.JToggleButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabelaBebida = new javax.swing.JTable();
        eliminarBebidaBotao = new javax.swing.JToggleButton();
        panel8 = new java.awt.Panel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaSobrem = new javax.swing.JTable();
        eliminarSrobremBtao = new javax.swing.JToggleButton();
        jLabel30 = new javax.swing.JLabel();
        txtDescrSobrem = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtPrecoSobrem = new javax.swing.JTextField();
        cadastrarSobremBotao = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SGR - Módulo de Administração");

        jTabbedPane1.setBorder(new javax.swing.border.MatteBorder(null));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtLogin2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Login:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Senha");

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Tipo de Usuário");

        tipoUsuarioCombobox.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tipoUsuarioCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "caixa", "gerente" }));

        eliminarBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        eliminarBotao.setText("Eliminar seleção");
        eliminarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBotaoActionPerformed(evt);
            }
        });

        usuarioTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Senha", "Cargo", "data e hora de criação"
            }
        ));
        jScrollPane1.setViewportView(usuarioTabela);

        cadastrarBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cadastrarBotao.setText("Cadastrar");
        cadastrarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(tipoUsuarioCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(cadastrarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tipoUsuarioCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(eliminarBotao)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Editar Usuários", panel2);

        tabelaFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Cnpj", "Razão Social", "Logradouro", "Cidade", "UF", "Contato", "Telefone"
            }
        ));
        jScrollPane2.setViewportView(tabelaFornecedor);

        eliminarFornecBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        eliminarFornecBotao.setText("Eliminar seleção");
        eliminarFornecBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarFornecBotaoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Cnpj:");

        txtLogin4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Razão Social:");

        txtLogin5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin5ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Logradouro:");

        txtLogin6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin6ActionPerformed(evt);
            }
        });

        txtLogin7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin7ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setText("Cidade:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setText("UF:");

        txtLogin8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin8ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setText("Contato:");

        txtLogin9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin9ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setText("Telefone:");

        txtLogin10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLogin10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogin10ActionPerformed(evt);
            }
        });

        cadastrarFornecBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cadastrarFornecBotao.setText("Cadastrar");
        cadastrarFornecBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFornecBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(932, 932, 932)
                        .addComponent(eliminarFornecBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLogin4)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtLogin5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLogin9, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLogin10))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLogin6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLogin7, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLogin8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cadastrarFornecBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(20, 20, 20))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtLogin4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtLogin5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtLogin7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtLogin9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtLogin10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadastrarFornecBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(72, 72, 72)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(eliminarFornecBotao)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Editar Fornecedores", panel3);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel33.setText("Descrição:");

        txtDescrProteina.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDescrProteina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescrProteinaActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel35.setText("Preço de Custo:");

        txtPrecoProtein.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtPrecoProtein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoProteinActionPerformed(evt);
            }
        });

        cadastrarProtBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cadastrarProtBotao.setText("Cadastrar");
        cadastrarProtBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProtBotaoActionPerformed(evt);
            }
        });

        tabelaProteina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Descrição", "Preçco de Custo"
            }
        ));
        jScrollPane7.setViewportView(tabelaProteina);

        eliminarProteinaBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        eliminarProteinaBotao.setText("Eliminar seleção");
        eliminarProteinaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProteinaBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eliminarProteinaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(txtDescrProteina, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecoProtein, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cadastrarProtBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtDescrProteina, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(cadastrarProtBotao)
                    .addComponent(txtPrecoProtein, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(eliminarProteinaBotao)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Editar Proteínas", panel4);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel36.setText("Descrição:");

        txtDescrAcomp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDescrAcomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescrAcompActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel38.setText("Preço de Custo:");

        txtPrecoAcomp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtPrecoAcomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoAcompActionPerformed(evt);
            }
        });

        cadastrarAcomp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cadastrarAcomp.setText("Cadastrar");
        cadastrarAcomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAcompActionPerformed(evt);
            }
        });

        tabelaAcompanhamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Descrição", "Preçco de Custo"
            }
        ));
        jScrollPane8.setViewportView(tabelaAcompanhamento);

        eliminAcompBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        eliminAcompBotao.setText("Eliminar seleção");
        eliminAcompBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminAcompBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8)
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eliminAcompBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addComponent(txtDescrAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecoAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cadastrarAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtDescrAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(cadastrarAcomp)
                    .addComponent(txtPrecoAcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(eliminAcompBotao)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Editar Acompanhamento", panel5);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel39.setText("Descrição:");

        txtDescrBebida.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDescrBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescrBebidaActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel41.setText("Preço de Custo:");

        txtPrecoBebida.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtPrecoBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoBebidaActionPerformed(evt);
            }
        });

        cadastrarBebidaBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cadastrarBebidaBotao.setText("Cadastrar");
        cadastrarBebidaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBebidaBotaoActionPerformed(evt);
            }
        });

        tabelaBebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Descrição", "Preçco de Custo"
            }
        ));
        jScrollPane9.setViewportView(tabelaBebida);

        eliminarBebidaBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        eliminarBebidaBotao.setText("Eliminar seleção");
        eliminarBebidaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBebidaBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9)
                    .addGroup(panel6Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel6Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eliminarBebidaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addComponent(txtDescrBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecoBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(cadastrarBebidaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtDescrBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(cadastrarBebidaBotao)
                    .addComponent(txtPrecoBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(eliminarBebidaBotao)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Editar Bebida", panel6);

        tabelaSobrem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Descrição", "Preçco de Custo"
            }
        ));
        jScrollPane6.setViewportView(tabelaSobrem);

        eliminarSrobremBtao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        eliminarSrobremBtao.setText("Eliminar seleção");
        eliminarSrobremBtao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarSrobremBtaoActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel30.setText("Descrição:");

        txtDescrSobrem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDescrSobrem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescrSobremActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel32.setText("Preço de Custo:");

        txtPrecoSobrem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtPrecoSobrem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoSobremActionPerformed(evt);
            }
        });

        cadastrarSobremBotao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cadastrarSobremBotao.setText("Cadastrar");
        cadastrarSobremBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarSobremBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(panel8Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel8Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eliminarSrobremBtao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel8Layout.createSequentialGroup()
                                .addComponent(txtDescrSobrem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecoSobrem, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cadastrarSobremBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtDescrSobrem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(cadastrarSobremBotao)
                    .addComponent(txtPrecoSobrem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(eliminarSrobremBtao)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Editar Sobremesa", panel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(564, 564, 564)
                                .addComponent(jLabel8)
                                .addGap(49, 628, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 29, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarFornecBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFornecBotaoActionPerformed
                                                  
    // 1. Verifica se uma linha foi selecionada na JTable
    int linhaSelecionada = tabelaFornecedor.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um fornecedor para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Obtém o ID do fornecedor selecionado
    int idFornecedor = (int) tabelaFornecedor.getValueAt(linhaSelecionada, 0);

    // 3. Confirma a exclusão com o usuário
    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir este fornecedor?",
        "Confirmar Exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            // 4. Exclui o fornecedor do banco de dados
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            fornecedorDAO.excluir(idFornecedor);

            // 5. Atualiza a tabela de fornecedores
            preencherFornecedorTabela();

            JOptionPane.showMessageDialog(this, "Fornecedor excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir fornecedor: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarFornecBotaoActionPerformed

    private void cadastrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBotaoActionPerformed
                                             
 try {
        // 1. Obter os valores dos campos de texto e do combobox
        String nome = txtLogin2.getText();
        String senha = txtSenha.getText();
        String tipo = (String) tipoUsuarioCombobox.getSelectedItem();

        // 2. Verificar se os campos estão preenchidos
        if (nome.isEmpty() || senha.isEmpty() || tipo == null) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Gerar a data e hora atual do sistema
        Date dataHora = new Date();

        // 4. Criar um objeto Usuario
        usuario usuario = new usuario(nome, senha, tipo, dataHora);

        // 5. Salvar o usuário no banco de dados usando o DAO
        usuarioDAO usuarioDAO = new usuarioDAO();
        usuarioDAO.salvar(usuario);

        // 6. Atualizar a tabela com os dados mais recentes
        preencherUsuarioTabela();

        // 7. Limpar os campos após o cadastro
        txtLogin2.setText("");
        txtSenha.setText("");
        tipoUsuarioCombobox.setSelectedIndex(0); // Volta para a primeira opção do combobox

        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

    }//GEN-LAST:event_cadastrarBotaoActionPerformed

    private void eliminarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBotaoActionPerformed
       // 1. Verifica se uma linha foi selecionada na JTable
    int linhaSelecionada = usuarioTabela.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Obtém o ID do usuário selecionado
    int idUsuario = (int) usuarioTabela.getValueAt(linhaSelecionada, 0);

    // 3. Confirma a exclusão com o usuário
    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir este usuário?",
        "Confirmar Exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            // 4. Exclui o usuário do banco de dados
            usuarioDAO usuarioDAO = new usuarioDAO();
            usuarioDAO.excluir(idUsuario);

            // 5. Atualiza a tabela
            preencherUsuarioTabela();

            JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }  // TODO add your handling code here:
    }//GEN-LAST:event_eliminarBotaoActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtLogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin2ActionPerformed

    private void eliminarSrobremBtaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarSrobremBtaoActionPerformed
    // 1. Verifica se uma linha foi selecionada na JTable
    int linhaSelecionada = tabelaSobrem.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma sobremesa para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Obtém o ID da sobremesa selecionada
    Integer idSobremesa = (Integer) tabelaProteina.getValueAt(linhaSelecionada, 0);

    // 3. Verifica se o ID é 1 (não permitir exclusão, pois é uma linha de controle no aplicativo)
    if (idSobremesa == 1) {
        JOptionPane.showMessageDialog(this, "Esta inha não pode ser excluída.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return; // Interrompe o método
    }

    // 4. Confirma a exclusão com o usuário
    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir esta sobremesa?",
        "Confirmar Exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            // 5. Exclui a sobremesa do banco de dados
            SobremesaDAO sobremDAO = new SobremesaDAO();
            sobremDAO.excluir(idSobremesa);

            // 6. Atualiza a tabela de sobremesa
            preencherSobremesaTabela();

            JOptionPane.showMessageDialog(this, "Sobremesa excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir sobremesa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }    // TODO add your handling code here:
    }//GEN-LAST:event_eliminarSrobremBtaoActionPerformed

    private void txtLogin4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin4ActionPerformed

    private void txtLogin5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin5ActionPerformed

    private void txtLogin6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin6ActionPerformed

    private void txtLogin7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin7ActionPerformed

    private void txtLogin8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin8ActionPerformed

    private void txtLogin9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin9ActionPerformed

    private void txtLogin10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogin10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogin10ActionPerformed

    private void cadastrarFornecBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFornecBotaoActionPerformed
                                            
    try {
        // 1. Obter os valores dos campos de texto
        String cnpj = txtLogin4.getText();
        String razaoSocial = txtLogin5.getText();
        String logradouro = txtLogin6.getText();
        String cidade = txtLogin7.getText();
        String estado = txtLogin8.getText();
        String contato = txtLogin9.getText();
        String telefone = txtLogin10.getText();

        // 2. Verificar se os campos obrigatórios estão preenchidos
        if (cnpj.isEmpty() || razaoSocial.isEmpty() || logradouro.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Criar um objeto Fornecedor
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj(cnpj);
        fornecedor.setRazaoSocial(razaoSocial);
        fornecedor.setLogradouro(logradouro);
        fornecedor.setCidade(cidade);
        fornecedor.setEstado(estado);
        fornecedor.setContato(contato);
        fornecedor.setTelefone(telefone);

        // 4. Salvar o fornecedor no banco de dados
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.salvar(fornecedor);

        // 5. Atualizar a tabela de fornecedores
        preencherFornecedorTabela();

        // 6. Limpar os campos após o cadastro
        txtLogin4.setText("");
        txtLogin5.setText("");
        txtLogin6.setText("");
        txtLogin7.setText("");
        txtLogin8.setText("");
        txtLogin9.setText("");
        txtLogin10.setText("");

        JOptionPane.showMessageDialog(this, "Fornecedor cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar fornecedor: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    


        // TODO add your handling code here:
    }//GEN-LAST:event_cadastrarFornecBotaoActionPerformed

    private void txtDescrSobremActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescrSobremActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescrSobremActionPerformed

    private void txtPrecoSobremActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoSobremActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoSobremActionPerformed

    private void cadastrarSobremBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarSobremBotaoActionPerformed
       try {
        // 1. Obter os valores dos campos de texto
        String nome = txtDescrSobrem.getText();
        String precoCustoTexto = txtPrecoSobrem.getText();

        // 2. Verificar se os campos obrigatórios estão preenchidos
        if (nome.isEmpty() || precoCustoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Converter o preço de custo para Double
        Double precoCusto = Double.parseDouble(precoCustoTexto);

        // 4. Criar um objeto sobremsa
        sobremesa sobr = new sobremesa();
        sobr.setNome(nome);
        sobr.setPrecoCusto(precoCusto);

        // 5. Salvar a sobremesa no banco de dados
        SobremesaDAO sobrDAO = new SobremesaDAO();
        sobrDAO.salvar(sobr);

        // 6. Atualizar a tabela de sobremesas
        preencherSobremesaTabela();

        // 7. Limpar os campos após o cadastro
        txtDescrSobrem.setText("");
        txtPrecoSobrem.setText("");

        JOptionPane.showMessageDialog(this, "Sobremesa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "O preço de custo deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar sobremesa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    // TODO add your handling code here:
    }//GEN-LAST:event_cadastrarSobremBotaoActionPerformed

    private void txtDescrProteinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescrProteinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescrProteinaActionPerformed

    private void txtPrecoProteinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoProteinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoProteinActionPerformed

    private void cadastrarProtBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarProtBotaoActionPerformed
                                                      
    try {
        // 1. Obter os valores dos campos de texto
        String nome = txtDescrProteina.getText();
        String precoCustoTexto = txtPrecoProtein.getText();

        // 2. Verificar se os campos obrigatórios estão preenchidos
        if (nome.isEmpty() || precoCustoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Converter o preço de custo para Double
        Double precoCusto = Double.parseDouble(precoCustoTexto);

        // 4. Criar um objeto proteina
        proteina proteina = new proteina();
        proteina.setNome(nome);
        proteina.setPrecoCusto(precoCusto);

        // 5. Salvar a proteína no banco de dados
        ProteinaDAO proteinaDAO = new ProteinaDAO();
        proteinaDAO.salvar(proteina);

        // 6. Atualizar a tabela de proteínas
        preencherProteinaTabela();

        // 7. Limpar os campos após o cadastro
        txtDescrProteina.setText("");
        txtPrecoProtein.setText("");

        JOptionPane.showMessageDialog(this, "Proteína cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "O preço de custo deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar proteína: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
// TODO add your handling code here:
    }//GEN-LAST:event_cadastrarProtBotaoActionPerformed

    private void eliminarProteinaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProteinaBotaoActionPerformed
                                                
                                            
    // 1. Verifica se uma linha foi selecionada na JTable
    int linhaSelecionada = tabelaProteina.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma proteína para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Obtém o ID da proteína selecionada
    Integer idProteina = (Integer) tabelaProteina.getValueAt(linhaSelecionada, 0);

    // 3. Verifica se o ID é 1 (não permitir exclusão, pois é uma linha de controle no aplicativo)
    if (idProteina == 1) {
        JOptionPane.showMessageDialog(this, "Esta inha não pode ser excluída.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return; // Interrompe o método
    }

    // 4. Confirma a exclusão com o usuário
    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir esta proteína?",
        "Confirmar Exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            // 5. Exclui a proteína do banco de dados
            ProteinaDAO proteinaDAO = new ProteinaDAO();
            proteinaDAO.excluir(idProteina);

            // 6. Atualiza a tabela de proteínas
            preencherProteinaTabela();

            JOptionPane.showMessageDialog(this, "Proteína excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir proteína: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

 // TODO add your handling code here:
    }//GEN-LAST:event_eliminarProteinaBotaoActionPerformed

    private void txtDescrAcompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescrAcompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescrAcompActionPerformed

    private void txtPrecoAcompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoAcompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoAcompActionPerformed

    private void cadastrarAcompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAcompActionPerformed
        try {
        // 1. Obter os valores dos campos de texto
        String nome = txtDescrAcomp.getText();
        String precoCustoTexto = txtPrecoAcomp.getText();

        // 2. Verificar se os campos obrigatórios estão preenchidos
        if (nome.isEmpty() || precoCustoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Converter o preço de custo para Double
        Double precoCusto = Double.parseDouble(precoCustoTexto);

        // 4. Criar um objeto proteina
        acompanhamento acomp = new acompanhamento();
        acomp.setNome(nome);
        acomp.setPrecoCusto(precoCusto);

        // 5. Salvar a proteína no banco de dados
        AcompanhamentoDAO acompDAO = new AcompanhamentoDAO();
        acompDAO.salvar(acomp);

        // 6. Atualizar a tabela de proteínas
        preencherAcompanhamentoTabela();

        // 7. Limpar os campos após o cadastro
        txtDescrAcomp.setText("");
        txtPrecoAcomp.setText("");

        JOptionPane.showMessageDialog(this, "Proteína cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "O preço de custo deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar proteína: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_cadastrarAcompActionPerformed

    private void eliminAcompBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminAcompBotaoActionPerformed
                                             
    // 1. Verifica se uma linha foi selecionada na JTable
    int linhaSelecionada = tabelaAcompanhamento.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um acompanhamento para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Obtém o ID do acompanhamento selecionado
    Integer idAcompanhamento = (Integer) tabelaAcompanhamento.getValueAt(linhaSelecionada, 0);

    // 3. Verifica se o ID é 1 (não permitir exclusão)
    if (idAcompanhamento == 1) {
        JOptionPane.showMessageDialog(this, "Esta linha não pode ser excluída.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return; // Interrompe o método
    }

    // 4. Confirma a exclusão com o usuário
    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir este acompanhamento?",
        "Confirmar Exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            // 5. Exclui o acompanhamento do banco de dados
            AcompanhamentoDAO acompanhamentoDAO = new AcompanhamentoDAO();
            acompanhamentoDAO.excluir(idAcompanhamento);

            // 6. Atualiza a tabela de acompanhamentos
            preencherAcompanhamentoTabela();

            JOptionPane.showMessageDialog(this, "Acompanhamento excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir acompanhamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


        // TODO add your handling code here:
    }//GEN-LAST:event_eliminAcompBotaoActionPerformed

    private void txtDescrBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescrBebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescrBebidaActionPerformed

    private void txtPrecoBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoBebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoBebidaActionPerformed

    private void cadastrarBebidaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBebidaBotaoActionPerformed
           try {
        // 1. Obter os valores dos campos de texto
        String nome = txtDescrBebida.getText();
        String precoCustoTexto = txtPrecoBebida.getText();

        // 2. Verificar se os campos obrigatórios estão preenchidos
        if (nome.isEmpty() || precoCustoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Converter o preço de custo para Double
        Double precoCusto = Double.parseDouble(precoCustoTexto);

        // 4. Criar um objeto proteina
        bebida beb = new bebida();
        beb.setNome(nome);
        beb.setPrecoCusto(precoCusto);

        // 5. Salvar a proteína no banco de dados
        BebidaDAO bebDAO = new BebidaDAO();
        bebDAO.salvar(beb);

        // 6. Atualizar a tabela de proteínas
        preencherBebidaTabela();

        // 7. Limpar os campos após o cadastro
        txtDescrBebida.setText("");
        txtPrecoBebida.setText("");

        JOptionPane.showMessageDialog(this, "Proteína cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "O preço de custo deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar proteína: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

      
    }//GEN-LAST:event_cadastrarBebidaBotaoActionPerformed

    private void eliminarBebidaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBebidaBotaoActionPerformed
          // 1. Verifica se uma linha foi selecionada na JTable
    int linhaSelecionada = tabelaBebida.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma Bebida para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Obtém o ID do acompanhamento selecionado
    Integer idBebida = (Integer) tabelaBebida.getValueAt(linhaSelecionada, 0);

    // 3. Verifica se o ID é 1 (não permitir exclusão)
    if (idBebida == 1) {
        JOptionPane.showMessageDialog(this, "Esta linha não pode ser excluída.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return; // Interrompe o método
    }

    // 4. Confirma a exclusão com o usuário
    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir esta bebida?",
        "Confirmar Exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            // 5. Exclui o acompanhamento do banco de dados
            BebidaDAO bebDAO = new BebidaDAO();
            bebDAO.excluir(idBebida);

            // 6. Atualiza a tabela de acompanhamentos
            preencherBebidaTabela();

            JOptionPane.showMessageDialog(this, "Bebida excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir bebida: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }  // TODO add your handling code here:
    }//GEN-LAST:event_eliminarBebidaBotaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAdministracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdministracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdministracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdministracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdministracao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cadastrarAcomp;
    private javax.swing.JToggleButton cadastrarBebidaBotao;
    private javax.swing.JToggleButton cadastrarBotao;
    private javax.swing.JButton cadastrarFornecBotao;
    private javax.swing.JToggleButton cadastrarProtBotao;
    private javax.swing.JToggleButton cadastrarSobremBotao;
    private javax.swing.JToggleButton eliminAcompBotao;
    private javax.swing.JToggleButton eliminarBebidaBotao;
    private javax.swing.JToggleButton eliminarBotao;
    private javax.swing.JToggleButton eliminarFornecBotao;
    private javax.swing.JToggleButton eliminarProteinaBotao;
    private javax.swing.JToggleButton eliminarSrobremBtao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private java.awt.Panel panel5;
    private java.awt.Panel panel6;
    private java.awt.Panel panel8;
    private javax.swing.JTable tabelaAcompanhamento;
    private javax.swing.JTable tabelaBebida;
    private javax.swing.JTable tabelaFornecedor;
    private javax.swing.JTable tabelaProteina;
    private javax.swing.JTable tabelaSobrem;
    private javax.swing.JComboBox<String> tipoUsuarioCombobox;
    private javax.swing.JTextField txtDescrAcomp;
    private javax.swing.JTextField txtDescrBebida;
    private javax.swing.JTextField txtDescrProteina;
    private javax.swing.JTextField txtDescrSobrem;
    private javax.swing.JTextField txtLogin10;
    private javax.swing.JTextField txtLogin2;
    private javax.swing.JTextField txtLogin4;
    private javax.swing.JTextField txtLogin5;
    private javax.swing.JTextField txtLogin6;
    private javax.swing.JTextField txtLogin7;
    private javax.swing.JTextField txtLogin8;
    private javax.swing.JTextField txtLogin9;
    private javax.swing.JTextField txtPrecoAcomp;
    private javax.swing.JTextField txtPrecoBebida;
    private javax.swing.JTextField txtPrecoProtein;
    private javax.swing.JTextField txtPrecoSobrem;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTable usuarioTabela;
    // End of variables declaration//GEN-END:variables
}
