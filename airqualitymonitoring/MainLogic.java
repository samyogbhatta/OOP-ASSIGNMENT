package airqualitymonitoring;

import java.util.Scanner;

public class MainLogic {
    private AdminUser adminUser;
    private GeneralDatas generalUser;
    private Scanner scanner;

    public MainLogic() {
        this.adminUser = new AdminUser();
        this.generalUser = new GeneralDatas();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("..........Welcome to the Air Quality Monitoring System...........");

        while (true) {
            System.out.println("Select user type:");
            System.out.println("1. Administrative User");
            System.out.println("2. General User");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminPanel();
                    break;
                case 2:
                    generalPanel();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void adminPanel() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (adminUser.login(username, password)) {
            System.out.println("");
            System.out.println("......Here is Condition according to AQI value....");
            System.out.println("0-50--Good ");
            System.out.println("51-100--Satisfactory");
            System.out.println("101-200--Unhealthy  ");
            System.out.println("201-300--Poor ");
            System.out.println("301-400--Very-Poor ");
            System.out.println("401-500--Severe ");
            
            String[] locations = {"Balaju" , "Chabahil", "Koteshwor", "Ratna Park", "Kalanki", "Swyambhu"};
            int totalAirQuality = 0;
            
            for (int i = 0; i < locations.length; i++) {
                System.out.print("Enter AQI value of " + locations[i] + ": ");
                int airQualityLevel = scanner.nextInt();
                if (airQualityLevel>500) {
                    System.out.println("Error..The AQI range is 0-500");
                    return;
                }
                totalAirQuality += airQualityLevel;
}
            int averageAirQuality = totalAirQuality / locations.length;
            adminUser.updateAirQuality(averageAirQuality);
            generalUser.setAirQualityLevel(averageAirQuality); // Update GeneralUser with the new average
            System.out.println("Latest air quality level updated successfully!");
        } else {
            System.out.println("Invalid username or password. Access denied!");
        }
    }

    private void generalPanel() {
        if (generalUser.getAirQualityLevel() != 0) {
            System.out.println("Latest Air Quality Level of Kathmandu: " + generalUser.getAirQualityLevel()+ " AQI");
            System.out.println("Air Quality Condition: " + generalUser.determineAirQualityCondition());
        } else {
            System.out.println("Air quality data not available.");
        }
    }

    public static void main(String[] args) {
        MainLogic airQualitySystem = new MainLogic();
        airQualitySystem.start();
    }
}
