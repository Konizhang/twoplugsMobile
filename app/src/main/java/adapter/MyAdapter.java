package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twoplugs.mobile.R;

import java.util.List;

import model.Service;

/**
 * Created by Administrator on 2016/11/1.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Service> list;

    public MyAdapter(Context context, List<Service> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_text.setText(list.get(position).getPayment());
        holder.email.setText(list.get(position).getDescription());
        holder.username.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView item_text;
        private TextView username;
        private TextView email;
        public MyViewHolder(View itemView){
            super(itemView);
            item_text = (TextView)itemView.findViewById(R.id.item_text);
            email = (TextView)itemView.findViewById(R.id.email);
            username = (TextView)itemView.findViewById(R.id.username);

        }



    }



}
