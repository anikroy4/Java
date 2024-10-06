import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class CarmanagementForm extends javax.swing.JFrame {

    public CarmanagementForm() {
        initComponents();
    }

    private void initComponents() {

        // Components for the registration part


        JLabel brandLabel = new JLabel("Brand Name:");
        JLabel modelLabel = new JLabel("Model Name:");
        JLabel mileageLabel = new JLabel("Mileage:");
        JLabel priceLabel = new JLabel("Price:");
        JTextField brandField = new JTextField(15);
        JTextField modelField = new JTextField(15);
        JTextField mileageField = new JTextField(15);
        JTextField priceField = new JTextField(15);
        JButton registerButton = new JButton("Register");

        // Components for the search part


        JLabel searchBrandLabel = new JLabel("Search by Brand Name:");
        JLabel searchModelLabel = new JLabel("Search by Model Name:");
        JLabel priceRangeLabel = new JLabel("Price Range:");
        JTextField searchBrandField = new JTextField(15);
        JTextField searchModelField = new JTextField(15);
        JTextField lowerLimitField = new JTextField(7);
        JTextField upperLimitField = new JTextField(7);
        JButton searchBrandButton = new JButton("Search");
        JButton searchModelButton = new JButton("Search");
        JButton searchPriceButton = new JButton("Search");
        JTextArea searchResultsTextArea = new JTextArea(10, 50);

        // Layout configuration


        JPanel panel = new JPanel();
        panel.add(brandLabel);
        panel.add(brandField);
        panel.add(modelLabel);
        panel.add(modelField);
        panel.add(mileageLabel);
        panel.add(mileageField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(registerButton);

        panel.add(searchBrandLabel);
        panel.add(searchBrandField);
        panel.add(searchBrandButton);
        panel.add(searchModelLabel);
        panel.add(searchModelField);
        panel.add(searchModelButton);
        panel.add(priceRangeLabel);
        panel.add(lowerLimitField);
        panel.add(new JLabel("to"));
        panel.add(upperLimitField);
        panel.add(searchPriceButton);
        panel.add(new JScrollPane(searchResultsTextArea));

        // Register button action


        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String brand = brandField.getText();
                String model = modelField.getText();
                String mileage = mileageField.getText();
                String price = priceField.getText();

                if (!brand.isEmpty() && !model.isEmpty() && !mileage.isEmpty() && !price.isEmpty()) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("cars.txt", true))) {
                        writer.write(brand + "," + model + "," + mileage + "," + price + "\n");
                        JOptionPane.showMessageDialog(null, "Car registered successfully!");
                        brandField.setText("");
                        modelField.setText("");
                        mileageField.setText("");
                        priceField.setText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                }
            }
        });

        // Search by brand button action


        searchBrandButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String brand = searchBrandField.getText();
                ArrayList<String> results = new ArrayList<>();

                try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        if (data[0].equalsIgnoreCase(brand)) {
                            results.add("Brand: " + data[0] + ", Model: " + data[1] + ", Mileage: " + data[2] + ", Price: " + data[3]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                searchResultsTextArea.setText("");
                if (!results.isEmpty()) {
                    for (String result : results) {
                        searchResultsTextArea.append(result + "\n");
                    }
                }
                else {
                    searchResultsTextArea.setText("No results found.");
                }
            }
        });

        // Search by model button action
        searchModelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String model = searchModelField.getText();
                ArrayList<String> results = new ArrayList<>();

                try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        if (data[1].equalsIgnoreCase(model)) {
                            results.add("Brand: " + data[0] + ", Model: " + data[1] + ", Mileage: " + data[2] + ", Price: " + data[3]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                searchResultsTextArea.setText("");
                if (!results.isEmpty()) {
                    for (String result : results) {
                        searchResultsTextArea.append(result + "\n");
                    }
                } else {
                    searchResultsTextArea.setText("No results found.");
                }
            }
        });

        // Search by price range button action


        searchPriceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String lowerLimit = lowerLimitField.getText();
                String upperLimit = upperLimitField.getText();
                ArrayList<String> results = new ArrayList<>();

                if (!lowerLimit.isEmpty() && !upperLimit.isEmpty()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] data = line.split(",");
                            int price = Integer.parseInt(data[3]);
                            if (price >= Integer.parseInt(lowerLimit) && price <= Integer.parseInt(upperLimit)) {
                                results.add("Brand: " + data[0] + ", Model: " + data[1] + ", Mileage: " + data[2] + ", Price: " + data[3]);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    searchResultsTextArea.setText("");
                    if (!results.isEmpty()) {
                        for (String result : results) {
                            searchResultsTextArea.append(result + "\n");
                        }
                    }
                    else {
                        searchResultsTextArea.setText("No results found.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Both price limits are required!");
                }
            }
        });


        // Finalize frame


        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Car Management System");
        setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarmanagementForm().setVisible(true);
            }
        });
    }
}