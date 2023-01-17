package testUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import dao.etudiant;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class Ajout extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField sname;
	private JTable table;
	int l;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajout frame = new Ajout();
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
	public void refresh() {
		ResultSet rs = Select.sel();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		DbConn.fermer();
	}
	public Ajout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 96, 80, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPrenom.setBounds(10, 171, 80, 24);
		contentPane.add(lblPrenom);
		
		fname = new JTextField();
		fname.setBounds(104, 90, 147, 30);
		contentPane.add(fname);
		fname.setColumns(10);
		
		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(104, 165, 147, 30);
		contentPane.add(sname);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=fname.getText();
				String prenom=sname.getText();
				if(nom.equals("") || prenom.equals("")) {
					 JOptionPane.showMessageDialog(null,"veuillez saisor twichyat");  
				}else {
					dao.etudiant et=new dao.etudiant(nom,prenom);
					insert.inserer(et);
					fname.setText("");
					sname.setText("");
				}
			}
		});
		btnNewButton.setBounds(10, 267, 89, 24);
		contentPane.add(btnNewButton);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l = table.getSelectedRow();
			}
		});
		table.setBounds(332, 58, 376, 199);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion d'eleves");
		lblNewLabel_1.setBackground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(31, 11, 249, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("refresh");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnNewButton_1.setBounds(332, 19, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnSuprimer = new JButton("suprimer");
		btnSuprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(int) table.getModel().getValueAt(l, 0);
				Delete.del(id);
				refresh();				
			}
		});
		btnSuprimer.setBounds(110, 267, 89, 24);
		contentPane.add(btnSuprimer);
		
		JButton btnRechercher = new JButton("rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=fname.getText();
				String prenom=sname.getText();
				if(nom.equals("") || prenom.equals("")) {
					 JOptionPane.showMessageDialog(null,"veuillez saisor twichyat");  
				}else {
					dao.etudiant et=new dao.etudiant(nom,prenom);
					ResultSet rs = Select.sel(et);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					DbConn.fermer();
				}
			}
		});
		btnRechercher.setBounds(209, 267, 115, 24);
		contentPane.add(btnRechercher);
		
		JButton btnNewButton_1_1 = new JButton("update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(int) table.getModel().getValueAt(l, 0);
				String nom=(String) table.getModel().getValueAt(l, 1);
				String prenom=(String) table.getModel().getValueAt(l, 2);
				dao.etudiant et=new dao.etudiant(nom,prenom);
				Update.majour(id, et);
				refresh();
				//System.out.println(nom+""+prenom+""+id);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBounds(438, 19, 89, 23);
		contentPane.add(btnNewButton_1_1);
	}
}
