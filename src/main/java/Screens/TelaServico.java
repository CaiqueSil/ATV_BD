package Screens;

import Routes.ServicoDAO;
import Routes.FormaDePagamentoDAO;
import Tables.Servico;
import Tables.FormaDePagamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

public class TelaServico extends JFrame {

    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtPreco;
    private JTextField txtIDAnimal;
    private JTextField txtIDTipoServico;
    private JComboBox<FormaDePagamento> comboFormaPagamento;
    private JButton btnSalvar;

    public TelaServico() {
        setTitle("Cadastro de Serviço");
        setSize(525, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 20, 120, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(180, 20, 250, 25);
        add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(30, 60, 120, 25);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(180, 60, 250, 25);
        add(txtDescricao);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(30, 100, 120, 25);
        add(lblPreco);

        txtPreco = new JTextField();
        txtPreco.setBounds(180, 100, 250, 25);
        add(txtPreco);

        JLabel lblIDAnimal = new JLabel("ID Animal:");
        lblIDAnimal.setBounds(30, 140, 120, 25);
        add(lblIDAnimal);

        txtIDAnimal = new JTextField();
        txtIDAnimal.setBounds(180, 140, 250, 25);
        add(txtIDAnimal);

        JLabel lblIDTipo = new JLabel("ID Tipo de Serviço:");
        lblIDTipo.setBounds(30, 180, 140, 25);
        add(lblIDTipo);

        txtIDTipoServico = new JTextField();
        txtIDTipoServico.setBounds(180, 180, 250, 25);
        add(txtIDTipoServico);

        JLabel lblForma = new JLabel("Forma de Pagamento:");
        lblForma.setBounds(30, 220, 160, 25);
        add(lblForma);

        comboFormaPagamento = new JComboBox<>();
        comboFormaPagamento.setBounds(180, 220, 250, 25);
        add(comboFormaPagamento);

        carregarFormasDePagamento();

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(200, 300, 120, 35);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    String descricao = txtDescricao.getText();
                    BigDecimal preco = new BigDecimal(txtPreco.getText());
                    Integer idAnimal = Integer.parseInt(txtIDAnimal.getText());
                    Integer idTipo = Integer.parseInt(txtIDTipoServico.getText());
                    FormaDePagamento formaSelecionada = (FormaDePagamento) comboFormaPagamento.getSelectedItem();
                    Integer idForma = formaSelecionada != null ? formaSelecionada.getID_Pagamento() : null;

                    Servico servico = new Servico(null, nome, descricao, preco, idAnimal, idTipo, idForma);
                    ServicoDAO dao = new ServicoDAO();
                    dao.addServico(servico);

                    JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    private void carregarFormasDePagamento() {
        try {
            FormaDePagamentoDAO formaDAO = new FormaDePagamentoDAO();
            Map<Integer, FormaDePagamento> formas = formaDAO.getAllFormas();

            for (FormaDePagamento forma : formas.values()) {
                comboFormaPagamento.addItem(forma);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar formas de pagamento: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TelaServico();
    }
}
