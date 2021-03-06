package com.bvmit.star_0733.minor_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<Chat_model> {
    private Activity context;
    private List<Chat_model> list;
    String email;
    public ChatAdapter(@NonNull Activity context, List<Chat_model> list , String email) {
        super(context,R.layout.chat_list_row,list);
        this.context = context;
        this.list = list;
        this.email = email;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.chat_list_row,null,true);


        TextView em = (TextView)listview.findViewById(R.id.message_user);
        TextView chatmsg = (TextView)listview.findViewById(R.id.message_text);
        ImageView img = listview.findViewById(R.id.send_img);

        LinearLayout pachat = (LinearLayout) listview.findViewById(R.id.parentchatback);

        Chat_model info = list.get(position);
        if(info.getMessageUser().equals(email))
        {
            pachat.setGravity(Gravity.RIGHT);
            em.setText(null);
            img.setVisibility(View.GONE);
            em.setVisibility(View.GONE);
            chatmsg.setBackgroundResource(R.drawable.send);
            chatmsg.setText(info.getMessageText());
        }
        else {
            pachat.setGravity(Gravity.LEFT);
            chatmsg.setBackgroundResource(R.drawable.reci);
            em.setText(info.getMessageUser());
            chatmsg.setText(info.getMessageText());
            chatmsg.setGravity(Gravity.RIGHT);
        }
        return listview;
    }

}
