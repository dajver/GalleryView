package project.dajver.com.galleryview.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.dajver.com.galleryview.R;

public class ImageSliderPagerAdapter extends PagerAdapter {

    private List<String> images;
    private LayoutInflater inflater;
    private Context context;

    public ImageSliderPagerAdapter(Context context, List<String> images) {
        this.context = context;
        this.images=images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.item_image_slider, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        Picasso.get().load(images.get(position)).into(viewHolder.image);
        viewGroup.addView(view, 0);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    public class ViewHolder {

        @BindView(R.id.image)
        ImageView image;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}