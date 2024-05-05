//package model.patient;
//
//public interface PaymentCalculation<P extends Discount> {  /**
// * Adds a fee to the list of fees, performing a clone to avoid external modifications.
// *
// * @param fee the Fee to add
// */
// default void addFee(Payments.Fee fee) {
//    fee.setAmount(P.applyDiscount(fee.getAmount()));
//    fees.add(fee.clone());
//}
//
//    /**
//     * Calculates the total amount of fees that have been paid.
//     *
//     * @return the total amount of paid fees
//     */
//     static int countPaidFee() {
//        int total = countTotalFees();
//        for (Payments.Fee fee : fees) {
//            if (fee.wasPaid) {
//                total += fee.amount;
//            }
//        }
//        return total;
//    }
//
//    static int countTotalFees() {
//        int total = 0;
//        for (Payments.Fee fee : fees) {
//            total += fee.amount;
//        }
//        return T.applyDiscount(total);
//    }
//
//    /**
//     * Calculates the total amount of fees that have not been paid.
//     *
//     * @return the total amount of unpaid fees
//     */
//   static int countUnpaid() {
//        int total = 0;
//        for (Payments.Fee fee : fees) {
//            if (!fee.wasPaid) {
//                total += fee.amount;
//            }
//        }
//        return total;
//    }
//
//}
