package Screens;

import Routes.FormaDePagamentoDAO;
import Tables.FormaDePagamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaFormaDePagamento extends JFrame {

    private JTextField txtFormaPagamento;
    private JButton btnSalvar;

    public TelaFormaDePagamento() {
        setTitle("Cadastro de Forma de Pagamento");
        setSize(525, 420); // 1.5x maior que 350x280
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblForma = new JLabel("Forma de Pagamento:");
        lblForma.setBounds(50, 60, 180, 30);
        add(lblForma);

        txtFormaPagamento = new JTextField();
        txtFormaPagamento.setBounds(220, 60, 230, 30);
        add(txtFormaPagamento);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(200, 130, 120, 35);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String forma = txtFormaPagamento.getText().trim();

                    if (forma.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha o nome da forma de pagamento.");
                        return;
                    }

                    FormaDePagamento pagamento = new FormaDePagamento(null, forma);
                    FormaDePagamentoDAO dao = new FormaDePagamentoDAO();
                    dao.addFormaDePagamento(pagamento);

                    JOptionPane.showMessageDialog(null, "Forma de pagamento cadastrada com sucesso!");
                    txtFormaPagamento.setText("");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados:\n" + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaFormaDePagamento();
    }
}
