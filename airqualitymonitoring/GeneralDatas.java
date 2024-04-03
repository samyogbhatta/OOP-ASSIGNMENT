package airqualitymonitoring;

class GeneralDatas {
    private int airQualityLevel;

    public void setAirQualityLevel(int airQualityLevel) {
        this.airQualityLevel = airQualityLevel;
    }

    public int getAirQualityLevel() {
        return airQualityLevel;
    }

    public String determineAirQualityCondition() {
        int airQualityLevel = getAirQualityLevel();
       
        if (airQualityLevel >= 1 && airQualityLevel <= 50) {
            return "Good. Minimal Impact ";
        } else if (airQualityLevel <= 100) {
            return "Satisfactory. Sensitive people might experience minor breathing discomfort";
        } else if (airQualityLevel <= 200) {
            return "Unhealthy. Lung disease patients may have discomfort in breathing, children and older adults might experience discomfort";
        } else if (airQualityLevel <= 300) {
            return "Poor. Breathing discomfort on prolonged exposure, and discomfort to heart disease patients";
        } else if (airQualityLevel <= 400) {
            return "Very Poor. Prolonged exposure might lead to respiratory illness. Severely affects people with lung and heart diseases.";
        } else if (airQualityLevel <= 500) {
            return "Severe. Best not to settle here ";
        } else {
            return "Invalid air quality level entered.";
        }
       
    }

}
