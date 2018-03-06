package megha.mvvm_arch.Room_Persistence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import megha.mvvm_arch.R;

/**
 * Created by Megha Chauhan on 02-Mar-18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private List<UserEntity> userEntities;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.useradapterlist,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.first.setText(userEntities.get(position).getFirstName());
        holder.last.setText(userEntities.get(position).getLastName());
        holder.age.setText(userEntities.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return userEntities.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        public TextView first,last,age;
        public MyViewHolder(View itemView) {
            super(itemView);
            first=itemView.findViewById(R.id.firstN);
            last=itemView.findViewById(R.id.lastN);
            age=itemView.findViewById(R.id.ageN);
        }
    }
    public UserAdapter(List<UserEntity> userEntities){
        this.userEntities=userEntities;
    }
}
