package com.example.prm_project_final;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.example.prm_project_final.adapter.CarouselAdapter;
import com.example.prm_project_final.adapter.CategoryAdapter;
import com.example.prm_project_final.adapter.ProductAdapter;
import com.example.prm_project_final.models.CarouselItem;
import com.example.prm_project_final.models.Category;
import com.example.prm_project_final.models.Product;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerCategories, recyclerProducts;
    private ViewPager2 viewPagerCarousel;
    private LinearLayout layoutIndicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        setupCategories();
        setupCarousel();
        setupProducts();
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getCurrentTabIndex() {
        return 0;
    }

    private void initViews() {
        recyclerCategories = findViewById(R.id.recyclerCategories);
        recyclerProducts = findViewById(R.id.recyclerProducts);
        viewPagerCarousel = findViewById(R.id.viewPagerCarousel);
        layoutIndicators = findViewById(R.id.layoutIndicators);
    }

    private void setupCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("KEMDI", R.drawable.category1));
        categories.add(new Category("CÀ PHÊ\nTRUYỀN THỐNG", R.drawable.category2));
        categories.add(new Category("CÀ PHÊ\nPHA MÁY", R.drawable.category3));
        categories.add(new Category("TRÀ", R.drawable.category1));
        categories.add(new Category("PHI", R.drawable.category2));

        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        recyclerCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerCategories.setAdapter(categoryAdapter);
    }

    private void setupCarousel() {
        List<CarouselItem> carouselItems = new ArrayList<>();
        carouselItems.add(new CarouselItem("Cà Phê", "Tươi Tỉnh", R.drawable.banner1, "#8B4513"));
        carouselItems.add(new CarouselItem("Freeze", "Mát Lạnh", R.drawable.banner1, "#4CAF50"));
        carouselItems.add(new CarouselItem("Trà", "Sảng Khoái", R.drawable.banner1, "#FFC107"));

        CarouselAdapter carouselAdapter = new CarouselAdapter(carouselItems);
        viewPagerCarousel.setAdapter(carouselAdapter);

        setupCarouselIndicators(carouselItems.size());

        viewPagerCarousel.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateIndicators(position);
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setupCarouselIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(getResources().getDrawable(
                    R.drawable.indicator_active
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutIndicators.addView(indicators[i]);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void updateIndicators(int position) {
        for (int i = 0; i < layoutIndicators.getChildCount(); i++) {
            ImageView indicator = (ImageView) layoutIndicators.getChildAt(i);
            if (i == position) {
                indicator.setImageDrawable(getResources().getDrawable(R.drawable.indicator_active));
            } else {
                indicator.setImageDrawable(getResources().getDrawable(R.drawable.indicator_active));
            }
        }
    }

    private void setupProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Freeze Trà Xanh", "55,000 đ", R.drawable.product1));
        products.add(new Product("Phín Sữa Đá", "29,000 đ", R.drawable.product1));
        products.add(new Product("Trà Sen Vàng", "45,000 đ", R.drawable.product1));
        products.add(new Product("Trà Sen Bạc", "35,000 đ", R.drawable.product1));

        ProductAdapter productAdapter = new ProductAdapter(products);
        recyclerProducts.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerProducts.setAdapter(productAdapter);
    }
}
