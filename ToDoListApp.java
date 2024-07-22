import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp extends JFrame {
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JTextField taskField;
    private JButton addButton, editButton, deleteButton;

    public ToDoListApp() {
        setTitle("To-Do List");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create table
        String[] columnNames = {"Task", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        taskTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create input panel
        JPanel inputPanel = new JPanel();
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        editButton = new JButton("Edit Task");
        deleteButton = new JButton("Delete Task");

        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            tableModel.addRow(new Object[]{task, "Pending"});
            taskField.setText("");
        }
    }

    private void editTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            String currentTask = (String) tableModel.getValueAt(selectedRow, 0);
            String newTask = JOptionPane.showInputDialog(this, "Edit task:", currentTask);
            if (newTask != null && !newTask.trim().isEmpty()) {
                tableModel.setValueAt(newTask.trim(), selectedRow, 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to edit.");
        }
    }

    private void deleteTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this task?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListApp().setVisible(true);
            }
        });
    }
}