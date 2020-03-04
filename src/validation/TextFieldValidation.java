/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 *
 */
public class TextFieldValidation {
    
    public static boolean isTextFieldNotEmpty(TextField tf)
    {
       boolean b =false;
       if(tf.getText().length() != 0 || ! tf.getText().isEmpty())
           b=true;
       return b;
    
    }
    
    
     public static boolean isTextFieldNotEmpty(TextField tf , Label lb , String errorMessage )
    {
       boolean b =true;
       
       String msg=null;
       if(! isTextFieldNotEmpty(tf))
       {
           msg=errorMessage;
           b=false;
       }
       lb.setText(msg);
       return b;
    
    }
     
      public static boolean isTextFAreaNotEmpty(TextArea tx)
    {
       boolean b1=false;
       if(tx.getText().length() != 0 || ! tx.getText().isEmpty())
           b1=true;
       return b1;
    
    }
      
      public static boolean isTextFAreaNotEmpty(TextArea tx , Label lb , String errorMessage )
    {
       boolean b1 =true;
       
       String msg1=null;
       if(! isTextFAreaNotEmpty(tx))
       {
           msg1=errorMessage;
           b1=false;
       }
       lb.setText(msg1);
       return b1;
    
    }
      
      public static boolean isNumber(TextField tff)
      {
         if (tff.getText().matches("-?([1-9][0-9]*)?"))
         {
             return true;
         }
         return false;
      
      }
     
      public static boolean isEmail (TextField text,  Label lb ,String errorMessage)
      {
          String b=errorMessage;
      if (text.getText().matches("^(.+)@(.+)$") )
      {
          b=null;
          lb.setText(b);
        return true;
      }
       lb.setText(b);
      return false;
      
      
      }
         
    
}
