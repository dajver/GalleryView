package project.dajver.com.galleryview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.dajver.com.galleryview.views.ImageSliderWithPreviewView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageSliderView)
    ImageSliderWithPreviewView imageSliderWithPreviewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<String> productImagesModels = new ArrayList<>();
        productImagesModels.add("https://github.com/dajver/GalleryView/blob/master/imgs/image1.jpg?raw=true");
        productImagesModels.add("https://github.com/dajver/GalleryView/blob/master/imgs/image2.jpg?raw=true");
        productImagesModels.add("https://github.com/dajver/GalleryView/blob/master/imgs/image3.jpg?raw=true");
        productImagesModels.add("https://github.com/dajver/GalleryView/blob/master/imgs/image4.jpg?raw=true");
        productImagesModels.add("https://github.com/dajver/GalleryView/blob/master/imgs/image5.jpg?raw=true");
        productImagesModels.add("https://github.com/dajver/GalleryView/blob/master/imgs/image6.jpg?raw=true");

        imageSliderWithPreviewView.setImageList(productImagesModels);
    }
}
