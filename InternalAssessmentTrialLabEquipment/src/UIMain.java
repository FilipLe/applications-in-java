import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


/*
 * Main Screen
 */
public class UIMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMain window = new UIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Equipment Management System");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		 * Take user to Admin Login
		 */
		JButton adminLoginButton = new JButton("Admin");
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close window
				frame.dispose();
				//take to admin login window
				AdminLogin.main(null);
			}
		});
		adminLoginButton.setBounds(110, 51, 229, 75);
		frame.getContentPane().add(adminLoginButton);
		
		/*
		 * Take user to Teacher Login
		 */
		JButton teacherLoginButton = new JButton("Teacher");
		teacherLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close window
				frame.dispose();
				//Launch Teacher Login Window
				TeacherLogin.main(null);
			}
		});
		teacherLoginButton.setBounds(110, 148, 229, 75);
		frame.getContentPane().add(teacherLoginButton);
		
		//Button to quit the application
		JButton btnQuit = new JButton("Quit Program");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close window
				frame.dispose();
			}
		});
		btnQuit.setBounds(327, 237, 117, 29);
		frame.getContentPane().add(btnQuit);
		
		JLabel lblPleaseSelectUser = new JLabel("Please select a user:");
		lblPleaseSelectUser.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lblPleaseSelectUser.setBounds(29, 23, 241, 16);
		frame.getContentPane().add(lblPleaseSelectUser);
		
	}
}
