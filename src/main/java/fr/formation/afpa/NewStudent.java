package fr.formation.afpa;

import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fr.formation.afpa.model.Etudiant;
import fr.formation.afpa.service.EtudiantService;
import fr.formation.afpa.service.IEtudiantService;
import javafx.application.Application;
import javafx.stage.Stage;

public class NewStudent extends Application {

	private JFrame frmAjouterEtudiant;
	private final JLabel lblNewLabel = new JLabel("Nom");
	private JTextField tDate;
	private JTextField tNom;
	private JTextField tPrenom;
	private IEtudiantService service = new EtudiantService();
	private JTable table;
	private JTextField tPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudent window = new NewStudent();
					window.frmAjouterEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public NewStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjouterEtudiant = new JFrame();
		frmAjouterEtudiant.setTitle("Ajouter Etudiant");
		frmAjouterEtudiant.setBounds(100, 100, 450, 300);
		frmAjouterEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjouterEtudiant.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 214);
		frmAjouterEtudiant.getContentPane().add(panel);
		panel.setVisible(false);

		JLabel lblPrnom = new JLabel("Prénom");

		tPrenom = new JTextField();
		tPrenom.setColumns(10);

		tNom = new JTextField();
		tNom.setColumns(10);

		JLabel lblDateNais = new JLabel("Date de naissance");

		tDate = new JTextField();
		tDate.setColumns(10);
		
		JLabel lblPhoto = new JLabel("photo");
		
		tPhoto = new JTextField();
		tPhoto.setColumns(10);
		
		//Liste des boutons
		JButton btnBrowser = new JButton("Parcourir");
		JButton btnSave = new JButton("Enregistrer");
		JButton btnModif = new JButton("Modifier");
		JButton btnAnnul = new JButton("Annuler");
		JButton btnRetour = new JButton("Retour");
		
		
		btnBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser dialogue = new JFileChooser(".");
				PrintWriter sortie = null;
				File fichier;

				if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					fichier = dialogue.getSelectedFile();
					try {
						sortie = new PrintWriter(new FileWriter(fichier.getPath(), true));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					tPhoto.setText(fichier.getPath());

					sortie.close();
				}
			}
		});


		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(3)
					.addComponent(lblPrnom)
					.addGap(5)
					.addComponent(tPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(tNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblDateNais))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addComponent(tDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblPhoto)
					.addGap(5)
					.addComponent(tPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(btnBrowser))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addComponent(btnSave)
					.addGap(5)
					.addComponent(btnModif)
					.addGap(5)
					.addComponent(btnAnnul)
					.addGap(5)
					.addComponent(btnRetour))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPrnom))
						.addComponent(tPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(tNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDateNais)))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(tDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPhoto))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(tPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBrowser))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSave)
						.addComponent(btnModif)
						.addComponent(btnAnnul)
						.addComponent(btnRetour)))
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 432, 214);
		frmAjouterEtudiant.getContentPane().add(panel_1);
		panel_1.setVisible(false);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Prenom", "nom", "Date de naissance", "photo" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		panel_1.add(table);

		JMenuBar menuBar_1 = new JMenuBar();
		frmAjouterEtudiant.setJMenuBar(menuBar_1);
		JMenu mnNewMenu = new JMenu("Etudiant");
		menuBar_1.add(mnNewMenu);

		JMenuItem menuAdd = new JMenuItem("Ajouter");
		menuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				btnModif.setVisible(false);
				panel_1.setVisible(false);
				btnSave.setVisible(true);
				btnModif.setVisible(false);
				btnBrowser.setVisible(true);
				tNom.setText("");
				tPrenom.setText("");
				tDate.setText("");
			}
		});
		mnNewMenu.add(menuAdd);

		JMenuItem menuAffiche = new JMenuItem("Afficher");
		menuAffiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);

				panel_1.setVisible(true);
				tNom.setText("");
				tPrenom.setText("");
				tDate.setText("");
				service.listEtudiant();

			}
		});
		mnNewMenu.add(menuAffiche);

		JMenuItem menuModif = new JMenuItem("Modifier");
		menuModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				btnSave.setVisible(false);
				btnModif.setVisible(true);
				btnBrowser.setVisible(false);
				tPrenom.setEditable(false);
				tNom.setEditable(false);
				tDate.setEditable(false);
				tPhoto.setEditable(false);
			}
		});
		mnNewMenu.add(menuModif);

		btnModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				btnSave.setVisible(true);
				btnModif.setVisible(false);
				btnBrowser.setVisible(true);
				tPrenom.setEditable(true);
				tNom.setEditable(true);
				tDate.setEditable(true);
				tPhoto.setEditable(true);
				
			}
		});
		
		btnAnnul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.List<Etudiant> student = new ArrayList<Etudiant>();
				student = service.listEtudiant();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Etudiant student = new Etudiant(tNom.getText(), tPrenom.getText(), tDate.getText());
				service.ajouterEtudiant(student);
				tNom.setText("");
				tPrenom.setText("");
				tDate.setText("");
			}
		});

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
}
