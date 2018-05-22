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
        productImagesModels.add("https://www.citrus.ua/upload/new_iblock/a2f/b38b8ade3a3dbfb045ab02a7110be07a.jpg");
        productImagesModels.add("https://www.citrus.ua/upload/new_iblock/6c3/7b3abffc318145a9731db67b3830aa20.jpg");
        productImagesModels.add("https://www.citrus.ua/upload/new_iblock/60c/4a0aa2dcd84fa2ffdd0a9a58d22dc433.jpg");
        productImagesModels.add("https://www.citrus.ua/upload/new_iblock/f6e/c6e5cd64de916e72a0c92cd5bfe0b517.jpg");
        productImagesModels.add("https://www.citrus.ua/upload/new_iblock/e98/51fc06668435357af9423ba7170943f9.jpg");
        productImagesModels.add("https://www.citrus.ua/upload/new_iblock/f8a/920c8b495024bbc917022856f8786428.jpg");

        imageSliderWithPreviewView.setImageList(productImagesModels);
    }
}
