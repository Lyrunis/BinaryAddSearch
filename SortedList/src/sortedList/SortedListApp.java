package sortedList;

import javax.swing.*;
import java.awt.*;

public class SortedListApp extends JFrame {
    private final SortedList sortedList;
    private final JPanel listPanel; // Displays the sorted list
    private final JTextField inputField; // User input

    public SortedListApp() {
        sortedList = new SortedList();

        setTitle("Sorted List Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Input panel setup
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        inputPanel.add(new JLabel("Input: "));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        // List display panel setup
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS)); // Display items vertically
        listPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(listPanel); // Scroll
        scrollPane.setBorder(BorderFactory.createTitledBorder("Sorted List"));

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(e -> addElement());
        searchButton.addActionListener(e -> searchElement());

        setVisible(true);
    }

    private void addElement() {
        String input = inputField.getText().trim();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input cannot be empty!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        sortedList.add(input); // Add to sorted list
        inputField.setText(""); // Clear the input field
        updateListDisplay(); // Refresh the displayed list
    }

    private void searchElement() {
        String input = inputField.getText().trim();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input cannot be empty!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int index = sortedList.search(input);
        if (index >= 0) {
            JOptionPane.showMessageDialog(this, "\"" + input + "\" found at index " + index + ".");
        } else {
            JOptionPane.showMessageDialog(this, "\"" + input + "\" not found. It would be inserted at index " + (-index - 1) + ".");
        }
    }

    private void updateListDisplay() {
        listPanel.removeAll(); // Clear the panel

        // Place panel with sorted items
        for (String item : sortedList.getList()) {
            JLabel listItem = new JLabel(item); // Each item as a label
            listItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            listPanel.add(listItem);
        }

        listPanel.revalidate(); // Refresh layout
        listPanel.repaint(); // Repaint to show updates
    }
}
