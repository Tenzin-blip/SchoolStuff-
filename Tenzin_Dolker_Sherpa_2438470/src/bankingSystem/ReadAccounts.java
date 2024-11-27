package bankingSystem;
import java.io.*;
import java.util.*;

public class ReadAccounts {
    private String filename;

    public ReadAccounts(String filename) {
        this.filename = filename;
    }

    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                firstNames.add(parts[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return firstNames;
    }

    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                lastNames.add(parts[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lastNames;
    }

    public LinkedList<Integer> getAccountNumbers() {
        LinkedList<Integer> accountNumbers = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                accountNumbers.add(Integer.parseInt(parts[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return accountNumbers;
    }

    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balances = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                balances.add(Integer.parseInt(parts[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return balances;
    }
}

