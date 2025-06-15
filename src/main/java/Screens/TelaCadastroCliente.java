package Screens;

import Tables.Cliente;
import Routes.ClienteDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaCadastroCliente extends JFrame {

    private JTextField txtNome;
    private JTextField txtRua;
    private JTextField txtEstado;
    private JTextField txtCEP;
    private JTextField txtCPF;
    private JButton btnSalvar;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 20, 160, 25);
        add(txtNome);

        JLabel lblRua = new JLabel("Rua:");
        lblRua.setBounds(20, 60, 100, 25);
        add(lblRua);

        txtRua = new JTextField();
        txtRua.setBounds(130, 60, 160, 25);
        add(txtRua);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(20, 100, 100, 25);
        add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(130, 100, 160, 25);
        add(txtEstado);

        JLabel lblCEP = new JLabel("CEP:");
        lblCEP.setBounds(20, 140, 100, 25);
        add(lblCEP);

        txtCEP = new JTextField();
        txtCEP.setBounds(130, 140, 160, 25);
        add(txtCEP);

        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(20, 180, 100, 25);
        add(lblCPF);

        txtCPF = new JTextField();
        txtCPF.setBounds(130, 180, 160, 25);
        add(txtCPF);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 220, 120, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    String rua = txtRua.getText();
                    String estado = txtEstado.getText();
                    int cep = Integer.parseInt(txtCEP.getText());
                    String cpf = txtCPF.getText();

                    Cliente cliente = new Cliente(null, nome, rua, estado, cep, cpf);
                    ClienteDAO dao = new ClienteDAO();
                    dao.addCliente(cliente);

                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: verifique se os campos numéricos estão corretos.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar no banco:\n" + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaCadastroCliente();
    }
}
