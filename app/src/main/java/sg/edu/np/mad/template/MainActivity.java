package sg.edu.np.mad.template;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User u = new User("john", "hi", 1, false);
        Button btn  = (Button)findViewById(R.id.btnFollow);
        TextView receiver = findViewById(R.id.textView2);
        Intent intent = getIntent();
        int y = intent.getIntExtra("id",0);
        receiver.setText("User" + y);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (u.getFollowed() == false) {
                    btn.setText("UNFOLLOW");
                    u.setFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                else {
                    btn.setText("FOLLOW");
                    u.setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}