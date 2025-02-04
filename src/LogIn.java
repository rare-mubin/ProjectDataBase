package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LogIn extends JFrame implements ActionListener {
        JLabel l1,l2;
		JButton b1,b2,b3; 
		static Point LP;

    public LogIn(){

		
        ImageIcon image = new ImageIcon("image/login_page.png");
        l1 = new JLabel();

        this.setTitle("FLY HIGH");
		this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);

        l1.setIcon(image);
		
		//Login Button
		b1 = new JButton();
		b1.setOpaque(false);
		b1.setFocusable(false);
		b1.setBackground(Color.white);
		b1.setBounds(1045,630,123,43);
		b1.setBorderPainted(false);
		b1.addActionListener(this);
		l1.add(b1);

		//Exit Button
		b2 = new JButton();
		b2.setOpaque(false);
		b2.setFocusable(false);
		b2.setBackground(Color.white);
		b2.setBounds(1234,11,35,35);
		b2.setBorderPainted(false);
		b2.addActionListener(this);
		l1.add(b2);

		//Minimize Button
		b3 = new JButton();
		b3.setOpaque(false);
		b3.setFocusable(false);
		b3.setBackground(Color.white);
		b3.setBounds(1234,51,35,35);
		b3.setBorderPainted(false);
		b3.addActionListener(this);
		l1.add(b3);

        //this.add(p1);
        this.add(l1);

		//__________________________________________________________________________________________________
        //dragable jframe
		LP = null;
		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				LP = null;
			}

			public void mousePressed(MouseEvent e) {
				LP = e.getPoint();
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
			}

			public void mouseDragged(MouseEvent e) 
			{
				Point currCoords = e.getLocationOnScreen();
				setLocation(currCoords.x - LP.x, currCoords.y - LP.y);
			}

			
		});
//__________________________________________________________________________________________________
	}

		public void actionPerformed(ActionEvent ae) 
		{

			if(ae.getSource()==b1) //Home
			{
				Home f = new Home();
				f.setVisible(true);
				this.setVisible(false);
			}

            if(ae.getSource()==b2) //exit
			{
				// this.setVisible(false);
				System.exit(0);
			}

			else if(ae.getSource()==b3) //minimize
			{
				this.setState(JFrame.ICONIFIED);
			}

		}
    
}
