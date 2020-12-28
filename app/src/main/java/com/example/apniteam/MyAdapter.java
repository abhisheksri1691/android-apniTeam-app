package com.example.apniteam;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apniteam.model.PlayerModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<PlayerModel> mDataset;
    private Context context;
    public ArrayList<PlayerModel> playerListUser1 = new ArrayList<>();
    public ArrayList<PlayerModel> playerListUser2 =  new ArrayList<>();
    HashMap<Integer,PlayerModel> hasmap = new HashMap<>();
    HashMap<Integer,PlayerModel> hasmap2 = new HashMap<>();


    MyAdapter(List<PlayerModel> list, Context context)
    {
        mDataset = list;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
         View ve  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(ve,context,playerListUser1,playerListUser2,hasmap,hasmap2);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(mDataset.get(position),position);


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView textView;
        private TextView textViewTName;
        private LinearLayout layoutView;
        private View itemView;
        private Context context;
        List<PlayerModel> playerListUser1;
        List<PlayerModel> playerListUser2;
        HashMap<Integer,PlayerModel> hasmap;
        HashMap<Integer,PlayerModel> hasmap2 ;
        private MyViewHolder(View itemView, Context context, ArrayList<PlayerModel> playerListUser1, ArrayList<PlayerModel> playerListUser2, HashMap<Integer, PlayerModel> hasmap, HashMap<Integer, PlayerModel> hasmap2) {
            super(itemView);
            this.itemView = itemView;
            this.context=context;
            this.hasmap=hasmap;
            this.hasmap2=hasmap2;
            this.playerListUser1 = playerListUser1;
            this.playerListUser2 = playerListUser2;
            textView = itemView.findViewById(R.id.tv_pName);
            layoutView = itemView.findViewById(R.id.recycler_id);
            textViewTName = itemView.findViewById(R.id.tv_pNameTeam);
        }

        public void bind(final PlayerModel data , final int position)
        {
            layoutView.setBackgroundTintList(
                    data.isSelected() ?
                            ContextCompat.getColorStateList(context, R.color.colorGreen):ContextCompat.getColorStateList(context, R.color.colorWhite));
            textView.setText(data.getName());
            textViewTName.setText(data.getTeamName());

            if( data.getUserId()==1)
            {
                if (data.isSelected())
                    hasmap.put(data.getPlayerId(),data);
                else
                    hasmap.remove(data.getPlayerId());
                playerListUser1.clear();
                playerListUser1.addAll(hasmap.values());
            }
            else
            {
                if (data.isSelected())
                    hasmap2.put(data.getPlayerId(),data);
                else
                    hasmap2.remove(data.getPlayerId());

                playerListUser2.clear();
                playerListUser2.addAll(hasmap2.values());

            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println("recyclerView Item Click::"+data.getName());
                    data.setSelected(!data.isSelected());

                    if( data.getUserId()==1)
                    {
                        if (data.isSelected())
                            hasmap.put(data.getPlayerId(),data);
                        else
                            hasmap.remove(data.getPlayerId());
                        playerListUser1.clear();
                        playerListUser1.addAll(hasmap.values());
                    }
                    else
                    {
                        if (data.isSelected())
                            hasmap2.put(data.getPlayerId(),data);
                        else
                            hasmap2.remove(data.getPlayerId());

                        playerListUser2.clear();
                        playerListUser2.addAll(hasmap2.values());

                    }

                    layoutView.setBackgroundTintList(
                            data.isSelected() ?
                            ContextCompat.getColorStateList(context, R.color.colorGreen):ContextCompat.getColorStateList(context, R.color.colorWhite));
                }
            });
        }
    }
}
