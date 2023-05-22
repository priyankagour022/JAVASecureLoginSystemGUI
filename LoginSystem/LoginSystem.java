import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginSystem extends JFrame {
    private HashMap<String, String> loginInfo;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginSystem() {
        loginInfo = new HashMap<>();

        // Create and configure the JFrame
        setTitle("Login System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                registerUser(username, password);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                loginUser(username, password);
            }
        });

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        panel.add(usernamePanel);
        panel.add(Box.createVerticalStrut(10)); // Add vertical spacing
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(10)); // Add vertical spacing
        panel.add(buttonPanel);

        // Add panel to the JFrame
        add(panel);

        pack(); // Adjust the size of the JFrame to fit the components
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    public void registerUser(String username, String password) {
        if (loginInfo.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
        } else {
            loginInfo.put(username, password);
            JOptionPane.showMessageDialog(this, "User registered successfully!");
        }
    }

    public void loginUser(String username, String password) {
        String storedPassword = loginInfo.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Login failed.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginSystem().setVisible(true);
            }
        });
    }
}
