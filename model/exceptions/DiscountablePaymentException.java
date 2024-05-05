package model.exceptions;

public class DiscountablePaymentException extends Exception{
    public DiscountablePaymentException(){
        super("This payment should be discounted");
    }
    public DiscountablePaymentException(String msg){
        super(msg);
    }
}
