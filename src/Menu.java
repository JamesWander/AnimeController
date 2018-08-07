import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField TxServerIp;
	private JTextField TxServerPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Configura\u00E7\u00E3o do Servidor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfiguraoDoServidor = new JLabel("Configura\u00E7\u00E3o do Servidor");
		lblConfiguraoDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblConfiguraoDoServidor.setBounds(49, 11, 257, 44);
		contentPane.add(lblConfiguraoDoServidor);
		
		JLabel lblIpDoServidor = new JLabel("IP do Servidor:");
		lblIpDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIpDoServidor.setBounds(49, 97, 103, 17);
		contentPane.add(lblIpDoServidor);
		
		TxServerIp = new JTextField();
		TxServerIp.setBounds(166, 97, 131, 20);
		contentPane.add(TxServerIp);
		TxServerIp.setColumns(10);
		
		JLabel lblPortaDoServidor = new JLabel("Porta do Servidor:");
		lblPortaDoServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPortaDoServidor.setBounds(49, 147, 118, 17);
		contentPane.add(lblPortaDoServidor);
		
		TxServerPort = new JTextField();
		TxServerPort.setColumns(10);
		TxServerPort.setBounds(166, 147, 131, 20);
		contentPane.add(TxServerPort);
		
		JButton btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarServidor.setBounds(79, 210, 188, 44);
		btnIniciarServidor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarServidor(TxServerIp.getText(),TxServerPort.getText());
				
			}
		});
		contentPane.add(btnIniciarServidor);
	}
	
	public void iniciarServidor(String ip, String porta)
	{
		try
		{
			new Principal(ip,porta);
			this.setVisible(false);
			
		}
		catch (Exception e)
		{
			System.out.println(e);;
		}
		
		
		
	}
	
	
}
