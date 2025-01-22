package add;
import add.details.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login extends JFrame implements ActionListener {
    JTextField userName;
    JPasswordField passWord;
    JButton Login,Cancel;

    public Login(){
        super.getContentPane().setBackground(Color.LIGHT_GRAY);
        super.setSize(1280,720);
        super.setLocation(150,50);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        ImageIcon icon=new ImageIcon("E:\\Ownproject\\Java Project\\Hotel_Management_System\\img\\Icon.png");//Icon
        super.setIconImage(icon.getImage());//adding icon
        super.setTitle("Log in");


        //adding label for user name
        JLabel user_name=new JLabel("User name : ");
        user_name.setBounds(300,250,80,30);
        super.add(user_name);

        //adding textbox for user name
        userName=new JTextField();
        userName.setBounds(385,250,250,30);
        super.add(userName);


        //adding label for password
        JLabel password=new JLabel("Password  : ");
        password.setBounds(300,300,80,25);
        super.add(password);

        //adding textbox for password
        passWord=new JPasswordField();
        passWord.setBounds(385,300,250,25);
        super.add(passWord);

        //login button
        Login=new JButton("Log in");
        Login.setBounds(385,400,70,30);
        Login.setFocusable(false);
        Login.setBackground(Color.black);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        Login.setFont(new Font("Serif", Font.BOLD, 12));
        super.add(Login);

        //cancel button
        Cancel=new JButton("Cancel");
        Cancel.setBounds(500,400,70,30);
        Cancel.setFocusable(false);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Serif", Font.BOLD, 12));
        super.add(Cancel);

        super.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            admin();
        } else if (e.getSource() == Cancel) {
            super.dispose();
            new HotelManagementSystem();
        }
    }

    public void admin() {
        String username = userName.getText();
        String password = new String(passWord.getPassword());
        AdminDetails u = null;
        try {
            File admin = new File("E:\\Ownproject\\Java Project\\Hotel_Management_System\\src\\add\\details\\TextFiles\\AdminDetails.txt");
            if (!admin.exists()) {
                JOptionPane.showMessageDialog(null, "No user is registered!");
            }
            BufferedReader reader = new BufferedReader((new FileReader(admin)));
            String line = reader.readLine();
            boolean loggedin = false;
            while ((line=reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    loggedin = true;
                    u = new AdminDetails(parts[0], parts[1]);
                    break;
                }
            }
            reader.close();
            if (loggedin) {
                JOptionPane.showMessageDialog(null, "Login successful");
                super.dispose();
                new DashBoard();
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                return;
            }
        }
        catch (IOException ae) {
            System.out.println("An error occurred: " + ae.getMessage());
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
