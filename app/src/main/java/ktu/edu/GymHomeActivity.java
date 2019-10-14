package ktu.edu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GymHomeActivity extends AppCompatActivity {

    private ListView mylist;
    private ListAdapter adapter;
    List<ListItem> items = new ArrayList<>(); //itemlist
    private Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_home);
        mylist = (ListView) findViewById(R.id.listView); //lv
        Intent intent = getIntent();
            items.add(new ListItem("Pull-ups", R.drawable.ic_android_black_24dp, "Grab the handles of the pull-up station with your palms facing away from you and your arms fully extended. Your hands should be around shoulder-width apart. Squeeze your shoulder blades together, exhale and drive your elbows towards your hips to bring your chin above the bar. Lower under control back to the start position.".substring(0,150)));
            items.add(new ListItem("Inverted rows", R.drawable.ic_android_black_24dp, "Set up a bar in a rack at waist height. Hold it at shoulder-width, with an underhand grip, and hang underneath. Position yourself with heels out in front of you and arms fully extended. Your body should be straight from shoulders to ankles. Flex at the elbows to pull your chest up to the bar. Lower yourself back to the start position under control.".substring(0,150)));
            items.add(new ListItem("Dumbbell bench press", R.drawable.ic_android_black_24dp, "Lie down on a flat bench with a dumbbell in each hand, holding them in front of your shoulders. Breathe out and use your chest to push the dumbbells up, straightening your arms. Pause for a second with your arms fully extended and then return under control to the start position.,Chemistry".substring(0,150)));


        adapter = new ListAdapter(this, items);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(context, Exercises_Screen.class);
                intent.putExtra("image",items.get(position).getImageId());
                intent.putExtra("title",items.get(position).getTitle());
                intent.putExtra("description",items.get(position).getDescription());
                context.startActivity(intent);
            }
        });
/*
        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray positionchecker = mylist.getCheckedItemPositions();
                int count = mylist.getCount();

                for(int item = count-1; item>=0;item--){
                    if(positionchecker.get(item)){
                        adapter.remove(items.get(item));
                    }
                }
                positionchecker.clear();
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        */
        mylist.setAdapter(adapter);
    }
}
