package Screens;

import Routes.TipoDeServicoDAO;
import Tables.TipoDeServico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaTipoDeServico extends JFrame {

    private JTextField txtTipoServico;
    private JButton btnSalvar;

    public TelaTipoDeServico() {
        setTitle("Cadastro de Tipo de Serviço");
        setSize(525, 420); // 1.5x maior que 350x280
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTipo = new JLabel("Tipo de Serviço:");
        lblTipo.setBounds(50, 60, 150, 30);
        add(lblTipo);

        txtTipoServico = new JTextField();
        txtTipoServico.setBounds(200, 60, 250, 30);
        add(txtTipoServico);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(200, 120, 120, 35);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tipoServico = txtTipoServico.getText().trim();

                    if (tipoServico.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha o campo de tipo de serviço.");
                        return;
                    }

                    TipoDeServico tipo = new TipoDeServico(null, tipoServico);
                    TipoDeServicoDAO dao = new TipoDeServicoDAO();
                    dao.addTipoDeServico(tipo);

                    JOptionPane.showMessageDialog(null, "Tipo de serviço cadastrado com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados:\n" + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaTipoDeServico();
    }
}
