package components;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class TextInputEx extends JFrame {

	private JPanel contentPane;
	private JTextField txtInputYourName;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		  EventQueue.invokeLater(new Runnable() { 
			  public void run() { try { TextInputEx
		 frame = new TextInputEx(); frame.setVisible(true); 
		 } catch (Exception e) {
		  e.printStackTrace(); 
		  } 
			  } 
			  });
	}

	/**
	 * Create the frame.
	 */
	public TextInputEx() {
		// 창을 닫는 기능
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창의 위치, 크기
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(32, 217, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Contents");
		lblNewLabel.setBounds(32, 313, 57, 15);
		contentPane.add(lblNewLabel);
		
		txtInputYourName = new JTextField();
		txtInputYourName.addKeyListener(new KeyAdapter() {
		});
		txtInputYourName.setText("input your name");
		txtInputYourName.setBounds(117, 214, 116, 21);
		contentPane.add(txtInputYourName);
		txtInputYourName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(32, 400, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(100, 309, 283, 56);
		contentPane.add(textArea);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(100, 397, 288, 21);
		contentPane.add(txtPwd);
		
		JButton btnStore = new JButton("Store");
		btnStore.setBounds(100, 460, 97, 23);
		contentPane.add(btnStore);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInputYourName.setText("");
				textArea.setText("");
				txtPwd.setText("");
			}
		});
		btnReset.setBounds(222, 460, 97, 23);
		contentPane.add(btnReset);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(391, 93, 135, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		JCheckBox chkCpp = new JCheckBox("C++");
		chkCpp.setBounds(391, 142, 115, 23);
		contentPane.add(chkCpp);
		
		JCheckBox chkJava = new JCheckBox("Java");
		chkJava.setBounds(511, 142, 115, 23);
		contentPane.add(chkJava);
		
		ButtonGroup grp = new ButtonGroup();
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setBounds(391, 179, 121, 23);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setBounds(516, 179, 121, 23);
		contentPane.add(rdoFemale);
		
		grp.add(rdoMale);
		grp.add(rdoFemale);
		
		String[] pet = {"Make selection", "Cat", "Dog", "Rabbit", "Pig"};
		
		JList list = new JList(pet);
		list.setBounds(610, 320, 170, 100);
		contentPane.add(list);
		
		JComboBox combo = new JComboBox(pet);
		combo.setBounds(800, 320, 170, 30);
		contentPane.add(combo);
	}
}
