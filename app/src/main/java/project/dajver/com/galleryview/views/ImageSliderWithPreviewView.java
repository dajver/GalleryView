package project.dajver.com.galleryview.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.dajver.com.galleryview.R;
import project.dajver.com.galleryview.adapters.ImageSliderPagerAdapter;
import project.dajver.com.galleryview.adapters.ImageThumbsRecyclerView;

public class ImageSliderWithPreviewView extends LinearLayout implements ImageThumbsRecyclerView.OnItemClickListener,
        ViewPager.OnPageChangeListener {

    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.imagesRecyclerView)
    RecyclerView imageThumbsRecyclerView;

    private Context context;
    private ImageThumbsRecyclerView thumbsRecyclerView;

    public ImageSliderWithPreviewView(Context context) {
        super(context);
        init(context);
    }

    public ImageSliderWithPreviewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageSliderWithPreviewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        inflate(context, R.layout.view_image_slider_with_preview, this);
        ButterKnife.bind(this);
    }

    public void setImageList(List<String> imageList) {
        if(imageList != null && imageList.size() > 0) {
            viewPager.setAdapter(new ImageSliderPagerAdapter(context, imageList));
            viewPager.addOnPageChangeListener(this);
            thumbsRecyclerView = new ImageThumbsRecyclerView(context, imageList);
            thumbsRecyclerView.setOnItemClickListener(this);
            imageThumbsRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            imageThumbsRecyclerView.setAdapter(thumbsRecyclerView);
        }
    }

    @Override
    public void onItemClick(String catalogModel, int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        thumbsRecyclerView.setCurrentItemActive(position);
    }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) {  }
}