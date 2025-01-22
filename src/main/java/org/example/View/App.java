package org.example.View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.example.Model.Blender;

public class App extends JFrame
{
    public App(Blender blender){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        Font font = new Font("Arial", Font.BOLD, 18);


        JPanel velocidadJPanel = new JPanel();
        JPanel capacityJPanel = new JPanel();
        JPanel onoffPanel = new JPanel();
        JPanel itemJPanel = new JPanel();
        itemJPanel.setLayout(new GridBagLayout());
        JPanel cuantJPanel = new JPanel();

        JLabel introJLabel = new JLabel("UI para licuadora");
        introJLabel.setFont(font);
        introJLabel.setHorizontalAlignment(0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(introJLabel,gbc);

        JLabel velocidadJLabel = new JLabel("Velocidad actual: " + blender.checkSpeed());
        velocidadJLabel.setFont(font);
        velocidadJPanel.add(velocidadJLabel);

        JButton incrementarVButton = new JButton("UP");
        incrementarVButton.setFont(font);
        velocidadJPanel.add(incrementarVButton);

        JButton reducirVButton = new JButton("DOWN");
        reducirVButton.setFont(font);
        velocidadJPanel.add(reducirVButton);

        gbc.gridy = 1;
        mainPanel.add(velocidadJPanel,gbc);

        JLabel capacidadJLabel = new JLabel("Capacidad actual: " + blender.actualCapacity());
        capacidadJLabel.setFont(font);
        capacityJPanel.add(capacidadJLabel);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.setFont(font);
        capacityJPanel.add(agregarButton);

        gbc.gridy = 2;
        mainPanel.add(capacityJPanel,gbc);

        JLabel itemJLabel = new JLabel("Item a a agregar");
        itemJLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        itemJPanel.add(itemJLabel,gbc);

        JTextField itemField = new JTextField();
        itemField.setFont(font);
        gbc.gridy = 1;
        itemJPanel.add(itemField,gbc);

        JLabel cuantJLabel = new JLabel("Cantidad a agregar");
        cuantJLabel.setFont(font);
        gbc.gridy = 0;
        gbc.gridx = 1;
        itemJPanel.add(cuantJLabel,gbc);

        JTextField cuantTextField = new JTextField();
        cuantTextField.setFont(font);
        gbc.gridy = 1;
        itemJPanel.add(cuantTextField,gbc);

        JButton confirmButton = new JButton("CONFIRMAR");
        confirmButton.setFont(font);
        gbc.gridy = 2;
        gbc.gridx = 0;
        itemJPanel.add(confirmButton,gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        mainPanel.add(itemJPanel,gbc);
        itemJPanel.setVisible(false);




        JButton encenderButton = new JButton("ON");
        encenderButton.setFont(font);
        encenderButton.setHorizontalAlignment(0);
        onoffPanel.add(encenderButton);

        JButton apagarButton = new JButton("OFF");
        apagarButton.setFont(font);
        apagarButton.setHorizontalAlignment(0);
        onoffPanel.add(apagarButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(onoffPanel,gbc);

        encenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(blender.checkPowerStatus()==0){
                    blender.switchPowerStatus();
                }
            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(blender.checkPowerStatus()==1){
                    blender.switchPowerStatus(); 
                }
                while (blender.checkSpeed() >= 0) {
                    blender.decreaseSpeed();
                }
                String text ="Velocidad actual: " + blender.checkSpeed();
                velocidadJLabel.setText(text); 
            }
        });

        incrementarVButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                blender.increaseSpeed();
                String text ="Velocidad actual: " + blender.checkSpeed();
                velocidadJLabel.setText(text);
            }
        });

        reducirVButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                blender.decreaseSpeed();
                String text ="Velocidad actual: " + blender.checkSpeed();
                velocidadJLabel.setText(text);
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!blender.isFull()){ 
                    if(blender.checkSpeed() == 0){       
                        itemJPanel.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(App.this, "La licuadora esta corriendo! baje la velocidad a 0");
                    }
                }else{
                    JOptionPane.showMessageDialog(App.this, "La licuadora esta llena");
                }
                
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blender.fillBlender(itemField.getText(), Float.parseFloat(cuantTextField.getText()));
                itemJPanel.setVisible(false);
                JOptionPane.showMessageDialog(App.this, "Se agrego " + itemField.getText() + " Correctamente");
                itemField.setText("");
                cuantTextField.setText("");
                capacidadJLabel.setText("Capacidad actual: " + blender.actualCapacity());
                
            }
        });
        







        setContentPane(mainPanel);
        setVisible(true);
        setSize(600,800);
        setLocationRelativeTo(null);
    }
    public static void main( String[] args )
    {
        Blender blender = new Blender();
        App app = new App(blender);
        
    }
}
