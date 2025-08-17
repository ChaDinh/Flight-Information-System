import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Form1 extends JFrame implements ActionListener {
    private JLabel airlineNameLabel, flightNumberLabel, flightOriginLabel, flightDestinationLabel, flightAirfareLabel, flightDeparturetimeLabel, flightArrivaltimeLabel, flightSeatLabel, flightDistanceLabel, flightDurationLabel; //  labels for text box
    private JTextArea airlineNameTextArea, flightNumberTextArea, flightOriginTextArea, flightDestinationTextArea, flightAirfareTextArea, flightDeparturetimeTextArea, flightArrivaltimeTextArea, flightDistanceTextArea, flightSeatTextArea, flightDurationTextArea; //text areas
    private JButton displaySortedButton;
    private JComboBox<String> sortDropdown; // dropdown for sorting
    private JTextField searchField; // field for search functionality
    private Flight[] flights; //array of flight objects

    //constructor to initialize and set up GUI
    public Form1(Flight[] flights) {
        super("Flight Information");
        this.flights = flights; //store flights array
        // Initialize components
        initializeComponents();
        setGroupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setVisible(true);
    }
    //inner class for text field with placeholder text in search bar
    public class PlaceholderTextField extends JTextField {
        private final String placeholder;

        public PlaceholderTextField(String placeholder) {
            super();
            this.placeholder = placeholder;
            setForeground(Color.GRAY);
            setText(placeholder);
            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(placeholder)) {
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setForeground(Color.GRAY);
                        setText(placeholder);
                    }
                }
            });
        }
    }

        // set up layout of GUI using GroupLayout
    private void setGroupLayout() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // horizontal group layout
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sortDropdown, GroupLayout.Alignment.CENTER) // add sort dropdown
                        .addComponent(searchField, GroupLayout.Alignment.CENTER) // add search field
                        .addComponent(displaySortedButton, GroupLayout.Alignment.CENTER) // add sort button
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(airlineNameLabel)
                                        .addComponent(flightOriginLabel)
                                        .addComponent(flightDeparturetimeLabel)
                                        .addComponent(flightAirfareLabel)
                                        .addComponent(flightDurationLabel))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(airlineNameTextArea)
                                        .addComponent(flightOriginTextArea)
                                        .addComponent(flightDeparturetimeTextArea)
                                        .addComponent(flightAirfareTextArea)
                                        .addComponent(flightDurationTextArea))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(flightNumberLabel)
                                        .addComponent(flightDestinationLabel)
                                        .addComponent(flightArrivaltimeLabel)
                                        .addComponent(flightSeatLabel)
                                        .addComponent(flightDistanceLabel))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(flightNumberTextArea)
                                        .addComponent(flightDestinationTextArea)
                                        .addComponent(flightArrivaltimeTextArea)
                                        .addComponent(flightSeatTextArea)
                                        .addComponent(flightDistanceTextArea)))
        );

        // Vertical Group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(sortDropdown) // add sort dropdown
                        .addComponent(searchField) // add search field
                        .addComponent(displaySortedButton) //add sort button
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(airlineNameLabel)
                                .addComponent(airlineNameTextArea)
                                .addComponent(flightNumberLabel)
                                .addComponent(flightNumberTextArea))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(flightOriginLabel)
                                .addComponent(flightOriginTextArea)
                                .addComponent(flightDestinationLabel)
                                .addComponent(flightDestinationTextArea))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(flightDeparturetimeLabel)
                                .addComponent(flightDeparturetimeTextArea)
                                .addComponent(flightArrivaltimeLabel)
                                .addComponent(flightArrivaltimeTextArea))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(flightAirfareLabel)
                                .addComponent(flightAirfareTextArea)
                                .addComponent(flightSeatLabel)
                                .addComponent(flightSeatTextArea))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(flightDurationLabel)
                                .addComponent(flightDurationTextArea)
                                .addComponent(flightDistanceLabel)
                                .addComponent(flightDistanceTextArea))
        );
        // add panel to the frame
        getContentPane().add(panel);
    }

    // labels, text areas, button, search and sorted added
    private void initializeComponents() {
        airlineNameLabel = new JLabel("Airline Name");
        flightNumberLabel = new JLabel("Flight Number");
        flightOriginLabel = new JLabel("Flight Origin");
        flightDestinationLabel = new JLabel("Flight Destination");
        flightAirfareLabel = new JLabel("Total Flight Price $");
        flightDeparturetimeLabel = new JLabel("Flight Departure Time");
        flightArrivaltimeLabel = new JLabel("Flight Arrival Time");
        flightDurationLabel = new JLabel("Duration of Flight");
        flightDistanceLabel = new JLabel("Flight Distance");
        flightSeatLabel = new JLabel("Flight Seats Available");
        // sort button
        displaySortedButton = new JButton("Display Sorted Flights");
        displaySortedButton.addActionListener(this);

        // dropdown for sorting criteria
        String[] sortOptions = {"Flight Number","Airline Name", "Origin", "Destination", "Seats Available", "Duration", "Price"};
        sortDropdown = new JComboBox<>(sortOptions);
        sortDropdown.addActionListener(this);

        // search field
        searchField = new JTextField();
        searchField = new PlaceholderTextField("Search");
        searchField.setPreferredSize(new Dimension(100, 25));
        searchField.setMinimumSize(new Dimension(100, 25));
        searchField.addActionListener(this);

        //text areas with specific dimensions and non-editable
        airlineNameTextArea = new JTextArea();
        airlineNameTextArea.setEditable(false);
        airlineNameTextArea.setPreferredSize(new Dimension(150, 30));
        flightNumberTextArea = new JTextArea();
        flightNumberTextArea.setEditable(false);
        flightNumberTextArea.setPreferredSize(new Dimension(150, 30));

        flightOriginTextArea = new JTextArea();
        flightOriginTextArea.setEditable(false);
        flightOriginTextArea.setPreferredSize(new Dimension(150, 30));

        flightDestinationTextArea = new JTextArea();
        flightDestinationTextArea.setEditable(false);
        flightDestinationTextArea.setPreferredSize(new Dimension(150, 30));

        flightAirfareTextArea = new JTextArea();
        flightAirfareTextArea.setEditable(false);
        flightAirfareTextArea.setPreferredSize(new Dimension(150, 30));

        flightDeparturetimeTextArea = new JTextArea();
        flightDeparturetimeTextArea.setEditable(false);
        flightDeparturetimeTextArea.setPreferredSize(new Dimension(150, 30));

        flightArrivaltimeTextArea = new JTextArea();
        flightArrivaltimeTextArea.setEditable(false);
        flightArrivaltimeTextArea.setPreferredSize(new Dimension(150, 30));

        flightDistanceTextArea = new JTextArea();
        flightDistanceTextArea.setEditable(false);
        flightDistanceTextArea.setPreferredSize(new Dimension(150, 30));

        flightDurationTextArea = new JTextArea();
        flightDurationTextArea.setEditable(false);
        flightDurationTextArea.setPreferredSize(new Dimension(150, 30));

        flightSeatTextArea = new JTextArea();
        flightSeatTextArea.setEditable(false);
        flightSeatTextArea.setPreferredSize(new Dimension(150, 30));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displaySortedButton) {
            // get selected sort option
            String selectedOption = (String) sortDropdown.getSelectedItem();

            // sort flights based on selected option
            switch (selectedOption) {
                case "Flight Number":
                    Arrays.sort(flights, Comparator.comparing(Flight::getFlight_number));
                case "Airline Name":
                    Arrays.sort(flights, Comparator.comparing(Flight::getAirline_name));
                    break;
                case "Origin":
                    Arrays.sort(flights, Comparator.comparing(Flight::getFlight_origin));
                    break;
                case "Destination":
                    Arrays.sort(flights, Comparator.comparing(Flight::getFlight_destination));
                    break;
                case "Seats Available":
                    Arrays.sort(flights, Comparator.comparing(Flight::getSeats_available));
                    break;
                case "Duration":
                    Arrays.sort(flights, Comparator.comparing(Flight::getFlight_duration));
                    break;
                case "Price":
                    Arrays.sort(flights, Comparator.comparing(Flight::getAirfare));
                    break;
            }
            // update text areas with sorted flights
            updateFlightInformationTextAreas();
        } else if (e.getSource() == searchField) { // Handling search functionality
            String query = searchField.getText().toLowerCase();
            Flight[] filteredFlights = Arrays.stream(flights)
                    .filter(flight -> flight.getAirline_name().toLowerCase().contains(query)
                            || flight.getFlight_origin().toLowerCase().contains(query)
                            || flight.getFlight_destination().toLowerCase().contains(query)
                            || flight.getFlight_number().toLowerCase().contains(query)
                            || String.valueOf(flight.getAirfare()).toLowerCase().contains(query)// Convert to String
                            || String.valueOf(flight.getSeats_available()).toLowerCase().contains(query))
                    .toArray(Flight[]::new);

            // update the flights array with filtered results
            this.flights = filteredFlights;

            // update text areas with filtered flights
            updateFlightInformationTextAreas();
            // clear the search field after search is performed
            searchField.setText("");
        }
    }
        //update text areas with flight information
    private void updateFlightInformationTextAreas() {
        if (flights == null || flights.length == 0) {
            System.out.println("No flights to display.");
            return;
        }
        // clear existing text from text areas
        airlineNameTextArea.setText("");
        flightNumberTextArea.setText("");
        flightOriginTextArea.setText("");
        flightDestinationTextArea.setText("");
        flightAirfareTextArea.setText("");
        flightDeparturetimeTextArea.setText("");
        flightArrivaltimeTextArea.setText("");
        flightDistanceTextArea.setText("");
        flightSeatTextArea.setText("");
        flightDurationTextArea.setText("");

        // append flight information to text areas
        StringBuilder airlineNames = new StringBuilder();
        StringBuilder flightNumbers = new StringBuilder();
        StringBuilder flightOrigins = new StringBuilder();
        StringBuilder flightDestinations = new StringBuilder();
        StringBuilder flightAirfares = new StringBuilder();
        StringBuilder departureTimes = new StringBuilder();
        StringBuilder arrivalTimes = new StringBuilder();
        StringBuilder distances = new StringBuilder();
        StringBuilder duration = new StringBuilder();
        StringBuilder availableSeats = new StringBuilder();

        for (Flight flight : flights) {
            airlineNames.append(flight.getAirline_name()).append("\n");
            flightNumbers.append(flight.getFlight_number()).append("\n");
            flightOrigins.append(flight.getFlight_origin()).append("\n");
            flightDestinations.append(flight.getFlight_destination()).append("\n");
            flightAirfares.append(flight.getAirfare()).append("\n");
            departureTimes.append(flight.getDeparture_time()).append("\n");
            arrivalTimes.append(flight.getArrival_time()).append("\n");
            distances.append(flight.getFight_distance()).append("\n");
            duration.append(flight.getFlight_duration()).append("\n");
            availableSeats.append(flight.getSeats_available()).append("\n");
        }
        //set text areas with flight information
        airlineNameTextArea.setText(airlineNames.toString());
        flightNumberTextArea.setText(flightNumbers.toString());
        flightOriginTextArea.setText(flightOrigins.toString());
        flightDestinationTextArea.setText(flightDestinations.toString());
        flightAirfareTextArea.setText(flightAirfares.toString());
        flightDeparturetimeTextArea.setText(departureTimes.toString());
        flightArrivaltimeTextArea.setText(arrivalTimes.toString());
        flightDistanceTextArea.setText(distances.toString());
        flightDurationTextArea.setText(duration.toString());
        flightSeatTextArea.setText(availableSeats.toString());
    }
}
