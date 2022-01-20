package com.example.helloapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.List;
import java.util.regex.Pattern;

public class Adapter extends RecyclerView.Adapter<Adapter.infoViewHolder> {

    private Context uContext;
    private List<InformationModelClass> info;

    public static void navigate(Context context, Class<?> nameOfClass) {
        Intent i = new Intent(context, MapActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }




    public Adapter(Context context,List<InformationModelClass> info) {
        this.uContext=context;
        this.info = info;
    }



    @NonNull
    @Override
    public infoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_view, parent, false);
        return new infoViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.infoViewHolder holder, int position) {
        holder.address.setText(info.get(position).getAddress().getStreet() + info.get(position).getAddress().getSuite() +
                info.get(position).getAddress().getCity() + info.get(position).getAddress().getZipcode());
        holder.bs.setText(info.get(position).getCompany().getBs());
        holder.username.setText(info.get(position).getUsername());
        holder.name.setText(info.get(position).getName());
        holder.cname.setText(info.get(position).getCompany().getCname());
        holder.website.setText("www."+info.get(position).getWebsite());
        holder.email.setText(info.get(position).getEmail());
        holder.phrase.setText('"' + info.get(position).getCompany().getCatchPhrase() + '"');
        holder.phone.setText(info.get(position).getPhone());
        String latitude = info.get(position).getAddress().getGeo().getLat();
        String longitude = info.get(position).getAddress().getGeo().getLng();




//        String imgurl = "https://jsonplaceholder.typicode.com/photos/" ;
//
//        Glide.with(uContext)
//                .load(imgurl)
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(holder.imageView);

        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uri = "geo:?q="+latitude+longitude;
                String[] alertOptions = {"Google Maps", "Local Maps"};
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setTitle("SHOW MAP IN ");
                builder.setCancelable(true);
                builder.setSingleChoiceItems(alertOptions, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int option) {

                        if (option == 0) {

                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                            intent.setPackage("com.google.android.apps.maps");
                            getContext(v.getContext()).startActivity(intent);
                        }

                        if (option == 1) {
//
                            Intent i = new Intent(uContext, MapActivity.class);
                            i.putExtra("LAT",latitude);
                            i.putExtra("LONG",longitude);
                            uContext.startActivity(i);


                        }
                    }

                    private Context getContext(Context context) {
                        return context;
                    }

                });
                builder.show();

            }
        });




    }




    public class infoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,address,email,phrase,cname,bs,website,phone,username;

        public infoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.image);
            bs = itemView.findViewById(R.id.userbs);
            username=itemView.findViewById(R.id.usercname);
            cname = itemView.findViewById(R.id.cname);
            name =itemView.findViewById(R.id.name);
            phrase =itemView.findViewById(R.id.catchphrase);
            website =itemView.findViewById(R.id.website);
            email =itemView.findViewById(R.id.email);
            address =itemView.findViewById(R.id.address);
            phone =itemView.findViewById(R.id.phone);




        }
    }
}


