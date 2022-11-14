package com.tomiprasetyo.ppni;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    String dataTitle[], dataDescription[];
    int images[];
    Context context;

    public Adapter(Context ctx, String title[], String description[], int imgs[]) {
        context = ctx;
        dataTitle = title;
        dataDescription = description;
        images = imgs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewTitle.setText(dataTitle[position]);
        holder.textViewDescription.setText(dataDescription[position]);
        holder.imageView.setImageResource(images[position]);

        holder.rowItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailInformasiActivity.class);
                intent.putExtra("Data Title", dataTitle[holder.getAdapterPosition()]);
                intent.putExtra("Data Description", dataDescription[holder.getAdapterPosition()]);
                intent.putExtra("Image", images[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewDescription;
        ImageView imageView;
        ConstraintLayout rowItemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            imageView = itemView.findViewById(R.id.image_view_item);
            rowItemLayout = itemView.findViewById(R.id.row_item_layout);


        }
    }
}
