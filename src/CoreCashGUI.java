import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoreCashGUI {
    private Account account;
    private JFrame frame;
    private JLabel balanceLabel;

    public CoreCashGUI() {
        // Default account එක (Balance: 1000, PIN: 1234)
        account = new Account(1000.00, 1234);
        initializeUI();
    }

    private void initializeUI() {
        // 1. Main Window (Frame) එක හැදීම
        frame = new JFrame("CoreCash ATM");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        // 2. Components හැදීම
        balanceLabel = new JLabel("Current Balance: Rs." + account.getBalance(), SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnCheck = new JButton("Refresh Balance");
        JButton btnDeposit = new JButton("Deposit Money");
        JButton btnWithdraw = new JButton("Withdraw Money");
        JButton btnExit = new JButton("Exit");

        // 3. Window එකට Components එකතු කිරීම
        frame.add(balanceLabel);
        frame.add(btnCheck);
        frame.add(btnDeposit);
        frame.add(btnWithdraw);
        frame.add(btnExit);

        // --- Button Click Logic (Event Handling) ---

        // Refresh Button
        btnCheck.addActionListener(e -> balanceLabel.setText("Current Balance: Rs." + account.getBalance()));

        // Deposit Button
        btnDeposit.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
            if (input != null && !input.isEmpty()) {
                double amount = Double.parseDouble(input);
                account.deposit(amount);
                balanceLabel.setText("Current Balance: Rs." + account.getBalance());
                JOptionPane.showMessageDialog(frame, "Successfully deposited!");
            }
        });

        // Withdraw Button
        btnWithdraw.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
            if (input != null && !input.isEmpty()) {
                double amount = Double.parseDouble(input);
                if (account.withdraw(amount)) {
                    balanceLabel.setText("Current Balance: Rs." + account.getBalance());
                    JOptionPane.showMessageDialog(frame, "Please collect your cash.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient funds or invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Exit Button
        btnExit.addActionListener(e -> System.exit(0));

        // Window එක screen එක මැදට පෙන්වීම
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // GUI එක run කරන්නේ මෙහෙමයි
        SwingUtilities.invokeLater(() -> new CoreCashGUI());
    }
}