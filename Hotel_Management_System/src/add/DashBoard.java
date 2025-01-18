package add;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener {
    JMenuItem addEmployee,addRoom,addReciption;
    public DashBoard(){
        super.setSize(1280,720);
        super.setLocation(150,50);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        ImageIcon icon=new ImageIcon("E:\\Ownproject\\Java Project\\Hotel_Management_System\\img\\Icon.png");//Icon
        ImageIcon dashboard_image=new ImageIcon("E:\\Ownproject\\Java Project\\Hotel_Management_System\\img\\dashboard.png");//dashboard background
        Image D_image1=dashboard_image.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon D_image2=new ImageIcon(D_image1);
        JLabel d_image=new JLabel(D_image2);
        d_image.setBounds(0,0,1280,720);
        super.setIconImage(icon.getImage());//adding icon
        super.add(d_image);
        super.setTitle("Dashboard");

        //adding a welcome text message
        JLabel welcome_TEXT=new JLabel("Welcome");
        welcome_TEXT.setBounds(420,30,400,90);
        welcome_TEXT.setFont(new Font("Serif",Font.BOLD,100));
        welcome_TEXT.setForeground(Color.BLACK);
        d_image.add(welcome_TEXT);

        //creating a menubar
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1280,25);
        d_image.add(mb);
        //adding menu
        JMenu menu1=new JMenu("HOTEL MANAGEMENT");
        menu1.setForeground(Color.BLUE);
        mb.add(menu1);
        //adding menu Item for menu1
        addReciption=new JMenuItem("Reciption");
        menu1.add(addReciption);

        JMenu menu2=new JMenu("ADMIN");
        menu2.setForeground(Color.RED);
        mb.add(menu2);
        //adding menu item for menu2

        addRoom=new JMenuItem("Add Room");
        menu2.add(addRoom);

        addEmployee=new JMenuItem("Add Employee");
        addEmployee.addActionListener(this);
        menu2.add(addEmployee);

        super.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addEmployee){
            new AddEmployee();

        }
    }

    public static void main(String[] args) {
        new DashBoard();
    }
}
