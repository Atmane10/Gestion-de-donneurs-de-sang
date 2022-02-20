import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Acceuil extends JFrame {
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Acceuil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 378, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Donneur");
		menuBar.add(mnNewMenu);
		
		//Ajouter un donneur
		JMenuItem mntmNewMenuItem = new JMenuItem("Ajouter un Donneur");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterDonneur().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		//Modifier un donneur
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modifier un Donneur");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifierDonneur().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		//Modifierun Donneur
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Supprimer un Donneur");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupprimerDonneur().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_8);
		
		//Liste des donneurs
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Liste des donneurs");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListeDonneur().setVisible(true);
			}
		});	
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Chercher un donneur");
		menuBar.add(mnNewMenu_1);
		
		//Chercher donneur selon la ville
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Selon la ville");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Ville().setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		//Chercher un donneur selon le goupeSanguin
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Selon le groupe sanguin ");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Groupe().setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		

		JMenu mnNewMenu_3 = new JMenu("Stock");
		menuBar.add(mnNewMenu_3);
		
		//Affichier le stock
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Afichier le stock");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Stock().setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Se d\u00E9connecter");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Confirmation pour Se déconnecter
				int z = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment vous déconnecter", "", JOptionPane.YES_NO_OPTION);
				if(z==0) {
					setVisible(false);
					new Login().setVisible(true);
					}
				}
		});
		
		JMenu mnNewMenu_4 = new JMenu("Quitter");
		menuBar.add(mnNewMenu_4);
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		//Quitter l'application
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Quitter l'application");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Confirmation pour Quitter l'application
				int z = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter l'application", "", JOptionPane.YES_NO_OPTION);
				if(z==0) {
					System.exit(0);
			}}
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Acceuil.class.getResource("/images/ww.jpg"))); //image d'acceuil
		lblNewLabel.setBounds(0, 0, 996, 563);
		contentPane.add(lblNewLabel);
	}
}