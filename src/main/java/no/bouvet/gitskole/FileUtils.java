package no.bouvet.gitskole;

import java.io.InputStream;

public class FileUtils {

    public static LatLon meters2degrees(double x, double y) {
        var lon = x * 180 / 20037508.34;
        var lat = Math.atan(Math.exp(y * Math.PI / 20037508.34)) * 360 / Math.PI - 90;
        return new LatLon(lat, lon);
    }

    public static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    public static void main(String[] args) {

        // Lørenskog:  59.926838, 10.963221
        // 59.94924298867558, 10.951389441905969
        // Vadsø:  70.40654567205839, 28.98102869781608


        System.out.println("Lørenskog : " + meters2degrees(59.94924298867558, 10.951389441905969));
    }

}
