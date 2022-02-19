import java.awt.EventQueue;
import java.sql.*;
import Projet.connectionProvider;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.Color;

@SuppressWarnings("serial")
public class AjouterDonneur extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAge;
	private JTextField txtTelephonePortable;
	private JTextField txtEmail;
	private JTextField txtVille;
	public String filename;
	private JLabel url;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterDonneur frame3 = new AjouterDonneur();
					frame3.setUndecorated(true); // Supprimer la barre de titre
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AjouterDonneur() { 
		setTitle("Gestion des donneurs de sang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Ajouter un nouveau donneur");
		lblNewLabel.setBounds(127, 43, 223, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Num\u00E9ro du donneur");
		lblNewLabel_1.setBounds(73, 110, 138, 13);
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
		
		txtNumero = new JTextField();
		txtNumero.setBounds(232, 107, 162, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		/*txtNumero.addComponentListener(new ComponentAdapter() {
			public void formcomponentShown(ComponentEvent ee) {
				
				try {
					// Enregistrer les données dans db
					Connection con = connectionProvider.getCon();
					Statement s =con.createStatement();
					ResultSet r =s.executeQuery("Select max (numeroDonneur) from donneur");
					if(r.first()) {
						int i = r.getInt(1);
						i = i+1;
						String a = String.valueOf(i);
						txtNumero.setText(a);
						
					}else 
					txtNumero.setText("1");
					}
					catch(Exception ee1) 
					{
						JOptionPane.showMessageDialog(null, ee1);
						}
			}}
			
		);*/

		txtNom = new JTextField();
		txtNom.setBounds(232, 150, 162, 19);
		txtNom.setColumns(10);
		contentPane.add(txtNom);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(232, 190, 162, 19);
		txtPrenom.setColumns(10);
		contentPane.add(txtPrenom);
		
		txtAge = new JTextField();
		txtAge.setBounds(232, 430, 162, 19);
		txtAge.setColumns(10);
		contentPane.add(txtAge);
		
		txtTelephonePortable = new JTextField();
		txtTelephonePortable.setBounds(232, 310, 162, 19);
		txtTelephonePortable.setColumns(10);
		contentPane.add(txtTelephonePortable);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(232, 350, 162, 19);
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);
		
		txtVille = new JTextField();
		txtVille.setBounds(232, 390, 162, 19);
		txtVille.setColumns(10);
		contentPane.add(txtVille);
		
		JComboBox<?> comboBoxGroupeSanguin = new JComboBox();
		comboBoxGroupeSanguin.setBounds(232, 270, 162, 21);
		comboBoxGroupeSanguin.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		contentPane.add(comboBoxGroupeSanguin);
		
		JComboBox<?> comboBoxGenre = new JComboBox();
		comboBoxGenre.setBounds(232, 230, 162, 21);
		comboBoxGenre.setModel(new DefaultComboBoxModel(new String[] {"F\u00E9minin", "Masculin", "Autre"}));
		contentPane.add(comboBoxGenre);
		
		//Button pour choisir la photo
				JButton btnImage = new JButton("Photo");
				btnImage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Ajouter une photo

						JFileChooser chooser = new JFileChooser();
						chooser.showOpenDialog(null);
						File f=chooser.getSelectedFile();
						filename=f.getAbsolutePath();
						url.setText(filename);
						@SuppressWarnings("unused")
						Image getabsolutePath=null;
						ImageIcon icon = new ImageIcon(filename);
						//Image image =icon.getImage().getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(),Image.SCALE_SMOOTH);
						//labelPhoto .setIcon(icon);

					}
				});
				btnImage.setBackground(Color.WHITE);
				btnImage.setBounds(63, 466, 110, 21);
				contentPane.add(btnImage);
				
				// url de la photo télecharger
				url = new JLabel("");
				url.setBounds(232, 466, 162, 21);
				contentPane.add(url);
		
		JButton btnNewButton = new JButton("Sauvegarder");
		btnNewButton.setBounds(63, 497, 110, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroDonneur = txtNumero.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String age = txtAge.getText();
				String telephonePortable = txtTelephonePortable.getText();
				String email = txtEmail.getText();
				String ville = txtVille.getText();
				String genre = (String)comboBoxGenre.getSelectedItem();
				String groupeSanguin = (String)comboBoxGroupeSanguin.getSelectedItem();
				String image = url.getText();
				//image = image.replace("\\", "\\\\");
				//System.out.println(image);
				
				// Enregistrer les données dans db
				try {
					Connection con = connectionProvider.getCon();
					Statement s =con.createStatement();
					s.executeUpdate("insert into donneur values('"+numeroDonneur+"','"+nom+"','"+prenom+"','"+genre+"','"+groupeSanguin+"','"+telephonePortable+"','"+email+"','"+ville+"','"+age+"','"+image+"')");
					JOptionPane.showMessageDialog(null, "Mise à jour réussie");
					setVisible(false);
					new AjouterDonneur().setVisible(true);
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}


				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(294, 497, 110, 21);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Annuler l'ajout d'un donneur
				setVisible(false);
			}
		});
		contentPane.add(btnAnnuler);
		
		JButton btnRinitialiser = new JButton("R\u00E9initialiser");
		btnRinitialiser.setBounds(178, 497, 110, 21);
		btnRinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//réinitialiser
				setVisible(false);
				new AjouterDonneur().setVisible(true);

			}
		});
		contentPane.add(btnRinitialiser);
		
		
		
		
		//button to browse the image into jlabel
		/*JButton btnImage = new JButton("Photo");
		btnImage.addActionListener(new ActionListener(){
	        @Override
	     public void actionPerformed(ActionEvent e){
	         JFileChooser fileChooser = new JFileChooser();
	         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
	         fileChooser.addChoosableFileFilter(filter);
	         int result = fileChooser.showSaveDialog(null);
	         if(result == JFileChooser.APPROVE_OPTION){
	             File selectedFile = fileChooser.getSelectedFile();
	             String path = selectedFile.getAbsolutePath();
	             //label.setIcon(ResizeImage(path));
	             //s = path;
	              }
	         else if(result == JFileChooser.CANCEL_OPTION){
	             System.out.println("No Data");
	         }
	     }
	    });*/
		
		
		

	}
}
