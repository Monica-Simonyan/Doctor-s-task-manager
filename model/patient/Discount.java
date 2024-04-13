package model.patient;

public interface Discount {
    /**Method to apply discount to the given integer amount of money
     *
     * @param amount integer amount of money
     * @return integer money with applied discount
     */
     int applyDiscount(int amount);
}
