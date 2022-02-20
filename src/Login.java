
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame1 = new Login();
					frame1.setVisible(true);
					frame1.setLocationRelativeTo(null);  // Fait apparaître la fenêtre au centre du premier affichage
					frame1.setResizable(false); //frame size fixed


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Gestion des donneurs de sang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Nom d'utilisateur");
		lblUser.setBounds(110, 58, 140, 13);
		contentPane.add(lblUser);
		
		//Nom d'utilisateur
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(110, 74, 220, 19);
		contentPane.add(txtUser);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setBounds(110, 114, 140, 13);
		contentPane.add(lblPassword);
		
		//Mot de passe de l'utilisateur
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(110, 129, 220, 19);
		contentPane.add(txtPassword);
		
		//Annuler la connexion
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int z = JOptionPane.showConfirmDialog(null, "Quitter l'application", "", JOptionPane.YES_NO_OPTION);
                //si l'utilisateur select "oui" donc la valeur ==0, férmer l'application
                if(z==0 )
                	System.exit(0);			
			}
		});
		btnAnnuler.setBounds(110, 190, 97, 21);
		contentPane.add(btnAnnuler);
		
		//Valider la connexion
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Valider la connexion: user---> INSSET  mot de passe---> INSSET
				if( txtUser.getText().equals("INSSET") && txtPassword.getText().equals("INSSET")) {
			         Acceuil Acceuil = new Acceuil();
			         Acceuil.setVisible(true);
			         dispose();
				}else{
					        JOptionPane.showMessageDialog(null, " Le nom d'utilisateur ou le mot de passe est incorrect ");
					    }
			}
		});
		btnConnexion.setBounds(234, 190, 97, 21);
		contentPane.add(btnConnexion);
	}
}
