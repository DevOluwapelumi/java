import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherApp extends JFrame {
    private static final String API_KEY = "YOUR_API_KEY_HERE"; // Replace with your API key
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    private JTextField cityField;
    private JButton searchButton;
    private JLabel temperatureLabel, descriptionLabel, humidityLabel;

    public WeatherApp() {
        setTitle("Weather App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        cityField = new JTextField(15);
        searchButton = new JButton("Search");
        inputPanel.add(cityField);
        inputPanel.add(searchButton);
        add(inputPanel, BorderLayout.NORTH);

        // Weather info panel
        JPanel weatherPanel = new JPanel(new GridLayout(3, 1));
        temperatureLabel = new JLabel("Temperature: ");
        descriptionLabel = new JLabel("Description: ");
        humidityLabel = new JLabel("Humidity: ");
        weatherPanel.add(temperatureLabel);
        weatherPanel.add(descriptionLabel);
        weatherPanel.add(humidityLabel);
        add(weatherPanel, BorderLayout.CENTER);

        // Action listener for search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (!city.isEmpty()) {
                    fetchWeatherData(city);
                }
            }
        });
    }

    private void fetchWeatherData(String city) {
        try {
            URL url = new URL(String.format(API_URL, city, API_KEY));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
            JSONObject main = (JSONObject) jsonObject.get("main");
            JSONObject weather = (JSONObject) ((org.json.simple.JSONArray) jsonObject.get("weather")).get(0);

            double temperature = (double) main.get("temp");
            String description = (String) weather.get("description");
            long humidity = (long) main.get("humidity");

            temperatureLabel.setText(String.format("Temperature: %.1f°C", temperature));
            descriptionLabel.setText("Description: " + description);
            humidityLabel.setText("Humidity: " + humidity + "%");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error fetching weather data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeatherApp().setVisible(true);
            }
        });
    }
}