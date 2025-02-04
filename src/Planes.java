package src;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Planes extends JFrame implements ActionListener {
		JLabel l1,l2;
		JButton b1,b2,b3;
		JScrollPane js;
		JTable jt;
		static Point LP;
		int rowCount;
		String [] columnNames = {"ID", "Name", "Section"};
		String[][] data;
        // String [] columnNames = {"PLANEID", "STATUS", "YEAR" ,"MODELNAME","TYPE","BUYINGPRICE","RENTINGPRICE"};
    public Planes(){

		try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // register jdbc driver of mysql,Driver Registration
            //This line ensures that the MySQL JDBC driver is loaded and registered with the JDBC API. It allows your application to connect to the MySQL database.
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mubin", "root", ""); //Establishing a Connection
            //This line establishes a connection to the database named newdb running on localhost at the default MySQL port 3306.
            //DriverManager.getConnection() returns a Connection object which represents the session with the database.
            System.out.println("connected");//printing that database is connected
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Creating a scrollable Statement
			ResultSet rs = st.executeQuery("select * from student");//Executing the SQL Query

			rs.last();
			rowCount = rs.getRow();
			rs.beforeFirst();

            data = new String[rowCount][3];
            int i;
			for (i=0 ; rs.next(); i++) {//moves the cursor to the next row of the result set. If there are no more rows, it returns false, terminating the loop.
				System.out.println("ID=" + rs.getInt(1) );
                System.out.println("Name=" + rs.getString(2) );
                System.out.println("section=" + rs.getString(3) );

                for (int j = 0; j < 3; j++) {
					if(j==0){
						data[i][j] = String.valueOf(rs.getInt(j + 1));
                        continue;
					}
					data[i][j] = rs.getString(j + 1);
                }
            }
           // Connection.close(); //This line is commented out, which means the connection is not being closed after use. This could lead to resource leaks (open database connections that aren't cleaned up).
           //Ideally, you should close the connection after completing your operations. You can do this either by explicitly calling conn.close() or by using try-with-resources for automatic resource management.
        } catch (Exception s) {
            System.out.println(s);
        }

        ImageIcon image = new ImageIcon("image/Plane.png");
        l1 = new JLabel();

        this.setTitle("FLY HIGH");
		this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);

        l1.setIcon(image);

        l2 = new JLabel("Planes information");
        l2.setBounds(133, 47, 965, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 40));
		l2.setForeground(Color.decode("#424242"));
        l2.setHorizontalAlignment(JLabel.CENTER);
        l1.add(l2);

		jt = new JTable(data, columnNames);
		jt.setFont(new Font("Arial", Font.PLAIN, 15));


        js = new JScrollPane(jt);
        js.setOpaque(false);
		js.setFocusable(false);
        js.setBounds(40, 155, 1153, 526);
        js.setBorder(BorderFactory.createEmptyBorder());
        js.getViewport().setBackground(Color.white);
        l1.add(js);
		
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
