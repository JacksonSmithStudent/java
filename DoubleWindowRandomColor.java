import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DoubleWindowRandomColor {
    private static int width = 300;  // Initial width of the window
    private static int height = 200; // Initial height of the window
    private static int numWindows = 1; // Initial number of windows
    private static Random random = new Random(); // Random number generator

    public static void main(String[] args) {
        createWindows(numWindows); // Create the first window(s)
    }

    // Method to create 'n' new windows at random positions with random colors
    public static void createWindows(int count) {
        // Get the screen size to ensure windows are placed within bounds
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        for (int i = 0; i < count; i++) {
            JFrame frame = new JFrame("Window " + (i + 1));

            // Set the size of the window
            frame.setSize(width, height);

            // Generate random x and y positions within screen bounds
            int x = random.nextInt(screenWidth - width);
            int y = random.nextInt(screenHeight - height);

            // Set the window position to the random coordinates
            frame.setLocation(x, y);

            // Set a random background color
            Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            frame.getContentPane().setBackground(randomColor);

            // Set the default close operation
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // When a window is closed, double the number of windows
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    // Double the number of windows to be opened
                    numWindows *= 2;

                    // Create double the amount of windows at random positions with random colors
                    createWindows(numWindows);
                }
            });

            // Set window visibility to true
            frame.setVisible(true);
        }
    }
}
