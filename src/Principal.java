import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Principal
{
	public Robot robo;
	public ServerSocket servidor;
	public Socket cliente;

	public Principal(String ips, String porta)
	{
		
		try
		{
			robo = new Robot();
			InetAddress ip = InetAddress.getByName(ips);
			servidor = new ServerSocket(Integer.parseInt(porta), 0, ip);
			
			Notificacao not1 = new Notificacao(ips,porta,1);
			not1.exibir();
			
			cliente = servidor.accept();
			CommandListener command =  new CommandListener(cliente);
			command.start();
			
			Notificacao not2 = new Notificacao(2);
			not2.exibir();
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	public void proximoEp()
	{
		// Delay temporarario antes de iniciar a aplicação
		robo.delay(2000);

		// Comandos para sair do video
		robo.keyPress(KeyEvent.VK_ESCAPE);
		robo.keyRelease(KeyEvent.VK_ESCAPE);
		robo.delay(100);

		// Comandos para usar o Scroll do mouse até a parte da pagina especifica
		robo.mouseWheel(6);
		robo.mouseMove(800, 800);
		robo.delay(500);

		// Clicando no proximo episodio
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(2000);

		// Scrollando até o video
		robo.mouseWheel(6);
		robo.delay(4000);

		// Fechar Propaganda
		robo.mouseMove(1108, 416);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(500);

		// Clicando em Beta SD
		robo.mouseMove(1075, 115);
		robo.delay(500);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(500);

		// Clicando em Beta HD
		robo.mouseMove(1250, 115);
		robo.delay(500);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(500);

		// Clicando em Beta HD quando tiver fullhd
		robo.mouseMove(1410, 115);
		robo.delay(500);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(500);

		// Clicando em Play e deixando em fullscreen
		robo.mouseMove(930, 600);
		robo.delay(500);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.mouseMove(1920, 1);

	}

	public void volumeMais()
	{
		
	}
	
	public void volumeMenos()
	{
		
	}
	
	public void mutar() 
	{
		
	}

	public void avançar()
	{
		
	}
	
	public void voltar()
	{
		
	}
	
	public void playPause()
	{
		
	}
	
	
	
}
