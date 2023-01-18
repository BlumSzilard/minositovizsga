package loans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @Test
    void testCreateLoan() {
        Loan loan = new Loan(1L, "John Doe", 1_200_000, 5.1);

        assertEquals(1L, loan.getId());
        assertEquals("John Doe", loan.getName());
        assertEquals(1_200_000, loan.getDebt());
        assertEquals(5.1, loan.getInterest());
    }

}
