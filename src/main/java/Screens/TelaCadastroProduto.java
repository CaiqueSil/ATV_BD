package Screens;

import Tables.Produto;
import Routes.ProdutoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaCadastroProduto extends JFrame {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JButton btnSalvar;

    public TelaCadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(350, 240);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 20, 160, 25);
        add(txtNome);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(20, 60, 100, 25);
        add(lblPreco);

        txtPreco = new JTextField();
        txtPreco.setBounds(130, 60, 160, 25);
        add(txtPreco);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(20, 100, 100, 25);
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(130, 100, 160, 25);
        add(txtQuantidade);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 150, 120, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    double preco = Double.parseDouble(txtPreco.getText());
                    int quantidade = Integer.parseInt(txtQuantidade.getText());

                    Produto produto = new Produto(null, nome, preco, quantidade);
                    ProdutoDAO dao = new ProdutoDAO();
                    dao.addProduto(produto);

                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: verifique se os campos numéricos estão preenchidos corretamente.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar no banco:\n" + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaCadastroProduto();
    }
}
