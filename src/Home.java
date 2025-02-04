package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
        JLabel l1,l2;
		JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10; 
		static Point LP;

    public Home(){

		
        ImageIcon image = new ImageIcon("image/Home.png");
        l1 = new JLabel();

        this.setTitle("FLY HIGH");
		this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);

        l1.setIcon(image);
		
		//Back Button
		b1 = new JButton();
		b1.setOpaque(false);
		b1.setFocusable(false);
		b1.setBackground(Color.white);
		b1.setBounds(1234,127,35,35);
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

        //Planes Button
        b4 = new JButton();
        b4.setOpaque(false);
        b4.setFocusable(false);
        b4.setBackground(Color.white);
        b4.setBounds(86,193,190,190);
        b4.setBorderPainted(false);
        b4.addActionListener(this);
        l1.add(b4);

        //Manufacturers Button
        b5 = new JButton();
        b5.setOpaque(false);
        b5.setFocusable(false);
        b5.setBackground(Color.white);
        b5.setBounds(376,193,190,190);
        b5.setBorderPainted(false);
        b5.addActionListener(this);
        l1.add(b5);

        //Maintenance Button
        b6 = new JButton();
        b6.setOpaque(false);
        b6.setFocusable(false);
        b6.setBackground(Color.white);
        b6.setBounds(666,193,190,190);
        b6.setBorderPainted(false);
        b6.addActionListener(this);
        l1.add(b6);

        //Pilots Button
        b7 = new JButton();
        b7.setOpaque(false);
        b7.setFocusable(false);
        b7.setBackground(Color.white);
        b7.setBounds(956,193,190,190);
        b7.setBorderPainted(false);
        b7.addActionListener(this);
        l1.add(b7);

        //Customers Button
        b8 = new JButton();
        b8.setOpaque(false);
        b8.setFocusable(false);
        b8.setBackground(Color.white);
        b8.setBounds(231,453,190,190);
        b8.setBorderPainted(false);
        b8.addActionListener(this);
        l1.add(b8);

        //CustomerNumber Button
        b9 = new JButton();
        b9.setOpaque(false);
        b9.setFocusable(false);
        b9.setBackground(Color.white);
        b9.setBounds(521,453,190,190);
        b9.setBorderPainted(false);
        b9.addActionListener(this);
        l1.add(b9);

        //Review Button
        b10 = new JButton();
        b10.setOpaque(false);
        b10.setFocusable(false);
        b10.setBackground(Color.white);
        b10.setBounds(811,453,190,190);
        b10.setBorderPainted(false);
        b10.addActionListener(this);
        l1.add(b10);


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

            if(ae.getSource()==b1) //back
			{
				LogIn f = new LogIn();
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
