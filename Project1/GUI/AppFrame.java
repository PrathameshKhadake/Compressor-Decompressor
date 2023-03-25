package GUI;

import java.io.File;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class AppFrame extends JFrame implements ActionListener{

    // create two buttons
    JButton compressButton;
    JButton decompressButton;
    
    
    AppFrame(){

        //default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //create new button for com and decomp and set name & also set the size and location
        compressButton = new JButton("Select file to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(30, 200, 200, 30);
        compressButton.setBackground(Color.ORANGE);
        //this.setVisible(true);
        
        decompressButton = new JButton("Select file to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 200, 200, 30);
        decompressButton.setBackground(Color.ORANGE);
        //this.setVisible(true);

        //add both buttons
        this.add(compressButton);
        this.add(decompressButton);

        //set size, content pen and color
        this.setSize(500, 500);
        this.setLocation(400, 100);
        
        //this.setBackground(Color.RED);
        this.getContentPane().setBackground(Color.BLACK);

        this.setVisible(true);

    }


    // create interface of actionPerform

    @Override
    public void actionPerformed(ActionEvent e){

        //for compressor
        
        if(e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();

            int response = filechooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    compressor.method(file);
                }
                catch(Exception exp){
                    JOptionPane.showMessageDialog(null, exp.toString());
                }

            }
        }


        //for decompressor

        if(e.getSource() == decompressButton){

            JFileChooser filechooser = new JFileChooser();

            int response = filechooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    decompressor.method(file);
                }
                catch(Exception exp){
                    JOptionPane.showMessageDialog(null, exp.toString());
                }

            }
        }

    }
}