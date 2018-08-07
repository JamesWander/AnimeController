import java.awt.*;
import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

public class Notificacao {

	private String ip;
	private String porta;
	private int id;
	
	public Notificacao(String ip, String porta, int id)
	{
		this.ip = ip;
		this.porta = porta;
		this.id = id;
	}
	
	public Notificacao(int id)
	{
		this.id = id;
	}
	

    public void exibir(){
    	
    	try
    	{
	    	if(SystemTray.isSupported())
	    	{
		        
		        SystemTray tray = SystemTray.getSystemTray();
	
		        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		        trayIcon.setImageAutoSize(true);
		        trayIcon.setToolTip("Notificação");
		        tray.add(trayIcon);
		
		        if(id == 1)
		        {
		        	trayIcon.displayMessage("Aguardando Conexão", "Servidor aberto no IP "+ip+" Porta "+porta, MessageType.INFO);
		        }
		        else if(id == 2)
		        {
		        	trayIcon.displayMessage("Aguardando Comandos", "Conexão Bem Sucedida ", MessageType.INFO);
		        }
	    	}
	    	

    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
}