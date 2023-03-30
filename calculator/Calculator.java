import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator implements ActionListener{
     JFrame frame;
     JTextField textfield;
     JButton[] numberButtons = new JButton[10];
     JButton[] functioButtons = new JButton[8];
     JButton ab,sb,mb,db;
     JButton decB, equB ,clrB,delB;
     JPanel panel;
     Font myFont = new Font("Ink free",Font.BOLD,30);
     double num1=0,num2=0,result=0;
     char operator;
    Calculator(){
         frame = new JFrame("Calcultor");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(420,550);
         frame.setLayout(null);
         textfield = new JTextField();
         textfield.setBounds(50,25,300,50);
         textfield.setFont(myFont);
         textfield.setEditable(false);
         ab = new JButton("+");
         sb = new JButton("-");
         mb = new JButton("*");
         db = new JButton("/");
         decB = new JButton(".");
         clrB = new JButton("AC");
         equB = new JButton("=");
         delB = new JButton("Delete");
         
        functioButtons[0] =ab;
         functioButtons[0] =sb;
         functioButtons[0] =mb;
         functioButtons[0] =db;
         functioButtons[0] =decB;
         functioButtons[0] =clrB;
         functioButtons[0] =equB;
         functioButtons[0] =delB;
         
         for(int i=0;i<8;i++){
            functioButtons[i].addActionListener(this);
            functioButtons[i].setFont(myFont);
            functioButtons[i].setFocusable(false);
         }

        for(int i=0;i<8;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
         }

         delB.setBounds(50,430,145,50);
         clrB.setBounds(205,430,145,50);

          panel= new JPanel();
          panel.setBounds(50,100,300,300);
          panel.setLayout(new GridLayout(4,4,10,10));
          panel.setBackground(Color.GRAY);

         panel.add(numberButtons[1]);
         panel.add(numberButtons[2]);
         panel.add(numberButtons[3]);
         panel.add(ab);
         panel.add(numberButtons[4]);
         panel.add(numberButtons[5]);
         panel.add(numberButtons[6]);
         panel.add(sb);
         panel.add(numberButtons[7]);
         panel.add(numberButtons[8]);
         panel.add(numberButtons[9]);
         panel.add(mb);
         panel.add(decB);
         panel.add(numberButtons[0]);
         panel.add(equB);
         panel.add(decB);
         panel.add(db);

         frame.add(textfield);
         frame.setVisible(true);
    }

    public static void main(String args[]) {
        Calculator cal = new Calculator();
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decB){
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource() == ab){
            num1 = Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        if(e.getSource() == sb){
            num1 = Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        if(e.getSource() == mb){
            num1 = Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        if(e.getSource() == db){
            num1 = Double.parseDouble(textfield.getText());
            operator= '/';
            textfield.setText("");
        }
        if(e.getSource() == equB){
            num1 = Double.parseDouble(textfield.getText());
            switch(operator){
            case'+' :
                result =num1+num2;
                break;
            case'-' :
                result =num1-num2;
                break;
            case'*' :
                result =num1*num2;
                break;
            case'/' :
                result =num1/num2;
                break; 
            }
            textfield.setText(String.valueOf(result));
        }
        if(e.getSource() == clrB){
            textfield.setText(" ");;
        }
        if(e.getSource() == delB){
            String str = textfield.getText();
            textfield.setText("");
            for(int i=0;i<str.length()-1;i++){
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }
    }
}