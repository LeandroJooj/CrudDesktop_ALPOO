/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajdbc1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author george
 */
public class RadioButton {

public class PainelSelecaoRadio extends JPanel {

    private JRadioButton radio0;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JButton botaoLimpaSelecao;

    public PainelSelecaoRadio() {
        this.add(montaPainelRadio());
    }

    private JPanel montaPainelRadio() {
        JPanel painel = new JPanel();
        radio0 = new JRadioButton("Opção 0");
        radio1 = new JRadioButton("Opção 1");
        radio2 = new JRadioButton("Opção 2");

        radio0.setActionCommand("OPCAO_O");
        radio1.setActionCommand("OPCAO_1");
        radio2.setActionCommand("OPCAO_2");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio0);
        grupo.add(radio1);
        grupo.add(radio2);      
        

        botaoLimpaSelecao = new JButton("Limpa seleção");
        
        botaoLimpaSelecao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonModel selecao = grupo.getSelection();
                if (selecao != null) {
                    String actionCommand = selecao.getActionCommand();
                    JOptionPane.showMessageDialog(null, "O item que estava selecionado era " + actionCommand,
                            "Item selecionado", JOptionPane.ERROR_MESSAGE);
                    grupo.clearSelection();
                }
            }
        });

        painel.add(radio0);
        painel.add(radio1);
        painel.add(radio2);
        painel.add(botaoLimpaSelecao);
        return painel;
    }

}

}
