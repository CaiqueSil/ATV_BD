import Screens.TelaCadastroAnimal;
import Screens.TelaCadastroCliente;
import Screens.TelaCadastroProduto;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetShopMenu extends JFrame {
    public static class Menu {

        public static void main(String[] args) {
            JFrame frame = new JFrame("Menu PetShop");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JButton animalButton = new JButton("Animal");
            JButton clienteButton = new JButton("Cliente");
            JButton produtoButton = new JButton("Produto");

            animalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TelaCadastroAnimal();
                }
            });
            clienteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TelaCadastroCliente();
                }
            });
            produtoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TelaCadastroProduto();
                }
            });

            frame.add(animalButton);
            frame.add(clienteButton);
            frame.add(produtoButton);

            frame.setVisible(true);


        }
    }
}