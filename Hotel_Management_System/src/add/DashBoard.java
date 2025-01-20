package add;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener{
    public HotelManagementSystem(){
		//frame creating
        //basic background setting
        super.setSize(1280,720);
        super.setLocation(150,50);
        super.setLayout(null);
        ImageIcon icon=new ImageIcon("E:\\Ownproject\\Java Project\\Hotel_Management_System\\img\\Icon.png");//Icon
        ImageIcon image_background=new ImageIcon("E:\\Ownproject\\Java Project\\Hotel_Management_System\\img\\Background.png");//image for background
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setIconImage(icon.getImage());
        super.setTitle("American International Hotel Service");//adding title for the project
        JLabel L_Background=new JLabel(image_background);//label1 for adding image on background
        L_Background.setBounds(0,0,1280,720);
        super.add(L_Background);
        //adding a panel for title name
        JPanel t_bg=new JPanel();
        t_bg.setBounds(120,10,1000,80);
        t_bg.setBackground(Color.WHITE);
        L_Background.add(t_bg);
        //adding another label
        JLabel L_Title=new JLabel("American International Hotel-Bangladesh");
        L_Title.setBounds(110,0,1000,80);
        L_Title.setForeground(Color.BLACK);
        L_Title.setFont(new Font("Serif", Font.BOLD, 50));
        L_Title.setBackground(Color.BLACK);
        t_bg.add(L_Title);
     
         //Button adding for entering the next page
        JButton next_button=new JButton("NEXT");
        next_button.setBounds(1000,600,150,50);
        next_button.setFocusable(false);
        L_Background.add(next_button);
        next_button.setForeground(Color.BLACK);
        next_button.setBackground(Color.white);
        next_button.setFont(new Font("Serif", Font.BOLD, 15));
        next_button.addActionListener(this);

        super.setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
       super.setVisible(false);
	   new Login();
    }

    public static void main(String[] args) {
      new HotelManagementSystem();
    }
}
