import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MindReader {

    private JFrame frame;
    private JLabel label;
    private JTextField field;
    private JButton button;

    MindReader(){
        initialize();
    }

    public void initialize(){
        frame = new JFrame();
        frame.setTitle("Mind reader");
        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);

        label = new JLabel();
        label.setText("Think of a number between 1 and 10: ");
        label.setBounds(35, 10, 1000, 50);
        frame.add(label);

        field = new JTextField();
        field.setBounds(40, 90, 190, 30);
        frame.add(field);

        button = new JButton();
        button.setText("Read my mind");
        button.setFocusable(false);
        button.setBounds(75, 150, 120, 20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newWin();
            }
        });
        frame.add(button);
        frame.setVisible(true);
    }

    public void newWin(){
        JFrame newWin = new JFrame();
        newWin.setTitle("Reading");
        newWin.setSize(300, 250);
        newWin.setLayout(null);
        newWin.setDefaultCloseOperation(2);
        newWin.setLocationRelativeTo(null);

        JLabel statusLabel = new JLabel("Analyzing Brainwaves...");
        statusLabel.setBounds(20, 20, 250, 20);
        newWin.add(statusLabel);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setBounds(20, 50, 250, 30);
        newWin.add(progressBar);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 90, 250, 20);
        newWin.add(resultLabel);

        newWin.setVisible(true);

        Timer timer = new Timer(2000, new ActionListener(){
            int progress = 0;
            String[] message = {"Analyzing Brainwaves...", "Scanning memories...", "Calculating possibilities...", "Decoding thoughts..."};
            int[] progressValues = {0, 25, 50, 75, 100};
            
            public void actionPerformed(ActionEvent e){
                if (progress < message.length) {
                    statusLabel.setText(message[progress]);
                    progressBar.setValue(progressValues[progress]);
                    progress++;
                }
                else{
                    statusLabel.setText("Finished");
                    progressBar.setValue(100);
                    ((Timer) e.getSource()).stop();
                    resultLabel.setText("You are thinking of: " + field.getText());
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
        
    }


    public static void main(String[] args) {
        new MindReader();
    }
}
