import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker extends JFrame {
    private JTextField dateField, descriptionField, amountField;
    private JTable expenseTable;
    private DefaultTableModel tableModel;
    private List<Expense> expenses;
    private JLabel totalExpensesLabel;

    public ExpenseTracker() {
        setTitle("Expense Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        expenses = new ArrayList<Expense>();

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Date (yyyy-MM-dd):"));
        dateField = new JTextField();
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Date", "Description", "Amount"};
        tableModel = new DefaultTableModel(columnNames, 0);
        expenseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(expenseTable);
        add(scrollPane, BorderLayout.CENTER);

        // Summary Panel
        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalExpensesLabel = new JLabel("Total Expenses: $0.00");
        summaryPanel.add(totalExpensesLabel);

        add(summaryPanel, BorderLayout.SOUTH);
    }

    private void addExpense() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateField.getText());
            String description = descriptionField.getText();
            double amount = Double.parseDouble(amountField.getText());

            Expense expense = new Expense(date, description, amount);
            expenses.add(expense);

            Object[] row = {dateFormat.format(date), description, String.format("$%.2f", amount)};
            tableModel.addRow(row);

            updateSummary();

            // Clear input fields
            dateField.setText("");
            descriptionField.setText("");
            amountField.setText("");
        } catch (ParseException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check your entries.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSummary() {
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        totalExpensesLabel.setText(String.format("Total Expenses: $%.2f", total));
    }

    private class Expense {
        private Date date;
        private String description;
        private double amount;

        public Expense(Date date, String description, double amount) {
            this.date = date;
            this.description = description;
            this.amount = amount;
        }

        public Date getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExpenseTracker tracker = new ExpenseTracker();
            tracker.setVisible(true);
        });
    }
}