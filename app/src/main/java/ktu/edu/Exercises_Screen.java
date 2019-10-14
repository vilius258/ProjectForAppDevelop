package ktu.edu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Exercises_Screen extends AppCompatActivity {

    ImageView ProfileImage;
    TextView Title;
    TextView Description;
    Button Buttondelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises__screen);
        ProfileImage = (ImageView)findViewById(R.id.profileimage);
        Title = (TextView)findViewById(R.id.title);
        Description = findViewById(R.id.description);
        Buttondelete = findViewById(R.id.button2);
        ProfileImage.setImageResource(getIntent().getIntExtra("image",0));
        Title.setText(getIntent().getStringExtra("title"));
        Description.setText(getIntent().getStringExtra("description"));
        Buttondelete.setOnClickListener(Deletefunciton);

    }
    View.OnClickListener Deletefunciton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ProfileImage.setVisibility(View.GONE);
        }
    };
}
