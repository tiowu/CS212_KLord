
import java.io.*;
import java.util.Date;

public class ReadMoney {

  public static void main(String argv[]) throws Exception {
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("money.out"));
    for(int i = 0; i < 7; i++) {
       Money myMoney = (Money) ois.readObject();
       System.out.println("I have " + myMoney + " in my wallet.");
    }
    ois.close();
  }
}