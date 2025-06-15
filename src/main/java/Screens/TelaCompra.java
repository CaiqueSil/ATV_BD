package Screens;

import Routes.CompraDAO;
import Tables.Compra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class TelaCompra extends JFrame {

    private JTextField txtDataCompra;
    private JTextField txtValor;
    private JTextField txtIDCliente;
    private JButton btnSalvar;

    public TelaCompra() {
        setTitle("Cadastro de Compra");
        setSize(525, 420); // 1.5x maior
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblData = new JLabel("Data (AAAA-MM-DD):");
        lblData.setBounds(50, 40, 160, 30);
        add(lblData);

        txtDataCompra = new JTextField();
        txtDataCompra.setBounds(220, 40, 230, 30);
        add(txtDataCompra);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(50, 90, 160, 30);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(220, 90, 230, 30);
        add(txtValor);

        JLabel lblCliente = new JLabel("ID Cliente:");
        lblCliente.setBounds(50, 140, 160, 30);
        add(lblCliente);

        txtIDCliente = new JTextField();
        txtIDCliente.setBounds(220, 140, 230, 30);
        add(txtIDCliente);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(200, 210, 120, 35);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDate data = LocalDate.parse(txtDataCompra.getText().trim());
                    BigDecimal valor = new BigDecimal(txtValor.getText().trim());
                    Integer idCliente = Integer.parseInt(txtIDCliente.getText().trim());

                    Compra compra = new Compra(null, data, valor, idCliente);
                    CompraDAO dao = new CompraDAO();
                    dao.addCompra(compra);

                    JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso!");
                    txtDataCompra.setText("");
                    txtValor.setText("");
                    txtIDCliente.setText("");

                } catch (NumberFormatException | java.time.format.DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Verifique os campos numéricos e a data no formato correto (AAAA-MM-DD).");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados:\n" + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaCompra();
    }
}
