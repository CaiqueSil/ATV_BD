package Screens;

import Tables.Animal;
import Routes.AnimalDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaCadastroAnimal extends JFrame {

    private JTextField txtNome;
    private JTextField txtIDCliente;
    private JTextField txtIDEspecie;

    private JButton btnSalvar;

    public TelaCadastroAnimal() {
        setTitle("Cadastro de Animal");
        setSize(350, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 20, 160, 25);
        add(txtNome);

        JLabel lblIDCliente = new JLabel("ID Cliente:");
        lblIDCliente.setBounds(20, 60, 100, 25);
        add(lblIDCliente);

        txtIDCliente = new JTextField();
        txtIDCliente.setBounds(130, 60, 160, 25);
        add(txtIDCliente);

        JLabel lblIDEspecie = new JLabel("ID Espécie:");
        lblIDEspecie.setBounds(20, 100, 100, 25);
        add(lblIDEspecie);

        txtIDEspecie = new JTextField();
        txtIDEspecie.setBounds(130, 100, 160, 25);
        add(txtIDEspecie);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 190, 120, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    Integer idCliente = Integer.parseInt(txtIDCliente.getText());
                    Integer idEspecie = Integer.parseInt(txtIDEspecie.getText());

                    Animal animal = new Animal(null, nome, idCliente, idEspecie);
                    AnimalDAO dao = new AnimalDAO();
                    dao.addAnimal(animal);

                    JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se os campos numéricos estão preenchidos corretamente.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados:\n" + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaCadastroAnimal();
    }
}
