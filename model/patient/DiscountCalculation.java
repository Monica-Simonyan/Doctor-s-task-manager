package model.patient;

import model.exceptions.DiscountablePaymentException;

/**
 * Interface for applying discounts to patient fees.
 */
public interface DiscountCalculation {

    /**
     * Applies discount to the given fee.
     *
     * @param fee the fee to which the discount is applied
     */
    void applyDiscount(Payments.Fee fee);

    /**
     * Adds a discounted fee to the list of fees.
     *
     * @param fee the fee to add
     * @throws DiscountablePaymentException if the fee is not discountable
     */
    void addDiscountedFee(Payments.Fee fee) throws DiscountablePaymentException;
}
