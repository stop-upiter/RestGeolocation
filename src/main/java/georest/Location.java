package georest;

/**
 * Класс местоположения.
 */
public class Location {
    /**
     * Название страны.
     */
    private final String countryName;

    /**
     * Название региона.
     */
    private final String regionName;

    /**
     * Название города.
     */
    private final String city;

    /**
     * Широта местоположения.
     */
    private final double latitude;

    /**
     * Долгота местоположения.
     */
    private final double longitude;

    /**
     * Публичный конструктор местоположения.
     *
     * @param countryName страна
     * @param regionName  регион
     * @param city        город
     * @param latitude    широта
     * @param longitude   долгота
     */
    public Location(String countryName, String regionName,
                    String city, double latitude,
                    double longitude) {
        this.countryName = countryName;
        this.regionName = regionName;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    /**
     * @return строковое представление о местоположении.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!countryName.isBlank()) {
            stringBuilder.append("Страна: ").append(countryName).append("\n");
        }

        if (!regionName.isBlank()) {
            stringBuilder.append("Регион: ").append(regionName).append("\n");
        }

        if (!city.isBlank()) {
            stringBuilder.append("Город: ").append(city).append("\n");
        }

        stringBuilder.append("Широта: ").append(latitude).append("\n");
        stringBuilder.append("Долгота: ").append(longitude).append("\n");

        return stringBuilder.toString();
    }
}
