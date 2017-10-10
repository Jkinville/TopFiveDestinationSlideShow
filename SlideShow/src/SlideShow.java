import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		//Added images for each destination and updated the sizes of each picture so it is better looking.
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage1.jpg") + "'</body></html>";
		} else if (i==2){
			//By: James Willamor Wikimedia commons https://commons.wikimedia.org/wiki/File:Taino_Beach,_Grand_Bahama.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Taino_Beach,_Grand_Bahama.jpg") + "'</body></html>";
		} else if (i==3){
			//By: MIKI Yoshihito Wikimedia commons 	
			//https://www.flickr.com/photos/mujitra/16892388692/in/photolist-m6k3hb-7CuR2s-7CuQZ7-m6jarH-m6itzF-m6iCoH-T1yahh-m6isDn-m6jda8-T1y8aS-S1te2R-RXVom9-SEt9Ey-RXVA11-rJHUCU-qMQi19-rJHKsj-qMQjf3-rGxqmE-rqvpNM-rGxuqG-rGxtBN-rsfwSW-rsfsUq-rJQ9xZ-qN3siH-bx211V-8w87tU
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Hilton_Niseko_Village.jpg") + "'</body></html>";
		} else if (i==4){
			//By:florin_glontaru Wikimedia commons 	http://www.panoramio.com/photo/41076639
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Sunset_at_Gerakini_beach,_Greece_-_panoramio.jpg") + "'</body></html>";
		} else if (i==5){
			//By:Keith Pomakis Wikimedia commons https://commons.wikimedia.org/wiki/File:Cancun_Beach.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/800px-Cancun_Beach.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		//Added descriptions for each new destination and updated the font color to something more user friendly.
		if (i==1){
			text = "<html><body><font size='5' color='white'>#1 The Grand Canyon.</font> <br><font color='white'>"
					+ "Spectacular canyon views and hiking.</font></body></html>";
		} else if (i==2){
			text = "<html><body><font size='5' color='white'>#2 Taino Beach Grand Bahama, The Bahamas.</font> <br>"
					+ "<font color='white'>Relax on one of the most breathtaking"
					+ "beaches in the world or go for a hike on one of the amazing trails.</font></body></html>";
		} else if (i==3){
			text = "<html><body><font size='5' color='white'>#3 Niseko Village, Hokkaido Japan</font><br>"
					+ "<font color='white'>Take a dip in the legendary hot springs, go for a skiing or a hike, or just relax in this snowy village."
					+ "</font></body></html>";
		} else if (i==4){
			text = "<html><body><font size='5' color='white'>#4 Gerakini beach, Greece</font>"
					+ "<br><font color='white'>Spend some time in one of the most famous resort towns in the world.</font></body></html>";
		} else if (i==5){
			text = "<html><body><font size='5' color='white'>#5 Cancun, Mexico</font><br>"
					+ "<font color='white'>Come relax and recover on the most beautiful beaches in the world or spend some time"
					+ "in one of their world-renowned resorts.</font></body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}