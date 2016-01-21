package coding.swing;

import java.awt.Panel;

import org.testng.annotations.Test;

import util.Input;

import javax.swing.JFrame;

public class TestSwing {

	@Test
	public void test() throws InterruptedException {
		
		JFrame frame = new JFrame();
		Panel panel = new Panel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(320, 240);
		frame.setVisible(true);
		
		Input.readIntValue();
	}

}
