import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // Define the target date (May 26, 2025)
        LocalDate targetDate = LocalDate.of(2025, 2, 25);

        // Create a JFrame
        JFrame frame = new JFrame("Countdown Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 65);
        frame.setLayout(new FlowLayout());

        // Create a JLabel to display the countdown
        JLabel countdownLabel = new JLabel("Time remaining until the final event: ");
        frame.add(countdownLabel);

        // Create a Timer to update the countdown every second
        Timer timer = new Timer(1000, e -> {
            LocalDateTime currentDateTime = LocalDateTime.now();
            long secondsRemaining = ChronoUnit.SECONDS.between(currentDateTime, targetDate.atStartOfDay());
            countdownLabel.setText("Time remaining until the final event: " + formatTime(secondsRemaining));
        });
        timer.start();

        // Show the frame
        frame.setVisible(true);
    }


    // Helper method to format time in days, hours, minutes, and seconds
    private static String formatTime(long seconds) {
        long days = seconds / 86400;
        long hours = (seconds % 86400) / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;
        return String.format("%d days, %02d:%02d:%02d", days, hours, minutes, secs);
    }
}