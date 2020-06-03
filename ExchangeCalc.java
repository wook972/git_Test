package swingsample.combobox;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class ExchangeCalc extends JFrame implements ActionListener {
	private static float USD = 1225.60F;		//float ���� f�� ����
	private static float JPY = 1137.92F;
	private static float EUR = 1363.66F;
	private static float CNY = 171.89F;
	
	JComboBox<String> combo;
	String[] money = {"�޷�", "��", "����", "����"};
	JPanel pane1, pane2;
	JLabel lbl;
	JTextField txt;
	JButton btn;
	
	public ExchangeCalc() {
		setTitle("ȯ�� ����");
		
		pane1 = new JPanel();
		pane2 = new JPanel();
		
		txt = new JTextField(10);			//pane1
		combo = new JComboBox<>(money);
		btn = new JButton("��ȯ");
		
		lbl = new JLabel("��ȯ ���");		//pane2
		
		//getContentPane().setLayout(new FlowLayout());
		pane1.add(new JLabel("��ȭ"));
		pane1.add(txt);
		pane1.add(combo);
		pane1.add(btn);
		
		pane2.add(lbl);
		
		getContentPane().add(pane1, "North");		//�ڸ� ��ġ(BorderLayout)
		getContentPane().add(pane2, "Center");		//�ڸ� ��ġ(BorderLayout)
		
		setBounds(300, 300, 350, 200);		//x��ǥ, y��ǥ, width, height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btn.addActionListener(this);
	}

	public static void main(String[] args) {
		new ExchangeCalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		calculate();
		
	}
	
	public void calculate() {
		float won = Float.parseFloat(txt.getText());		//�Էµ� ���ڸ� �Ǽ��� ��ȯ
		String result = null;
		String money = combo.getSelectedItem().toString();	//��������
		
		if(money.equals("�޷�")) {
			result = String.format("%.2f", won / USD);
		}else if(money.equals("��")) {
			result = String.format("%.2f", won / JPY);
		}else if(money.equals("����")) {
			result = String.format("%.2f", won / EUR);
		}else if(money.equals("����")) {
			result = String.format("%.2f", won / CNY);
		}
		lbl.setText(result);
	}

}
