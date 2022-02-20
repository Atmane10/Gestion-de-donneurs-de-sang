import java.sql.*;
import Projet.connectionProvider;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class SupprimerDonneur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAge;
	private JTextField txtTelephonePortable;
	private JTextField txtEmail;
	private JTextField txtVille;

	/**
	 * Create the frame.
	 */
	public SupprimerDonneur() {			
	setTitle("Gestion des donneurs de sang");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 490, 601);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblNewLabel = new JLabel("Supprimer un Donneur");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel.setBounds(166, 42, 172, 19);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Num\u00E9ro du donneur");
	lblNewLabel_1.setForeground(new Color(128, 0, 0));
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblNewLabel_1.setBounds(73, 80, 138, 13);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Nom du donneur");
	lblNewLabel_2.setBounds(73, 150, 138, 13);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Pr\u00E9nom du donneur");
	lblNewLabel_3.setBounds(73, 190, 138, 13);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_9 = new JLabel("\u00C2ge");
	lblNewLabel_9.setBounds(73, 430, 138, 19);
	contentPane.add(lblNewLabel_9);
	
	JLabel lblNewLabel_4 = new JLabel("Genre");
	lblNewLabel_4.setBounds(73, 230, 138, 13);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_6 = new JLabel("T\u00E9lephone portable");
	lblNewLabel_6.setBounds(73, 310, 138, 13);
	contentPane.add(lblNewLabel_6);
	
	JLabel lblNewLabel_7 = new JLabel("Email");
	lblNewLabel_7.setBounds(73, 350, 138, 13);
	contentPane.add(lblNewLabel_7);
	
	JLabel lblNewLabel_8 = new JLabel("Ville");
	lblNewLabel_8.setBounds(73, 390, 138, 13);
	contentPane.add(lblNewLabel_8);
	
	JLabel lblNewLabel_5 = new JLabel("Groupe sanguin");
	lblNewLabel_5.setBounds(73, 270, 138, 13);
	contentPane.add(lblNewLabel_5);
	
	//Numéro du donneur
	txtNumero = new JTextField();
	txtNumero.setBounds(203, 77, 61, 19);
	contentPane.add(txtNumero);
	txtNumero.setColumns(10);
	
	//Nom du donneur
	txtNom = new JTextField();
	txtNom.setColumns(10);
	txtNom.setBounds(232, 150, 162, 19);
	contentPane.add(txtNom);
	
	//Prénom du donneur
	txtPrenom = new JTextField();
	txtPrenom.setColumns(10);
	txtPrenom.setBounds(232, 190, 162, 19);
	contentPane.add(txtPrenom);
	
	//Age du donneur
	txtAge = new JTextField();
	txtAge.setColumns(10);
	txtAge.setBounds(232, 430, 162, 19);
	contentPane.add(txtAge);
	
	//Numéro de télephone du donneur 
	txtTelephonePortable = new JTextField();
	txtTelephonePortable.setColumns(10);
	txtTelephonePortable.setBounds(232, 310, 162, 19);
	contentPane.add(txtTelephonePortable);
	
	//Email du donneur
	txtEmail = new JTextField();
	txtEmail.setColumns(10);
	txtEmail.setBounds(232, 350, 162, 19);
	contentPane.add(txtEmail);
	
	//Ville du donneur
	txtVille = new JTextField();
	txtVille.setColumns(10);
	txtVille.setBounds(232, 390, 162, 19);
	contentPane.add(txtVille);
	
	
	JComboBox<?> comboBoxGroupeSanguin = new JComboBox();
	comboBoxGroupeSanguin.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
	comboBoxGroupeSanguin.setBounds(232, 270, 162, 21);
	contentPane.add(comboBoxGroupeSanguin);
	
	JComboBox<?> comboBoxGenre = new JComboBox();
	comboBoxGenre.setModel(new DefaultComboBoxModel(new String[] {"F\u00E9minin", "Masculin"}));
	comboBoxGenre.setBounds(232, 230, 162, 21);
	contentPane.add(comboBoxGenre);
	
	// Supprimer un donneur  
	JButton btnNewButton = new JButton("Supprimer");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String numeroDonneur = txtNumero.getText();
			// Supprimer les données dans db
			try {
				Connection con = connectionProvider.getCon();
				Statement s =con.createStatement();
				s.executeUpdate("delete from donneur where numeroDonneur='"+numeroDonneur+"'");
				JOptionPane.showMessageDialog(null, "Supprimer avec succès");
				setVisible(false);
				new SupprimerDonneur().setVisible(true);
			}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, "Erreur de connection");
			}		
		}
	});
	
	btnNewButton.setBounds(63, 497, 110, 21);
	contentPane.add(btnNewButton);
	
	JButton btnAnnuler = new JButton("Annuler");
	btnAnnuler.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Annuler l'ajout d'un donneur
			setVisible(false);
		}
	});
	btnAnnuler.setBounds(294, 497, 110, 21);
	contentPane.add(btnAnnuler);
	
	JButton btnRinitialiser = new JButton("R\u00E9initialiser");
	btnRinitialiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//réinitialiser
			setVisible(false);
			new SupprimerDonneur().setVisible(true);
		}
	});
	btnRinitialiser.setBounds(178, 497, 110, 21);
	contentPane.add(btnRinitialiser);
	
	// Chercher numeroDonneur dans la base de donner et affichier les champs
	JButton btnNewButton_1 = new JButton("Chercher");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String numeroDonneur = txtNumero.getText();
			try {
				Connection con = connectionProvider.getCon();
				Statement s =con.createStatement();
				ResultSet r =s.executeQuery("select *from Donneur where numeroDonneur='"+numeroDonneur+"'");
				if(r.next()) {
					txtNom.setText(r.getString(2));
					txtPrenom.setText(r.getString(3));
					comboBoxGenre.getEditor().setItem(r.getString(4));
					comboBoxGroupeSanguin.getEditor().setItem(r.getString(5));						
					txtTelephonePortable.setText(r.getString(6));
					txtEmail.setText(r.getString(7));
					txtVille.setText(r.getString(8));
					txtAge.setText(r.getString(9));
		
				}else
			        JOptionPane.showMessageDialog(null, " Ce numéro n'exixte pas !");
			    }
			 catch (Exception er) {
				er.printStackTrace();
			}
		
	}});
	btnNewButton_1.setForeground(new Color(128, 0, 0));
	btnNewButton_1.setBounds(294, 76, 100, 21);
	contentPane.add(btnNewButton_1);
}
}