package com.kevinmorton.kevingpsbonus;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Kevin Morton.
 * Following the tutorial: http://www.devexchanges.info/2015/06/using-google-maps-api-v2-to-get-current.html
 */
public class GetAddressTask extends AsyncTask<String, Void, String> {

    private MapsActivity activity;

    public GetAddressTask(MapsActivity activity) {
        super();
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(activity, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(Double.parseDouble(params[0]), Double.parseDouble(params[1]), 1);

            // Address details
            String address = addresses.get(0).getAddressLine(0);
            String city = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String zipCode = addresses.get(0).getPostalCode();
            String addressNumber = addresses.get(0).getFeatureName();

            return "Street: " + address + "\n" + "City: " + city + "\nCountry: " + country
                    + "\nZip Code: " + zipCode + "\n" + "House Number: " + addressNumber;

        } catch (IOException ex) {
            ex.printStackTrace();
            return "IOE EXCEPTION";

        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return "IllegalArgument Exception";
        }

    }

    /**
     * When the task finishes, onPostExecute() call back data to Activity UI and displays the address.
     * @param address
     */
    @Override
    protected void onPostExecute(String address) {
        // Call back Data and Display the current address in the UI
        activity.callBackDataFromAsyncTask(address);
    }
}
