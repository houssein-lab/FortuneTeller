import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneArea;
    private final ArrayList<String> fortunes;
    private final Random random;
    private int lastIndex = -1; // track last fortune index

    public FortuneTellerFrame() {
        super("Fortune Teller");

        // --- Fonts ---
        Font titleFont = new Font("Serif", Font.BOLD, 36);
        Font textFont = new Font("SansSerif", Font.PLAIN, 16);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);

        // --- Top Panel (Title + Image) ---
        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/fortune.png"));
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        topPanel.add(titleLabel);

        // --- Middle Panel (TextArea inside ScrollPane) ---
        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setEditable(false);
        fortuneArea.setFont(textFont);
        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        // --- Bottom Panel (Buttons) ---
        JPanel bottomPanel = new JPanel();
        JButton fortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);
        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);

        // --- Add to Frame ---
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // --- Fortune List ---
        fortunes = new ArrayList<>();
        fortunes.add("You will find money in your couch cushions.");
        fortunes.add("A pigeon will steal your sandwich today.");
        fortunes.add("Good news will arrive in the form of pizza.");
        fortunes.add("Beware of cats plotting against you.");
        fortunes.add("Your WiFi password will finally work.");
        fortunes.add("Tomorrow, socks will mysteriously disappear.");
        fortunes.add("Someone will compliment your coding skills.");
        fortunes.add("Your coffee will taste extra strong today.");
        fortunes.add("You will step on LEGO. Be careful.");
        fortunes.add("The fortune cookie is always right… except this time.");
        fortunes.add("A random bug will vanish from your code by itself.");
        fortunes.add("Expect laughter from unexpected places.");

        random = new Random();

        // --- Button Actions (Lambdas) ---
        fortuneButton.addActionListener(e -> showRandomFortune());
        quitButton.addActionListener(e -> System.exit(0));

        // --- Frame Settings ---
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showRandomFortune() {
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;

        fortuneArea.append(fortunes.get(index) + "\n");
    }
}
