package testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public boolean isPasswordValid(String password) {
        if (password == null) return false;
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\$\\*%\\?\\+).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}