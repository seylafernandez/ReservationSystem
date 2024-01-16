import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Restaurant implements ActionListener {

    private ArrayList<Reservation> reservations = new ArrayList<>();
    private JFrame mainFrame;
    private JPanel panel;
    private JPanel lowerpanel;
    private JButton sortpeople;
    private JButton sortmade;
    private JButton sortfor;
    private JLabel label;
    private JLabel picturelabel;
    private JTextArea textarea;
    private JPanel toppanel;
    private JPanel centerPanel;
    private JButton button;
    private JTextField textField;

    public Restaurant() {

        for (int x = 0; x < 6; x++) {
            addReservation();

        }


        displayReservations();
        System.out.println();

       // sortByNPeople();
        displayReservations();
        System.out.println();

       // sortByTimeFor();
        displayReservations();
        System.out.println();

       // sortByTimeMade();
        displayReservations();
        System.out.println();

        GUI();

    }

    public void displayReservations() {
        for (Reservation r : reservations) {
            r.printInfo();
        }
    }//might not need anymore after GUI exists


    public void addReservation() {
        reservations.add(new Reservation());


    }

    public void sortByNPeople() {
        //bubble sort
        //compare to other bubble sort and check if indicies are the same
        boolean madeSwap;
        for (int c = 1; c < reservations.size(); c++) {
            madeSwap = false;
            for (int i = 1; i < reservations.size() - (c - 1); i++) {
                if (reservations.get(i - 1).getNPeople() > reservations.get(i).getNPeople()) {
                    Reservation temp = reservations.get(i);
                    reservations.set(i, reservations.get(i - 1));
                    reservations.set(i - 1, temp);
                    madeSwap = true;

                }

            }
            if (madeSwap == false) {
                break;
            }
        }


    }

    public void sortByTimeMade() {

        for (int i=1;i< reservations.size();i++) {
            int j = i;
            while (j>0 && reservations.get(j).getTimeMade() < reservations.get(j).getTimeMade()) {
                Reservation temp = reservations.get(j - 1);
                reservations.set(j-1,reservations.get(j));
                reservations.set(j, temp);
                j--;

            }
        }

        }

    public void sortByTimeFor() { // selection
        for (int a = 0; a < (reservations.size() - 1); a++) {
            int iMin = a;

            for (int i = a + 1; i < reservations.size(); i++) {
                if (reservations.get(i).getTimeFor() < reservations.get(iMin).getTimeFor()) {
                    iMin = i;
                }
            }
            Reservation min = reservations.get(iMin);
            reservations.set(iMin, reservations.get(a));
            reservations.set(a,min);

        }

    }

    public void GUI() {

        mainFrame = new JFrame();
        panel = new JPanel();

        toppanel = new JPanel();
        picturelabel = new JLabel();
        try {
            BufferedImage myPicture = ImageIO.read(new File("atera.png"));
            picturelabel.setIcon(new ImageIcon(myPicture));
        } catch (Exception e) {
            e.printStackTrace();
            picturelabel.setText("pictureshouldbehere");
        }

        textarea = new JTextArea();
        {
            for (int i = 1; i < 6; i++) {
                // textarea.setText(textarea.getText() + Reservation.get(printInfo));
                textarea.setText(textarea.getText() + "Reservation for " + reservations.get(i).getNPeople() + ", made at " + reservations.get(i).getTimeMadeString() + ", for " + reservations.get(i).getTimeForString() + "\n");
            }

        }

        centerPanel = new JPanel();
        textField = new JTextField();
        button = new JButton("Enter number of people");
        button.addActionListener(this);


        lowerpanel = new JPanel();
        label = new JLabel("Sort reservations by:");
        label.setPreferredSize(new Dimension(200, 60));
        sortpeople = new JButton("# of people");
        sortpeople.addActionListener(this);
        sortmade = new JButton("time made");
        sortmade.addActionListener(this);
        sortfor = new JButton("time for");
        sortfor.addActionListener(this);


        mainFrame.add(panel);
        panel.setLayout(new BorderLayout());

        panel.add(toppanel, BorderLayout.NORTH);
        toppanel.add(picturelabel, BorderLayout.NORTH);
        toppanel.add(textarea, BorderLayout.SOUTH);

        panel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout());
        centerPanel.add(textField);
        centerPanel.add(button);


        panel.add(lowerpanel, BorderLayout.SOUTH);
        lowerpanel.setLayout(new GridLayout());
        lowerpanel.add(label);
        lowerpanel.add(sortpeople);
        lowerpanel.add(sortmade);
        lowerpanel.add(sortfor);


        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) {
        Restaurant Atera = new Restaurant();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonClicked = e.getSource();
        if (buttonClicked == sortpeople) {
            textarea.setText("");
            System.out.println("Sorting by # of people");
            sortByNPeople();
            for (int i = 1; i < 6; i++) {
                textarea.setText(textarea.getText() + "Reservation for " + reservations.get(i).getNPeople() + ", made at " + reservations.get(i).getTimeMadeString() + ", for " + reservations.get(i).getTimeForString() + "\n");
            }

        }
        if (buttonClicked == sortmade) {
            textarea.setText("");
            System.out.println("Sorting by time made");
            sortByTimeMade();
            for (int i = 1; i < 6; i++) {
                textarea.setText(textarea.getText() + "Reservation for " + reservations.get(i).getNPeople() + ", made at " + reservations.get(i).getTimeMadeString() + ", for " + reservations.get(i).getTimeForString() + "\n");
            }
        }
        if (buttonClicked == sortfor) {
                textarea.setText("");
                System.out.println("Sorting by time for");
                sortByTimeFor();
                for (int i = 1; i < 6; i++) {
                    textarea.setText(textarea.getText() + "Reservation for " + reservations.get(i).getNPeople() + ", made at " + reservations.get(i).getTimeMadeString() + ", for " + reservations.get(i).getTimeForString() + "\n");
                }


            }


        }
    }

