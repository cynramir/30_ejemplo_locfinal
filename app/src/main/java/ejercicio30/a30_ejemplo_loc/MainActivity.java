package ejercicio30.a30_ejemplo_loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtenemos LocationManager
        LocationManager lm=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        try {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, new CambioLocalizacion());
        }
        catch(SecurityException e){
            e.printStackTrace();
        }
    }

    class CambioLocalizacion implements LocationListener{
        @Override
        public void onLocationChanged(Location location) {
            String datos="Altitud: "+location.getAltitude()+" Longitud: "+location.getLongitude();
            datos+=" Latitud:"+location.getLatitude();
            Toast.makeText(MainActivity.this,datos,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
