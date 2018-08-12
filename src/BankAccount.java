

public class BankAccount {

    Account acc5 = new Account();

    /**
     * Constructor
     *
     * @param balanceBA
     * @param interrateBA
     */
    public BankAccount(double balanceBA, double interrateBA) {
        acc5.setCurrentbalance(balanceBA);
        acc5.setAnnualinterest(interrateBA);

    }

    /**
     * Adding the amount of the deposit to the account balance and to the total of deposits this month.
     * Incrementing the number of deposits this month.
     *
     * @param depositAmount
     */
    public void makeDeposit(double depositAmount) {
        // depositAmount must be positive
        if (depositAmount >= 0) {
            acc5.setCurrentbalance(acc5.getCurrentbalance() + depositAmount);
            acc5.setNumberofdeposits(acc5.getNumberofdeposits() + 1);
            acc5.setTotaldeposits(depositAmount);
        } else {
            System.out.println("Unable to make Deposit with negative number");
        }
    }

    /**
     * Subtracting the amount of the withdrawal from the account balance and to the total of withdrawals this month.
     * Incrementing the number of withdrawals this month.
     *
     * @param withdrawAmount
     */
    public void makeWithdraw(double withdrawAmount) {
        if (withdrawAmount > 0 && withdrawAmount <= acc5.getCurrentbalance()) {
            acc5.setCurrentbalance(acc5.getCurrentbalance() - withdrawAmount);
            acc5.setNumberofwithdrawals(acc5.getNumberofwithdrawals() + 1);
            acc5.setTotalofwithdrawals(withdrawAmount);
        } else {
            System.out.println("Unable to make WithDraw. Not enough funds to make this operation");
        }
    }

    /**
     * Calculating the monthly interest earned by the account and store it in this month’s interest amount.
     * Adding the amount to the current balance.
     */
    public void calculateInterest() {
        acc5.setMonthlyinterest((acc5.getAnnualinterest() / 12.0));
        double MonthlyInterest = acc5.getCurrentbalance() * acc5.getMonthlyinterest();
        acc5.setMonthlyinterest(MonthlyInterest);
        acc5.setCurrentbalance(acc5.getCurrentbalance() + acc5.getMonthlyinterest());


    }

    /**
     * Subtracting the monthly service and penalty charges from the current balance and call the calculateInterest method.
     * Once all the calculations are done then making a copy of the Account bean.
     * Calling monthlyReset and return the copy.
     *
     * @return Account Object
     */
    public Account doMonthlyReport() {
        System.out.println("Current balance: " + acc5.getCurrentbalance());
        System.out.println("Number of deposits: " + acc5.getNumberofdeposits());
        System.out.println("Number of withdrawals: " + acc5.getNumberofwithdrawals());
        System.out.println("Penalty charges: " + acc5.getMonthlypenaltycharge());
        calculateInterest();
        monthlyReset();
        return acc5;
    }

    /**
     * Copying the Current Balance to the Starting Balance.
     * The number of deposits, number of withdrawals, the total of deposits, the total of withdrawals and the service and penalty charges
     * are setting to zero in preparation for the next month.
     */
    public void monthlyReset() {
        acc5.setCurrentbalance(acc5.getStartbalance());
        acc5.setNumberofdeposits(0);
        acc5.setNumberofwithdrawals(0);
        acc5.setTotaldeposits(0);
        acc5.setTotalofwithdrawals(0);
        acc5.setMonthlypenaltycharge(0.0);
        acc5.setMonthlyservicecharge(0.0);
    }
}
