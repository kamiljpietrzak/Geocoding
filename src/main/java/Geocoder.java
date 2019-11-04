import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;

import java.util.ArrayList;
import java.util.List;

public class Geocoder {
    final static String country = "pl";
    private final static JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("YOUR-API-KEY");
    List<Double> startCoords = new ArrayList<>();
    List<Double> stopCoords = new ArrayList<>();


    public void getCoordinatesFromAdress (String adress, String country){
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(adress);
        request.setRestrictToCountryCode(country); // restrict results to a specific country
        request.setBounds(18.367, -34.109, 18.770, -33.704); // restrict results to a geographic bounding box (southWestLng, southWestLat, northEastLng, northEastLat)

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition(); // get the coordinate pair of the first result
    }
}
