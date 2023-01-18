package loans;

public class LoanService {
    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public int payForLoan(long id, int amount){
        Loan loan = loanRepository.findLoanById(id);
        int result = 0;
        if (amount > loan.getDebt()){
            result = amount - loan.getDebt();
            loanRepository.updateDebtWithPayment(id, loan.getDebt());
        } else {
            loanRepository.updateDebtWithPayment(id, amount);
        }
        return result;
    }
}
