import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import Projet.connectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Ville extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ville frame = new Ville();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ville() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chercher un donneur selon la ville");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(97, 40, 319, 33);
		contentPane.add(lblNewLabel);
		
		//imprimer la liste des donneurs
		JButton btnNewButton = new JButton("Imprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					table.print(JTable.PrintMode.NORMAL);
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(337, 517, 122, 25);
		contentPane.add(btnNewButton);
		
		JButton btnQuiter = new JButton("Quiter");
		btnQuiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//quitter la vue de liste des donneur
				setVisible(false);
			}
		});
		btnQuiter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQuiter.setBounds(524, 517, 122, 25);
		contentPane.add(btnQuiter);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 963, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 943, 412);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] column = {"numéro du donneur","Nom","Prénom","Genre","Groupe sanguin","Télephone portable","Email","Ville","Age"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		
		//Affichier la liste des donneurs
		JButton btnAffichier = new JButton("Affichier");
		btnAffichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					/*try {
						Connection con = connectionProvider.getCon();
						Statement s =con.createStatement();
						s.executeUpdate("insert into donneur values('"+numeroDonneur+"','"+nom+"','"+prenom+"','"+genre+"','"+groupeSanguin+"','"+telephonePortable+"','"+email+"','"+ville+"','"+age+"')");
						JOptionPane.showMessageDialog(null, "Mise � jour r�ussie");
					*/
					Connection con = connectionProvider.getCon();
					Statement st =con.createStatement();
					ResultSet rs =st.executeQuery("select *from donneur");
					table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					//con.mysql.jdbc.GoogleDriver
					}
				catch(Exception eee) 
				{
				JOptionPane.showMessageDialog(null, eee);
				}
		}});
		btnAffichier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAffichier.setBounds(605, 45, 122, 25);
		contentPane.add(btnAffichier);
		
		//ins�rer la ville � chercher
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String location = textField.getText();
					try {					
					Connection con = connectionProvider.getCon();
					Statement st =con.createStatement();
					ResultSet rs =st.executeQuery("select *from donneur");
					table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					//con.mysql.jdbc.GoogleDriver
					}
				catch(Exception eee) 
				{
				JOptionPane.showMessageDialog(null, eee);
				}
			}
		});
		textField.setBounds(394, 46, 202, 23);
		contentPane.add(textField);
		textField.setColumns(10);

	
	}
}
