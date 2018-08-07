import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class CommandListener extends Thread
{
	Socket cliente;
	Robot robo;
	
	public CommandListener(Socket cliente) throws AWTException
	{
		this.cliente = cliente;
		robo = new Robot();
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				//Recebendo Inputs
				DataInputStream dIn = new DataInputStream(cliente.getInputStream());
				
				int comm = dIn.readInt();
				switch(comm)
				{
					
					case 1:
						proximoEp();
						break;
						
					case 2:
						playPause();
						break;
						
					case 3:
						avançar();
						break;
						
					case 4:
						voltar();
						break;
					
					case 0:
						System.exit(0);
						break;
						
				}
	
			}
		}
		catch(Exception e) {}
	}
	

	public void proximoEp()
	{

		// Comandos para sair do video
		robo.keyPress(KeyEvent.VK_ESCAPE);
		robo.keyRelease(KeyEvent.VK_ESCAPE);
		robo.delay(500);
		

		// Comandos para usar o Scroll do mouse até a parte da pagina especifica
		robo.mouseMove(800, 800);
		robo.mouseWheel(6);
		robo.delay(1000);

		// Clicando no proximo episodio
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(2000);

		// Scrollando até o video
		robo.mouseWheel(6);
		robo.delay(5000);

		// Fechar Propaganda
		robo.mouseMove(1108, 416);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(500);
		if(robo.getPixelColor(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y) == Color.WHITE)
		{
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_W);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_W);
			robo.delay(500);
		}

		// Clicando em Beta SD
		robo.mouseMove(830, 135);
		robo.delay(500);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(1000);

		// Clicando em Beta HD
		robo.mouseMove(750, 135);
		robo.delay(500);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(1000);

		// Clicando em Beta HD quando tiver fullhd
		robo.mouseMove(750, 135);
		robo.delay(500);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.delay(1000);

		// Clicando em Play e deixando em fullscreen
		robo.mouseMove(930, 600);
		robo.delay(1000);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		robo.mousePress(MouseEvent.BUTTON1_MASK);
		robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		
		
		//Fechando progagando extra caso necessario
		if(robo.getPixelColor(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y) == Color.WHITE)
		{
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_W);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_W);
			robo.delay(500);
			
			robo.mouseMove(930, 600);
			robo.delay(500);
			robo.mousePress(MouseEvent.BUTTON1_MASK);
			robo.mouseRelease(MouseEvent.BUTTON1_MASK);
			robo.mousePress(MouseEvent.BUTTON1_MASK);
			robo.mouseRelease(MouseEvent.BUTTON1_MASK);
			robo.mousePress(MouseEvent.BUTTON1_MASK);
			robo.mouseRelease(MouseEvent.BUTTON1_MASK);
		}
		robo.mouseMove(1920, 1080);


	}

	public void playPause()
	{
		robo.keyPress(KeyEvent.VK_SPACE);
		robo.keyRelease(KeyEvent.VK_SPACE);
		robo.delay(100);
	}
	
	public void avançar()
	{
		robo.keyPress(KeyEvent.VK_RIGHT);
		robo.keyRelease(KeyEvent.VK_RIGHT);
		robo.delay(100);
	}
	
	public void voltar()
	{
		robo.keyPress(KeyEvent.VK_LEFT);
		robo.keyRelease(KeyEvent.VK_LEFT);
		robo.delay(100);
	}
	

	


	
}
