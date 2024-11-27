package bankingSystem;

import java.awt.EventQueue;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField accDeposit, accWithdraw, acc1Transfer, acc2Transfer, depositInput, withdrawInput, transferAmount;
    private JLabel showAllData;
    private JButton showAllButton, depositButton, withdrawButton, transferButton;

    private LinkedList<Account> globalAccounts;
    private StringBuilder sbAllData;
    private JLabel lblNewLabel_1;
    private JLabel lblAmount_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblAmount_2;
    private JButton btnNewButton;

    public static void main(String[] args) {
        LinkedList<Account> accounts = loadAccountsFromCSV("C:\\Users\\Admin\\eclipse-workspace\\Tenzin_Dolker_Sherpa_2438470\\Accounts.csv");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI(accounts);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI(LinkedList<Account> accounts) {
        super("Banking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1239, 695);
        contentPane = new JPanel();
        contentPane.setForeground(Color.YELLOW);
        contentPane.setBackground(new Color(128, 128, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        globalAccounts = accounts;
        sbAllData = new StringBuilder();

        showAllData = new JLabel("");
        showAllData.setForeground(Color.WHITE);
        showAllData.setBackground(Color.GRAY);
        showAllData.setBounds(663, 119, 488, 318);
        contentPane.add(showAllData);

        showAllButton = new JButton("Show All");
        showAllButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        showAllButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        showAllButton.setBackground(Color.LIGHT_GRAY);
        showAllButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateAllDataDisplay();
                showAllData.setText("<html>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
            }
        });
        showAllButton.setBounds(812, 187, 131, 25);
        contentPane.add(showAllButton);

        // Deposit Part here button and labels
        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblDeposit.setForeground(Color.WHITE);
        lblDeposit.setBounds(43, 10, 100, 30);
        contentPane.add(lblDeposit);

        accDeposit = new JTextField("");
        accDeposit.setBounds(186, 55, 200, 30);
        contentPane.add(accDeposit);

        depositInput = new JTextField("");
        depositInput.setBounds(186, 95, 200, 30);
        contentPane.add(depositInput);

        depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        depositButton.setBackground(new Color(128, 128, 255));
        depositButton.setBounds(186, 147, 100, 30);
        depositButton.addActionListener(new HandlerClass());
        contentPane.add(depositButton);

        // Withdraw Part here button and labels
        JLabel lblWithdraw = new JLabel("Withdraw");
        lblWithdraw.setForeground(Color.WHITE);
        lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblWithdraw.setBounds(43, 195, 155, 30);
        contentPane.add(lblWithdraw);

        accWithdraw = new JTextField("");
        accWithdraw.setBounds(186, 235, 200, 30);
        contentPane.add(accWithdraw);

        withdrawInput = new JTextField("");
        withdrawInput.setBounds(186, 275, 200, 30);
        contentPane.add(withdrawInput);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 15));
        withdrawButton.setBackground(new Color(128, 128, 255));
        withdrawButton.setBounds(186, 332, 108, 30);
        withdrawButton.addActionListener(new HandlerClass());
        contentPane.add(withdrawButton);

        // Transfer Part here button and labels
        JLabel lblTransfer = new JLabel("Transfer");
        lblTransfer.setForeground(Color.WHITE);
        lblTransfer.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTransfer.setBounds(43, 407, 143, 30);
        contentPane.add(lblTransfer);

        acc1Transfer = new JTextField("");
        acc1Transfer.setBounds(219, 454, 200, 30);
        contentPane.add(acc1Transfer);

        acc2Transfer = new JTextField("");
        acc2Transfer.setBounds(219, 493, 200, 30);
        contentPane.add(acc2Transfer);

        transferAmount = new JTextField("");
        transferAmount.setBounds(219, 533, 200, 34);
        contentPane.add(transferAmount);

        transferButton = new JButton("Transfer");
        transferButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        transferButton.setBackground(new Color(128, 128, 255));
        transferButton.setBounds(219, 604, 100, 30);
        transferButton.addActionListener(new HandlerClass());
        contentPane.add(transferButton);

        JLabel lblNewLabel = new JLabel("Account Number :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setForeground(Color.YELLOW);
        lblNewLabel.setBounds(43, 52, 131, 30);
        contentPane.add(lblNewLabel);
        
        JLabel lblAmount = new JLabel("Amount :");
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAmount.setForeground(Color.YELLOW);
        lblAmount.setBounds(43, 92, 108, 30);
        contentPane.add(lblAmount);
        
        lblNewLabel_1 = new JLabel("Account Number :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setForeground(Color.YELLOW);
        lblNewLabel_1.setBounds(43, 235, 200, 30);
        contentPane.add(lblNewLabel_1);
        
        lblAmount_1 = new JLabel("Amount :");
        lblAmount_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAmount_1.setForeground(Color.YELLOW);
        lblAmount_1.setBounds(43, 275, 200, 30);
        contentPane.add(lblAmount_1);
        
        lblNewLabel_2 = new JLabel("From Account Number :");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setForeground(Color.YELLOW);
        lblNewLabel_2.setBounds(43, 454, 177, 30);
        contentPane.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("To Account Number :");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_3.setForeground(Color.YELLOW);
        lblNewLabel_3.setBounds(43, 493, 177, 30);
        contentPane.add(lblNewLabel_3);
        
        lblAmount_2 = new JLabel("Amount : ");
        lblAmount_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAmount_2.setForeground(Color.YELLOW);
        lblAmount_2.setBounds(43, 533, 155, 30);
        contentPane.add(lblAmount_2);
        
        JLabel lblNewLabel_4 = new JLabel("Available Bank Accounts");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_4.setBackground(Color.WHITE);
        lblNewLabel_4.setBounds(715, 138, 320, 39);
        contentPane.add(lblNewLabel_4);
        
        btnNewButton = new JButton("Reset");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		depositInput.setText("");
        		accDeposit.setText("");
        		accWithdraw.setText("");
        		withdrawInput.setText("");
        		acc1Transfer.setText("");
        		acc2Transfer.setText("");
        		transferAmount.setText("");
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(847, 606, 85, 26);
        contentPane.add(btnNewButton);
    }


    private class HandlerClass implements ActionListener {
        private static final String CSV_FILE_PATH = "C:\\Users\\Admin\\eclipse-workspace\\Tenzin_Dolker_Sherpa_2438470\\Accounts.csv";

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == depositButton) {
                int accNum = Integer.parseInt(accDeposit.getText());
                int amount = Integer.parseInt(depositInput.getText());
                for (Account acc : globalAccounts) {
                    if (acc.getAccountNum() == accNum) {
                        acc.deposit(amount);
                        JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + acc.getBalance());
                        updateCSVFile(CSV_FILE_PATH); 
                        updateAllDataDisplay();
                        showAllData.setText("<html>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Account not found.");
            } else if (e.getSource() == withdrawButton) {
                int accNum = Integer.parseInt(accWithdraw.getText());
                int amount = Integer.parseInt(withdrawInput.getText());
                for (Account acc : globalAccounts) {
                    if (acc.getAccountNum() == accNum) {
                        if (acc.withdraw(amount)) {
                            JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: " + acc.getBalance());
                            updateCSVFile(CSV_FILE_PATH); 
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds.");
                        }
                        updateAllDataDisplay();
                        showAllData.setText("<html>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Account not found.");
            } else if (e.getSource() == transferButton) {
                int fromAccNum = Integer.parseInt(acc1Transfer.getText());
                int toAccNum = Integer.parseInt(acc2Transfer.getText());
                int amount = Integer.parseInt(transferAmount.getText());
                Account fromAcc = null;
                Account toAcc = null;
                for (Account acc : globalAccounts) {
                    if (acc.getAccountNum() == fromAccNum) {
                        fromAcc = acc;
                    }
                    if (acc.getAccountNum() == toAccNum) {
                        toAcc = acc;
                    }
                }
                if (fromAcc != null && toAcc != null && fromAcc.withdraw(amount)) {
                    toAcc.deposit(amount);
                    JOptionPane.showMessageDialog(null, "Transfer successful. Transferred " + amount + " from Account " + fromAccNum + " to Account " + toAccNum);
                    updateCSVFile(CSV_FILE_PATH); 
                } else {
                    JOptionPane.showMessageDialog(null, "Transfer failed.");
                }
                updateAllDataDisplay();
                showAllData.setText("<html>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
            }
        }
    }


    private void updateAllDataDisplay() {
        sbAllData.setLength(0);
        for (Account account : globalAccounts) {
            sbAllData.append("First Name: ").append(account.getFirstName()).append(", ");
            sbAllData.append("Last Name: ").append(account.getLastName()).append(", ");
            sbAllData.append("Account Number: ").append(account.getAccountNum()).append(", ");
            sbAllData.append("Balance: ").append(account.getBalance()).append("<br>");
        }
    }
    private void updateCSVFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Account account : globalAccounts) {
                writer.append(account.getFirstName()).append(",");
                writer.append(account.getLastName()).append(",");
                writer.append(String.valueOf(account.getAccountNum())).append(",");
                writer.append(String.valueOf(account.getBalance())).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Account> loadAccountsFromCSV(String fileName) {
        LinkedList<Account> accounts = new LinkedList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String firstName = data[0];
                String lastName = data[1];
                int accountNumber = Integer.parseInt(data[2]);
                int balance = Integer.parseInt(data[3]);

                Account account = new Account(firstName, lastName, accountNumber, balance);
                accounts.add(account);
            }
        } catch (IOException e) {
        }

        return accounts;
    }
}
