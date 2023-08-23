
public class Wallet {
  private MoneyList walletContents = new MoneyList();
  
  public Wallet(){
	  
  }
  public void addToWallet(Money m){
	  walletContents.append(m);
  }
  public void print () {
	  System.out.println(walletContents.toString());
  }
  public String getValue() {
     return walletContents.getValue();
  }
  public void printForward() {
     walletContents.printForward();
  }
  public void printBackward() {
     walletContents.printBackward();
  }
  public void printRecursiveSum() {
     walletContents.recursiveSum();
  }
  public void printRecursiveQuarters() {
     walletContents.recursiveQuarters();
  }
}
