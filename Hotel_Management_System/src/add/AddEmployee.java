package add;
import add.details.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField t_name, t_age, t_nid, t_salary, t_phone, t_email;
    JButton submit;
    JRadioButton male, female;
    JComboBox jobb;
    EmployeeDetails[] employee;

    AddEmployee() {
        employee = new EmployeeDetails[50];
        super.getContentPane().setBackground(Color.white);
        super.setSize(800, 500); // Reduced frame height
        super.setLocation(400, 200);
        super.setLayout(null);
        ImageIcon icon=new ImageIcon("E:\\Ownproject\\Java Project\\Hotel_Management_System\\img\\Icon.png");//Icon
        super.setIconImage(icon.getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setTitle("ADD EMPLOYEE");

        // Adding label and textbox for employee name
        JLabel name = new JLabel("NAME");
        name.setBounds(50, 30, 100, 25);
        name.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(name);

        t_name = new JTextField();
        t_name.setBounds(150, 30, 250, 25);
        t_name.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_name);

        // Adding label and text box for age
        JLabel age = new JLabel("AGE");
        age.setBounds(50, 70, 100, 25);
        age.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(age);

        t_age = new JTextField();
        t_age.setBounds(150, 70, 250, 25);
        t_age.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_age);

        // Adding label and radio button for gender
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(50, 110, 100, 25);
        gender.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(150, 110, 70, 25);
        male.setFocusable(false);
        male.setFont(new Font("Tahoma", Font.BOLD, 14));
        super.add(male);

        female = new JRadioButton("Female");
        female.setBounds(230, 110, 85, 25);
        female.setFocusable(false);
        female.setFont(new Font("Tahoma", Font.BOLD, 14));
        super.add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        // Adding label for Job and dropdown menu
        JLabel job = new JLabel("JOB");
        job.setBounds(50, 150, 100, 25);
        job.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(job);

        String[] Jobs = {"Front Desk Clerks", "Porters", "House Keeping", "Chefs", "Kitchen Stuff", "Waiter", "Manager", "Accountant"};
        jobb = new JComboBox(Jobs);
        jobb.setBounds(150, 150, 250, 25);
        jobb.setBackground(Color.WHITE);
        super.add(jobb);

        // Adding textbox for NID
        JLabel nid = new JLabel("NID");
        nid.setBounds(50, 190, 100, 25);
        nid.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(nid);

        t_nid = new JTextField();
        t_nid.setBounds(150, 190, 250, 25);
        t_nid.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_nid);

        // Adding label for Salary and textbox
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(50, 230, 100, 25);
        salary.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(salary);

        t_salary = new JTextField();
        t_salary.setBounds(150, 230, 250, 25);
        t_salary.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_salary);

        // Adding label for phone and textbox
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(50, 270, 100, 25);
        phone.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(phone);

        t_phone = new JTextField();
        t_phone.setBounds(150, 270, 250, 25);
        t_phone.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_phone);

        // Adding label for email and textbox
        JLabel email = new JLabel("E-MAIL");
        email.setBounds(50, 310, 100, 25);
        email.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(email);

        t_email = new JTextField();
        t_email.setBounds(150, 310, 250, 25);
        t_email.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_email);

        // Adding submit button
        submit = new JButton("Submit");
        submit.setBounds(180, 360, 90, 30);
        submit.setFocusable(false);
        submit.addActionListener(this);
        super.add(submit);

        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = t_name.getText();
        String age = t_age.getText();
        double salary=0;
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        try {
            salary = Double.parseDouble(t_salary.getText());
        }
        catch (NumberFormatException ae) {
            JOptionPane.showMessageDialog(null, "Please enter a valid salary!", "Error", JOptionPane.ERROR_MESSAGE);
            t_salary.requestFocus();
            return;
        }
        String nid = t_nid.getText();
        String phone = t_phone.getText();
        String email = t_email.getText();

        String job = (String) jobb.getSelectedItem();

        if (name.isEmpty() || age.isEmpty() || nid.isEmpty() || phone.isEmpty() || email.isEmpty() || gender == null) {
            JOptionPane.showMessageDialog(null, "Please fill out all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = new EmployeeDetails();
                employee[i].setEmployeeData(name, age, gender, job, nid, salary, phone, email);
                JOptionPane.showMessageDialog(null, "Employee added successfully!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
