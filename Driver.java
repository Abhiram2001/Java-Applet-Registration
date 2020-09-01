package sejdbc;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// <Appletcode="SE" width=500 height=500></applet>
public class Driver extends Applet implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//Required Initalization or variables
    
    Label h1,h2,h3,h4,sl1,sl2,sl3,sl4,sl5,sl6,vr1,vr2,vr3,vr4,vr5,vr6,nsl3,nsl4,nsl5,nsl6;
    Checkbox c1,c2,c3,c4,c5,nc1,nc2,nc3,nc4,nc5;
    CheckboxGroup cg,ncg;
    Choice ch,nch;
    TextField st1,st2,st3,rt1,rt2,rt3,rt4,rt5,rt6,nst3;
    Font f1,f2,f3;
    Button b, u , d, v, r;
    Color c;

    String sql="",task="";
    String name ="",number="",nation="",gender="",intrest="",reason="";
    String nname ="",nnumber="",nnation="",ngender="",nintrest="",nreason="";
    String[] darray = new String[20];
    Connection myConn;
    
    int count = 0;
    // Assigning Variables

    
    public void init()
    {


        try
        {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
		}
        catch(Exception e)
        {
			e.printStackTrace();
		}

        f1 = new Font("Serif",Font.BOLD,50);
	    f2 = new Font("Arial",Font.BOLD,20);
        f3 = new Font("Arial",Font.BOLD,15);
        c = new Color(211,211,101);

        b = new Button("Submit");
        b.addActionListener(this);
        
        v = new Button("Verify");
        v.addActionListener(this);

        u = new Button("Update");
        u.addActionListener(this);

        d = new Button("Delete");
        d.addActionListener(this);
        
        r = new Button("All");
        r.addActionListener(this);
    
        h1  = new Label("Student Registration");
        h2  = new Label("Enter the Details");
        h3  = new Label("Verify Your details");
        h4  = new Label("Details In Database");

        sl1 = new Label("Number: ");
        st1 = new TextField(10);
        
        sl2 = new Label("Name: ");
        st2 = new TextField(10);
        
        sl3 = new Label("Gender: ");
        ch = new Choice();
        ch.add("Male");
	    ch.add("Female");
	    ch.add("Transgender");

        sl4 = new Label("Nationality: ");
        cg = new CheckboxGroup();
        c1 = new Checkbox("Indian",true, cg);
	    c2 = new Checkbox("Other",cg, false);

        sl5 = new Label("Area of Intrest: ");
        c3 = new Checkbox("CSC");
	    c4 = new Checkbox("CSE");
        c5 = new Checkbox("ECE");
        
        sl6 = new Label("Reasons for Selecting:");
        st3 = new TextField(100);


        rt1 = new TextField(20);
        rt2 = new TextField(20);
        rt3 = new TextField(20);
        rt4 = new TextField(20);
        rt5 = new TextField(20);
        rt6 = new TextField(20);

        
        
        vr1 = new Label("NUMBER");
        vr2 = new Label("NAME");
        vr3 = new Label("GENDER");
        vr4 = new Label("NATIONALITY");
        vr5 = new Label("INTREST");
        vr6 = new Label("REASON");


        nsl3 = new Label("Gender: ");
        nch = new Choice();
        nch.add("Male");
	    nch.add("Female");
	    nch.add("Transgender");

        nsl4 = new Label("Nationality: ");
        ncg = new CheckboxGroup();
        nc1 = new Checkbox("Indian",true, ncg);
	    nc2 = new Checkbox("Other", ncg, false);

        nsl5 = new Label("Area of Intrest: ");
        nc3 = new Checkbox("CSC");
	    nc4 = new Checkbox("CSE");
        nc5 = new Checkbox("ECE");
        
        nsl6 = new Label("Reasons for Selecting:");
        nst3 = new TextField(100);



        setBackground(c);
        h1.setFont(f1);
        h2.setFont(f1);
        sl1.setFont(f2);
        sl2.setFont(f2);
        sl3.setFont(f2);
        sl4.setFont(f2);
        sl5.setFont(f2);
        sl6.setFont(f2);
        
        h3.setFont(f1);
        h4.setFont(f1);
        vr1.setFont(f3);
        vr2.setFont(f3);
        vr3.setFont(f3);
        vr4.setFont(f3);
        vr5.setFont(f3);
        vr6.setFont(f3);
        setLayout(null);


        h1.setBounds(760,40,450,100);
        h2.setBounds(120,150,450,100);
        sl1.setBounds(50,350,150,50);st1.setBounds(260,362,200,25);
        sl2.setBounds(50,400,150,50);st2.setBounds(260,412,200,25);
        sl3.setBounds(50,450,150,50);ch.setBounds(260,465,200,50);
        sl4.setBounds(50,500,150,50);c1.setBounds(260,500,60,50);c2.setBounds(320,500,60,50);
        sl5.setBounds(50,550,150,50);c3.setBounds(260,550,60,50);c4.setBounds(320,550,60,50);c5.setBounds(380,550,60,50);
        sl6.setBounds(50,600,220,50);st3.setBounds(290,615,360,150);
        b.setBounds(220,900,100,50);


        h3.setBounds(820,150,450,100);
        vr1.setBounds(700,350,100,50);rt1.setBounds(800,362,200,25);v.setBounds(1100,375,200,50);
        vr2.setBounds(700,400,100,50);rt2.setBounds(800,412,200,25);
        vr3.setBounds(700,450,100,50);rt3.setBounds(800,462,200,25);
        vr4.setBounds(700,500,100,50);rt4.setBounds(800,512,200,25);
        vr5.setBounds(700,550,100,50);rt5.setBounds(800,562,200,25);
        vr6.setBounds(700,600,100,50);rt6.setBounds(800,615,250,100);


        nsl3.setBounds(1100,450,100,50);nch.setBounds(1250,465,200,50);
        nsl4.setBounds(1100,500,100,50);nc1.setBounds(1250,500,60,50);nc2.setBounds(1310,500,60,50);
        nsl5.setBounds(1100,550,100,50);nc3.setBounds(1250,550,60,50);nc4.setBounds(1310,550,60,50);nc5.setBounds(1370,550,60,50);
        nsl6.setBounds(1100,600,150,50);nst3.setBounds(1250,615,200,100);
        u.setBounds(900,900,100,50);
        d.setBounds(1200,900,100,50);


        h4.setBounds(1480,150,450,80);
        r.setBounds(1800,230,100,50);
        
        add(h1);
        add(h2);
        add(sl1);add(st1);
        add(sl2);add(st2);
        add(sl3);add(ch);
        add(sl4);add(c1);add(c2);
        add(sl5);add(c3);add(c4);add(c5);
        add(sl6);add(st3);
        add(b);

        add(h3);
        add(vr1);add(rt1);
        add(vr2);add(rt2);
        add(vr3);add(rt3);
        add(vr4);add(rt4);
        add(vr5);add(rt5);
        add(vr6);add(rt6);



        add(nsl3);add(nch);
        add(nsl4);add(nc1);add(nc2);
        add(nsl5);add(nc3);add(nc4);add(nc5);
        add(nsl6);add(nst3);

        add(h4);
        add(v);
        add(r);
    }

    public void actionPerformed(ActionEvent e)
    {

        name = st2.getText();
    	number=st1.getText();
        nation = cg.getSelectedCheckbox().getLabel();
        gender= ch.getSelectedItem();
        if(c3.getState())
    		intrest= intrest+c3.getLabel()+" ";
		if(c4.getState())
			intrest= intrest+c4.getLabel()+" ";
		if(c5.getState())
			intrest= intrest+c5.getLabel()+" ";
        reason=st3.getText();
        


        nname =  rt2.getText();
    	nnumber= rt1.getText();
        nnation = ncg.getSelectedCheckbox().getLabel();
        ngender= nch.getSelectedItem();
        if(nc3.getState())
    		nintrest= nintrest+c3.getLabel()+" ";
		if(nc4.getState())
			nintrest= nintrest+c4.getLabel()+" ";
		if(nc5.getState())
			nintrest= nintrest+c5.getLabel()+" ";
        nreason=nst3.getText();


        if(e.getSource()==b) {
			try {
				repaint();
			    System.out.println("adding data to database");
                Statement mystmt = myConn.createStatement();
                
                task = "Add";
                sql = "insert into studentdetails"
                        + " (number,name,gender,nation,intrest,reason)"
                        + " values('"+number+"','"+name+"','"+gender+"','"+nation+"','"+intrest+"','"+reason+"')";
                mystmt.executeUpdate(sql);
                System.out.println("Done!!");
		    }
			catch(Exception ea) {
				ea.printStackTrace();
			}
        }
        
        if(e.getSource()==u) {
			try {
				repaint();
				System.out.println("updating data in database...");
				Statement mystmt = myConn.createStatement();
				task = "Update";
				sql = "update studentdetails "
						+ "set gender = '"+ngender+"',nation = '"+nnation+"',reason='"+nreason+"',intrest='"+nintrest+"'"
						+ " where number = '"+nnumber+"'  AND  name = '"+nname+"'";
				mystmt.executeUpdate(sql);
				System.out.println("Done!!");
			}
			catch(Exception ea) {
				ea.printStackTrace();
			}
        }

        if(e.getSource()==d) {
			try {
				repaint();
				System.out.println("Deleting data in database...");
				Statement mystmt = myConn.createStatement();
				task = "Delete";
				sql = "DELETE FROM studentdetails WHERE number='"+nnumber+"' AND name = '"+nname+"'";
				mystmt.executeUpdate(sql);
				System.out.println("Done!!");
			}
			catch(Exception ea) {
				ea.printStackTrace();
			}
		}
        
        if(e.getSource()==v) {
        	String result ="";
			try {
				repaint();
				System.out.println("Retreving data in database...");
				Statement mystmt = myConn.createStatement();
				task = "Retrieve";
				sql = "SELECT * FROM studentdetails WHERE number='"+nnumber+"' AND name = '"+nname+"'";
				ResultSet rs  = mystmt.executeQuery(sql);
				
				while(rs.next())
				{
					result = rs.getString("gender");
					rt3.setText(result);
					result = rs.getString("nation");
					rt4.setText(result);
					result = rs.getString("intrest");
					rt5.setText(result);
					result = rs.getString("reason");
					rt6.setText(result);
				}
				rs.close();
				
				System.out.println("Done!!");
				
			}
			catch(Exception ea) {
				ea.printStackTrace();
			}
		}
        
        if(e.getSource()==r) {
        	
			try {
				count = 0;
				repaint();
				System.out.println("Retreving data in database...");
				Statement mystmt = myConn.createStatement();
				task = "AllData";
				sql = "SELECT * FROM studentdetails";
				ResultSet rs  = mystmt.executeQuery(sql);
				
				if(rs.next()){ 
					do{
						darray[count]  = rs.getString(1)+",  "+rs.getString(2)+",  "+rs.getString(3)+",  "+rs.getString(4)+",  "+rs.getString(5);
					count++;
					}while(rs.next() && count<20);
				}
				else{
					System.out.println("Record Not Found...");
				}
				rs.close();
				
				System.out.println("Done!!");
				
			}
			catch(Exception ea) {
				ea.printStackTrace();
			}
		}
        
        if(task == "Retrieve") {
			add(u);
	        add(d);
		}
    }

    public void paint(Graphics g)
    {
        g.drawLine(1460, 145, 1460, 1000);
        g.drawLine(680, 145, 680, 1000);
        g.drawLine(50, 145, 1870, 145);
        if(task == "Add") {
			g.drawString("Data is Added to Database!", 1700, 25);
		}
		if(task == "Update") {
			g.drawString("Data is Updated in Database!", 1700, 25);
		}
		if(task == "Delete") {
			g.drawString("Data is Deleted in Database!", 1700, 25);
		}
		if(task == "AllData") {
			Font currentFont = g.getFont();
			g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
			g.drawString("Number|Name|Gender|Nationality|Intrest", 1500, 350);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
			for (int i = 0 ;i<count;i++)
			{
				g.drawString(darray[i], 1500, (390+(30*i)));
			}
			g.setFont(currentFont);
		}
    }
    
}