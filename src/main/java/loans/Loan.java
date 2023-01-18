package loans;

public class Loan {
    private Long id;
    private String name;
    private int debt;
    private double interest;

    public Loan(Long id, String name, int debt, double interest) {
        this.id = id;
        this.name = name;
        this.debt = debt;
        this.interest = interest;
    }

    public Loan(String name, int debt, double interest) {
        this.name = name;
        this.debt = debt;
        this.interest = interest;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDebt() {
        return debt;
    }

    public double getInterest() {
        return interest;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }
}
