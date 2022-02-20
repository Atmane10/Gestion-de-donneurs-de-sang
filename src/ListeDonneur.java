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

@SuppressWarnings("serial")
public class ListeDonneur extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	
	/**
	 * Create the frame.
	 */
	public ListeDonneur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listes des donneurs");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(402, 45, 202, 33);
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
		
		//Cr�ation de la table
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] column = {"numéro du donneur","Nom","Prénom","Genre","Groupe sanguin","Télephone portable","Email","Ville","Age"};
		@SuppressWarnings("unused")
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
			
		//Affichier la liste des donneurs
		JButton btnAffichier = new JButton("Affichier");
		btnAffichier.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {				
				try {
					Connection con = connectionProvider.getCon();
					Statement st =con.createStatement();
					ResultSet rs =st.executeQuery("select *from donneur");
					table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				catch(Exception eee) 
				{
				JOptionPane.showMessageDialog(null, eee);
				}
		}});
		btnAffichier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAffichier.setBounds(605, 45, 122, 25);
		contentPane.add(btnAffichier);	
	}
}
