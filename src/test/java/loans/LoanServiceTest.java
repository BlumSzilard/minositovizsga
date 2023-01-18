package loans;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceTest {

    Flyway flyway;
    LoanRepository repository;
    LoanService service;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/exam-test?useUnicode=true");
            dataSource.setUserName("root");
            dataSource.setPassword("training");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot reach DataBase!", sqle);
        }

        flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        repository = new LoanRepository(dataSource);
        service = new LoanService(repository);
    }

    @Test
    void testPayForLoan() {
        long id = repository.insertLoan("John Doe", 1_200_000, 5.1);
        long id2 = repository.insertLoan("John Doe", 1_300_000, 4.1);

        int result = service.payForLoan(id, 900_000);
        assertEquals(0, result);
        assertEquals(300_000, repository.findLoanById(id).getDebt());

        result = service.payForLoan(id2, 1_400_000);
        assertEquals(100_000, result);
        assertEquals(0, repository.findLoanById(id2).getDebt());
    }

}