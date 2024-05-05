package model.exceptions;

public class DiscountablePaymentException extends Exception{
    public DiscountablePaymentException(){
        super("This payment should eb discounted");
    }
    public DiscountablePaymentException(String msg){
        super(msg);
    }
}
