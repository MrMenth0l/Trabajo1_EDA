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
import javax.swing.JPanel;

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

        JLabel capacidadJLabel = new JLabel();



        JButton encenderButton = new JButton("ON");
        encenderButton.setFont(font);
        encenderButton.setHorizontalAlignment(0);
        onoffPanel.add(encenderButton);

        JButton apagarButton = new JButton("OFF");
        apagarButton.setFont(font);
        apagarButton.setHorizontalAlignment(0);
        onoffPanel.add(apagarButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(onoffPanel,gbc);

        encenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(blender.checkPowerStatus()==0){
                    blender.switchPowerStatus();
                };
            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(blender.checkPowerStatus()==1){
                    blender.switchPowerStatus();
                };
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
