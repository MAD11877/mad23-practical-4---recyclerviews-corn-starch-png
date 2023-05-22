package sg.edu.np.mad.template;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userList = new ArrayList<>();

        for (int i = 1; i < 21; i++) {
            int x = ThreadLocalRandom.current().nextInt(1,999999998);
            int y = ThreadLocalRandom.current().nextInt(1,999999998);
            userList.add(new User("name "+x,"Description "+y, i, false));
        }
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        UserAdapter uAdapter = new UserAdapter(userList);
        LinearLayoutManager uLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(uLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(uAdapter);




    }

    //Viewholder for recyclerview
    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView desc;
        TextView username;
        public UserViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            desc = itemView.findViewById(R.id.desc);

        }
    }

    public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
        ArrayList<User> data;

        public UserAdapter(ArrayList<User> input) {
            data = input;
        }

        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);
            return new UserViewHolder(item);
        }
        public void onBindViewHolder(UserViewHolder holder, int position) {
            User u = data.get(position);
            holder.desc.setText(u.getDescription());
            holder.username.setText(u.getName());
        }
        public int getItemCount() {
            return data.size();
        }


    }
}