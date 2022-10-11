/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Soft
 */
public class calculator implements Initializable{
    
    @FXML
    TextField result;
    String op = "" ;
    long number1;
    long number2;
    
    public void number(ActionEvent ae)
    {
        String num = ((Button)ae.getSource()).getText();
        result.setText(result.getText()+num);
    }
    public void restart(ActionEvent ae)
    {
        String res = ((Button)ae.getSource()).getText();
        result.setText("");
    }
    
    public void operation(ActionEvent ae)
    {
        String operation = ((Button)ae.getSource()).getText();
        if(!operation.equals("="))
        {
            
            if(!op.equals("")){
                return;
            }
            op = operation;
            number1 = Long.parseLong(result.getText());
            result.setText(""); 
        }
        else 
        {
         
            if(op.equals(""))
            {
                return;
            }
            number2 = Long.parseLong(result.getText());
            calculator(number1,number2,op);
            op="";
            
        }
    }
    public void calculator (long n1 , long n2 , String op)
    {
        switch(op)
        {
            case"+" : result.setText(n1+n2+"");
            break;
            case"-" : result.setText(n1-n2+"");
            break;
            case"*" : result.setText(n1*n2+"");
            break;
            case"/" : 
                if(n2 == 0)
                {
                    result.setText("0");
                    break;
                }
                result.setText(n1/n2+"");
                break;
        }
    }
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
