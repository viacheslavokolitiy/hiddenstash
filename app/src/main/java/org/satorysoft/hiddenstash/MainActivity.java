package org.satorysoft.hiddenstash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.Arrays;
import java.util.List;


/**
 * Created by viacheslavokolitiy on 25.09.2016.
 */
public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        runOnUiThread(() -> Toast.makeText(MainActivity.this, "Hello from lambda", Toast.LENGTH_LONG).show());

        String[] carsArray = new String[]{"Red", "Black", "Green"};

        List<String> cars = Arrays.asList(carsArray);

        List<String> filtered = Stream.of(cars).filter(value -> value.startsWith("G")).collect(Collectors.toList());

        for (String car : filtered) {
            Log.e("THIS", car);
        }
    }
}
