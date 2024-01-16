import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUI implements ActionListener {
    private final JFrame mainFrame;
    private JPanel panel;
    private JPanel lowerpanel;
    private JButton sortpeople;
    private JButton sortmade;
    private JButton sortfor;
    private JLabel label;
    private JLabel picturelabel;
    private JTextArea textarea;
    private JPanel toppanel;
    private JTextField textField;
    private JButton button;
    private JPanel centerPanel;

    public static void main(String[] args) {GUI myGUI = new GUI();}

    public GUI(){

        mainFrame = new JFrame();
        panel = new JPanel();

        toppanel = new JPanel();
        picturelabel = new JLabel();
        try{
            BufferedImage myPicture = ImageIO.read(new File("atera.png"));
            picturelabel.setIcon(new ImageIcon(myPicture));
        } catch(Exception e){e.printStackTrace();
            picturelabel.setText("pictureshouldbehere");}

        textarea = new JTextArea();{
            for (int i = 1; i < 6; i++){
             //   textarea.setText(textarea.getText()+ );
            }

        }

        centerPanel = new JPanel();
        textField = new JTextField("hello");
        button = new JButton("New Reservation");




        lowerpanel = new JPanel();
        label = new JLabel("Sort reservations by:");
        label.setPreferredSize(new Dimension(200,60));
        sortpeople = new JButton("# of people");
        sortmade = new JButton("time made");
        sortfor = new JButton("time for");









        mainFrame.add(panel);
        panel.setLayout(new BorderLayout());

        panel.add(toppanel,BorderLayout.NORTH);
        toppanel.add(picturelabel,BorderLayout.NORTH);
        toppanel.add(textarea,BorderLayout.SOUTH);


      panel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout());
        centerPanel.add(textField);
        centerPanel.add(button);




        panel.add(lowerpanel,BorderLayout.SOUTH);

        lowerpanel.setLayout(new GridLayout());
        lowerpanel.add(label);
        lowerpanel.add(sortpeople);
      lowerpanel.add(sortmade);
       lowerpanel.add(sortfor);


        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {






    }
}

