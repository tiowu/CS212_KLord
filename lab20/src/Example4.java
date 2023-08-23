import javax.swing.*;
/*
 * Handle a NumberFormatException with a messageDialog
 */
public class Example4 {
   
   public static void main(String[] args)  {
      String num;
      int n = 0;
      int a[] = new int[10];
      while (true) {
         try {
            num = JOptionPane.showInputDialog(null, "Enter a number");
            n = Integer.parseInt(num);
            a[n] = n;
            JOptionPane.showMessageDialog(null,"Thank you for entering "+n);
            if(n==0)System.exit(0);
         }
        catch (NumberFormatException nfe) {
           JOptionPane.showMessageDialog(null,"Not a number!");
        }
        catch (IndexOutOfBoundsException ioob) {
           System.out.println("Bad array index: "+n);
        }   
        catch (Exception e) {
           System.out.println("An exception occurred.");
       }
     }
   }

}
