package passwords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordOperationsTest {

    PasswordOperations passwordOperations = new PasswordOperations();

    @Test
    void testCheckPasswordStrengthWeekPassword() {
        assertEquals(PasswordStrength.WEEK, passwordOperations.checkPasswordStrength("almafa"));
        assertEquals(PasswordStrength.WEEK, passwordOperations.checkPasswordStrength("189726"));
        assertEquals(PasswordStrength.WEEK, passwordOperations.checkPasswordStrength("AlmAfa"));
        assertEquals(PasswordStrength.WEEK, passwordOperations.checkPasswordStrength("A"));
        assertEquals(PasswordStrength.WEEK, passwordOperations.checkPasswordStrength("1"));
    }

    @Test
    void testCheckPasswordStrengthMediumPassword() {
        assertEquals(PasswordStrength.MEDIUM, passwordOperations.checkPasswordStrength("alma12"));
        assertEquals(PasswordStrength.MEDIUM, passwordOperations.checkPasswordStrength("a1lm3"));
        assertEquals(PasswordStrength.MEDIUM, passwordOperations.checkPasswordStrength("alm3"));
        assertEquals(PasswordStrength.MEDIUM, passwordOperations.checkPasswordStrength("1alm"));
    }

    @Test
    void testCheckPasswordStrengthStrongPassword() {
        assertEquals(PasswordStrength.STRONG, passwordOperations.checkPasswordStrength("Alma12"));
        assertEquals(PasswordStrength.STRONG, passwordOperations.checkPasswordStrength("1Alma2"));
        assertEquals(PasswordStrength.STRONG, passwordOperations.checkPasswordStrength("1Alma"));
        assertEquals(PasswordStrength.STRONG, passwordOperations.checkPasswordStrength("1A2345"));
        assertEquals(PasswordStrength.STRONG, passwordOperations.checkPasswordStrength("1A2345"));
    }

}