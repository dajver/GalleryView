package project.dajver.com.galleryview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.dajver.com.galleryview.R;

public class ImageThumbsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<View> selectedViews = new ArrayList<>();
    private List<View> allViews = new ArrayList<>();
    private List<String> productImagesModels;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public ImageThumbsRecyclerAdapter(Context context, List<String> productImagesModels) {
        this.context = context;
        this.productImagesModels = productImagesModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_image_thumbs, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ReceiveViewHolder viewHolder = (ReceiveViewHolder) holder;
        Picasso.get().load(productImagesModels.get(position)).into(viewHolder.image);
        allViews.add(viewHolder.itemView);
    }

    @Override
    public int getItemCount() {
        return productImagesModels.size();
    }

    public void setCurrentItemActive(int position) {
        for(int i = 0; i < selectedViews.size(); i++) {
            selectedViews.remove(i).setSelected(false);
        }
        selectedViews.add(allViews.get(position));
        allViews.get(position).setSelected(true);
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;

        public ReceiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {
                for(int i = 0; i < selectedViews.size(); i++) {
                    selectedViews.remove(i).setSelected(false);
                }
                selectedViews.add(itemView);
                itemView.setSelected(true);
                onItemClickListener.onItemClick(productImagesModels.get(getAdapterPosition()), getAdapterPosition());
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(String imagePath, int position);
    }
}