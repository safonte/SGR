# Sistema de Gerência de Restaurante (SGR)

## 📖 Apresentação do Sistema

Carlos é dono de um restaurante que começou a ver crescer o número de clientes. Até então, ele utilizava planilhas para registrar pedidos, compras de material, funcionários, etc. Porém, com o crescimento da empresa, esse modelo tornou-se ineficiente.

Diante disso, Carlos contratou uma equipe de desenvolvimento liderada por Sergio para criar o **Sistema de Gerência de Restaurante (SGR)**. O objetivo do sistema é auxiliar e facilitar o gerenciamento das operações do restaurante.

---

## 🖥️ Descrição do Sistema

O SGR é um sistema desktop projetado para gerenciar:
- Produtos,
- Pedidos,
- Fornecedores.

---

## 👥 Descrição dos Usuários

Os principais usuários do sistema são:
1. **Gerente** (cargo ocupado pelo Sr. Carlos): possui acesso completo às funcionalidades do sistema.
2. **Responsável pelo caixa**: acesso restrito a determinadas operações.

---

## 📋 Necessidades Atendidas

As principais necessidades identificadas e atendidas pelo SGR são:
1. Automatização de cadastros, busca, edição e remoção de registros.
2. Gestão de usuários com diferentes níveis de acesso.
3. Compartilhamento rápido e eficiente de informações entre os usuários.

---

## 📜 Regras de Negócio

1. Cada pedido é composto por pelo menos um dos itens: refeição, bebida, sobremesa.
2. **Refeições** são compostas por 1 proteína e 2 acompanhamentos (fornecidos por terceiros). Já sobremesas e refrigerantes são itens revendidos.
3. Existem 4 fornecedores exclusivos:
   - **Acompanhamentos** (Dark Kitchens),
   - **Proteínas** (açougues/distribuidores de carne),
   - **Sobremesas**,
   - **Bebidas**.

---

## 🛠️ Requisitos Funcionais

### [RF01] Criar Registros
Permitir o cadastro de:
- Pedidos (com data, hora, número da mesa, nome do garçom e valor total).
- Fornecedores.
- Insumos de produção e materiais de revenda.

### [RF02] Edição de Registros
Gerentes poderão editar informações previamente cadastradas.

### [RF03] Busca de Pedidos
Permitir pesquisa utilizando campos como data do pedido. Esta funcionalidade está disponível para todos os usuários.

### [RF04] Remoção de Registros
Gerentes podem excluir registros do sistema.

### [RF05] Acesso ao Sistema
- Todos os usuários necessitam de login (nome de usuário e senha).
- Certas ações só são permitidas aos gerentes.

---

## 🚀 Tecnologias Utilizadas
- *Detalhar aqui as linguagens, frameworks e ferramentas usados no projeto, por exemplo:*
  - Linguagem: Java
  - Banco de dados: MySQL
  - Frameworks: Swing para interface gráfica

---

## 🤝 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma [issue](https://github.com/seuusuario/sgr/issues) ou enviar um [pull request](https://github.com/seuusuario/sgr/pulls).

---

## 📄 Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE.md) para mais detalhes.

---

## 📧 Contato
Desenvolvido por **Sergio e equipe**. Entre em contato:
- Email: sergio@exemplo.com
- LinkedIn: [Sergio no LinkedIn](https://linkedin.com/in/sergio)
