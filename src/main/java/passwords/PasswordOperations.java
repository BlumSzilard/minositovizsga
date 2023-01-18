package passwords;

public class PasswordOperations {

    public PasswordStrength checkPasswordStrength(String password) {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Password is null or empty");
        }

        boolean hasNumber = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasNumber = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
            }
        }

        if (hasUpperCase && hasNumber) { //Ez volt a specifikációban és a tesztesetben, de nem értek egyet :)))
            return PasswordStrength.STRONG;
        }
        if (hasNumber && hasLowerCase) {
            return PasswordStrength.MEDIUM;
        }
        return PasswordStrength.WEAK;
    }
}
