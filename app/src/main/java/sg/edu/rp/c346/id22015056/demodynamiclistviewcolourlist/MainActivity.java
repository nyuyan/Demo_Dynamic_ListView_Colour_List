package sg.edu.rp.c346.id22015056.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etext;
    Button btn;
    ListView lv;

    ArrayList<String> alColours;
    ArrayAdapter<String>aaColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etext=findViewById(R.id.editTextColour);
        btn=findViewById(R.id.buttonAddItem);
        lv=findViewById(R.id.listViewColour);

        alColours= new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");
        aaColours= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        lv.setAdapter(aaColours);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String Name= etext.getText().toString();
                alColours.add(Name);
                int pos =Integer.parseInt(etext.getText().toString());
                alColours.add(pos,Name);
                aaColours.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();             }
        });
    }
}