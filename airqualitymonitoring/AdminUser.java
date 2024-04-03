package airqualitymonitoring;



class AdminUser {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";
    private int airQualityLevel;

    public boolean login(String username, String password) {
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);

    }
   
    

    public void updateAirQuality(int airQualityLevel) {
        if (airQualityLevel >= 0 && airQualityLevel <= 500) {
            this.airQualityLevel = airQualityLevel;
        } else {
            System.out.println("Invalid air quality level. Air quality level should be between 0 and 500.");
        }
    }

    public int getAirQualityLevel() {
        
        return airQualityLevel;
    }
}