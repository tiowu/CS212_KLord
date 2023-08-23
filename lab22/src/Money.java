import java.io.Serializable;
public abstract class Money implements Serializable{
   
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   public abstract int getValue(); //in this parent class, this sets the requirement for every child class to have a getValue()
}
