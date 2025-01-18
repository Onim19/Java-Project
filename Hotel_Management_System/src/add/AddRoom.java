package add;
import add.details.RoomDetails;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {
    JTextField t_RoomNumber,t_price;
    JComboBox status,cleaning_status,bed_types;
    RoomDetails[]rooms;
    JButton submit;
    AddRoom(){
        rooms=new RoomDetails[100];
        super.getContentPane().setBackground(Color.white);
        super.setSize(800, 500); // Reduced frame height
        super.setLocation(400, 200);
        super.setLayout(null);
        ImageIcon icon=new ImageIcon("E:\\Ownproject\\Java Project\\Hotel_Management_System\\img\\Icon.png");//Icon
        super.setIconImage(icon.getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setTitle("ADD ROOM");

        //Adding label and textbox for Room number
        JLabel RoomNumber=new JLabel("ROOM NO");
        RoomNumber.setBounds(50,100,200,25);
        RoomNumber.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(RoomNumber);

        t_RoomNumber=new JTextField();
        t_RoomNumber.setBounds(220, 100, 150, 25);
        t_RoomNumber.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_RoomNumber);

        //adding label and dropdown combo box for availability
        JLabel Availability=new JLabel("AVAILABILITY");
        Availability.setBounds(50,150,200,25);
        Availability.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(Availability);

        String[]Status={"Available","Not-Available"};
        status=new JComboBox(Status);
        status.setBounds(220,150,150,25);
        status.setBackground(Color.WHITE);
        super.add(status);

        //adding cleaning status
        JLabel CleaningStatus=new JLabel("CLEANING STATUS");
        CleaningStatus.setBounds(50,200,200,25);
        CleaningStatus.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(CleaningStatus);

        String[]Cleaning_Status={"Cleaned","Dirty"};
        bed_types=new JComboBox(Cleaning_Status);
        bed_types.setBounds(220,200,150,25);
        bed_types.setBackground(Color.WHITE);
        super.add(bed_types);

        //adding label and text box for price
        JLabel price=new JLabel("PRICE");
        price.setBounds(50,250,200,25);
        price.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(price);

        t_price=new JTextField();
        t_price.setBounds(220, 250, 150, 25);
        t_price.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(t_price);

        //Adding BedType
        JLabel BedType=new JLabel("BED TYPE");
        BedType.setBounds(50,300,200,25);
        BedType.setFont(new Font("TimesRoman", Font.BOLD, 16));
        super.add(BedType);

        String[]Bed_Types={"Single","Double"};
        cleaning_status=new JComboBox(Bed_Types);
        cleaning_status.setBounds(220,300,150,25);
        cleaning_status.setBackground(Color.WHITE);
        super.add(cleaning_status);

        //adding a submit button
        submit = new JButton("Submit");
        submit.setBounds(220, 380, 90, 30);
        submit.setFocusable(false);
        submit.addActionListener(this);
        super.add(submit);

        super.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String roomNumber=t_RoomNumber.getText();
        double price=0;
        try {
            price = Double.parseDouble(t_price.getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid PRICE!", "Error", JOptionPane.ERROR_MESSAGE);
            t_price.requestFocus();
            return;
        }
        String Status=(String)status.getSelectedItem();
        String Cleaning_Status=(String)cleaning_status.getSelectedItem();
        String Bed_Types=(String)bed_types.getSelectedItem();
        if(roomNumber.isEmpty() || Status.isEmpty() || Cleaning_Status.isEmpty() || Bed_Types.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill out all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(int i=0;i<rooms.length;i++){
            if(rooms[i]==null){
                rooms[i]=new RoomDetails();
                rooms[i].setRoomDetails(roomNumber,Status,Cleaning_Status,price,Bed_Types);
                JOptionPane.showMessageDialog(null,"Room added successfully!");
                break;
            }
        }

    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
