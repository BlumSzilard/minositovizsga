package loans;

import org.springframework.jdbc.core.JdbcTemplate;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class LoanRepository {
    private JdbcTemplate jdbcTemplate;

    public LoanRepository(MariaDbDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long insertLoan(String name, int debt, double interest) {
        Loan loan = new Loan(name, debt, interest);
        String sql = "INSERT INTO loans (name, debt, interest) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, loan.getName());
            ps.setInt(2, loan.getDebt());
            ps.setDouble(3, loan.getInterest());

            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public Loan findLoanById(Long id) {
        String sql = "SELECT * FROM loans WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, i) -> {
            return new Loan(rs.getLong("id"), rs.getString("name"), rs.getInt("debt"), rs.getDouble("interest"));
        }, id);
    }

    public void updateDebtWithInterest(){
        String sql = "UPDATE loans SET debt = debt + debt * interest / 100";
        jdbcTemplate.update(sql);
    }

    public void updateDebtWithPayment(long id, int amount){
        String sql = "UPDATE loans SET debt = debt - ? WHERE id = ?";
        jdbcTemplate.update(sql, amount, id);
    }


}
