package pl.trawnicki.errors;

import javax.xml.bind.ValidationException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger("pl.jtrawnicki.java");
        boolean shouldContiniue = true;
        Set<String> users = new HashSet<>();

        while (shouldContiniue) {
            System.out.println("Wprowadź nazwę użytkownika(Max 12 znaków): ");
            String userName = scanner.nextLine();
            try {
                validateUserName(userName);
                if (isUserExist(userName, users)) {
                    users.add(userName);
                }
            } catch (ValidationException e) {
                System.err.println(e.getMessage());
                continue;
            } catch (CustomException e) {
                System.err.println(e.getMessage());
                continue;
            }


            System.out.println("Wprowadź hasło(Minimum 8 znaków i zawierać znak specjalny): ");
            String userPassword = scanner.nextLine();

            try {
                validateUserPassword(userPassword);
            } catch (ValidationException e) {
                System.err.println(e.getMessage());
                continue;
            }

            System.out.println("Powtórz hasło: ");
            String repeatedPassword = scanner.nextLine();

            try {
                if (passwordIsTheSame(userPassword, repeatedPassword)) {
                    System.out.println("Został utworzony nowy użytkownik.");
                    logger.log(Level.INFO, "Utworzenie nowego użytkownika");
//                    shouldContiniue = false;
                }
            } catch (ValidationException e) {
                System.err.println(e.getMessage());
                logger.log(Level.INFO, "Nieudana próba utworzenia użytkownika");
            }

        }
    }

    public static boolean isUserExist(String userName, Set<String> users) throws CustomException {
        if (!users.contains(userName)) {
            return true;
        } else {
            throw new CustomException("Użytwkonik o tej nazwie już istnieje");
        }

    }

    public static void validateUserPassword(String userPassword) throws ValidationException {
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(userPassword);

        if (userPassword == null || userPassword.isEmpty()) {
            throw new ValidationException("Hasło nie może być puste.");
        }

        userPassword.trim();

        if (userPassword.length() < 8) {
            throw new ValidationException("Hasło musi zawierać przynajmniej 8 znaków.");
        }

        if (!hasSpecial.find()) {
            throw new ValidationException("Hasło musi zawierać przynajmnie jeden znak specjalny");
        }
    }

    public static void validateUserName(String userName) throws ValidationException {
        if (userName == null || userName.isEmpty()) {
            throw new ValidationException("Nazwa użytkownika nie może być pusta.");
        }

        userName.trim();

        if (userName.length() > 12) {
            throw new ValidationException("Nazwa użytkownika nie może być dłuższa niż 12 znaków.");
        }
    }

    public static boolean passwordIsTheSame(String password, String repeatedPassword) throws ValidationException {
        if (password.equals(repeatedPassword)) {
            return true;
        } else {
            throw new ValidationException("Hasła różnią się od siebie");
        }
    }

}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}


