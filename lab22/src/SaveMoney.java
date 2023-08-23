
import java.io.*;

public class SaveMoney {

  public static void main(String argv[]) throws Exception {
     String[] dataSource =  {"B5","Q","B20","Q", "P", "N", "D"};
     FileOutputStream fos = new FileOutputStream("money.out");
     ObjectOutputStream oos = new ObjectOutputStream(fos);
     Money myMoney = null;
     for (int i=0;i<dataSource.length;i++){
        char dataItem = dataSource[i].charAt(0);
        if (dataItem == 'B') {
           int billValue= Integer.parseInt(dataSource[i].substring(1,dataSource[i].length()));
           myMoney = new Bill(billValue);
        }   
        else {
           if (dataItem == 'Q')
              myMoney = new Quarter();
           else if (dataItem == 'D')
              myMoney = new Dime();
           else if (dataItem == 'N')
              myMoney = new Nickel();
           else if (dataItem == 'P')
              myMoney = new Penny();
           }
        oos.writeObject(myMoney);
        }
     oos.flush();
     oos.close();
     fos.close();
  }
}