import Screens.TelaCadastroAnimal;
import Screens.TelaCadastroCliente;
import Screens.TelaServico;
import Screens.TelaProduto;

import java.awt.*;
import javax.swing.*;

public class PetShopMenu extends JFrame {
    public static class Menu {

        public static void main(String[] args) {
            JFrame frame = new JFrame("Menu PetShop");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JButton animalButton = new JButton("Animal");
            JButton clienteButton = new JButton("Cliente");
            JButton servicoButton = new JButton("Servico");
            JButton produtoButton = new JButton("Produto");

            animalButton.addActionListener(e -> new TelaCadastroAnimal());
            clienteButton.addActionListener(e -> new TelaCadastroCliente());
            servicoButton.addActionListener(e -> new TelaServico());
            produtoButton.addActionListener(e -> new TelaProduto());

            frame.add(animalButton);
            frame.add(clienteButton);
            frame.add(servicoButton);
            frame.add(produtoButton);

            frame.setVisible(true);
        }
    }
}
