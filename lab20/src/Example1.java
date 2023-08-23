import javax.swing.*;
/*
 * Handle a NumberFormatException with a messageDialog
 */
public class Example1 {
   
   public static void main(String[] args) {
      String num;
      int n = 0;
      while (true) {
         try {
            num = JOptionPane.showInputDialog(null, "Enter a number");
            n = Integer.parseInt(num);
            JOptionPane.showMessageDialog(null,"Thank you for entering "+n);
            if(n==0)System.exit(0);
         }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null,"That is not a number! Try again");
         }
      }
   }

}
