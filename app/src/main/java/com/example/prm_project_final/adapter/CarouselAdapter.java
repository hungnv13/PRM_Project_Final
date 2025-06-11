package com.example.prm_project_final.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prm_project_final.R;
import com.example.prm_project_final.models.CarouselItem;
import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    private List<CarouselItem> carouselItems;

    public CarouselAdapter(List<CarouselItem> carouselItems) {
        this.carouselItems = carouselItems;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carousel, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        CarouselItem item = carouselItems.get(position);
        holder.textCarouselTitle.setText(item.getTitle());
        holder.textCarouselSubtitle.setText(item.getSubtitle());
        holder.imageCarousel.setImageResource(item.getImageResource());
        holder.layoutCarouselBackground.setBackgroundColor(Color.parseColor(item.getBackgroundColor()));
    }

    @Override
    public int getItemCount() {
        return carouselItems.size();
    }

    static class CarouselViewHolder extends RecyclerView.ViewHolder {
        TextView textCarouselTitle, textCarouselSubtitle;
        ImageView imageCarousel;
        LinearLayout layoutCarouselBackground;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            textCarouselTitle = itemView.findViewById(R.id.textCarouselTitle);
            textCarouselSubtitle = itemView.findViewById(R.id.textCarouselSubtitle);
            imageCarousel = itemView.findViewById(R.id.imageCarousel);
            layoutCarouselBackground = itemView.findViewById(R.id.layoutCarouselBackground);
        }
    }
}
