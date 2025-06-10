package com.example.prm_project_final;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerCategories, recyclerProducts;
    private ViewPager2 viewPagerCarousel;
    private LinearLayout layoutIndicators;
    private BottomNavigationView bottomNavigation;
    private FloatingActionButton fabCart;

    private CategoryAdapter categoryAdapter;
    private ProductAdapter productAdapter;
    private CarouselAdapter carouselAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupCategories();
        setupCarousel();
        setupProducts();
        setupBottomNavigation();
    }

    private void initViews() {
        recyclerCategories = findViewById(R.id.recyclerCategories);
        recyclerProducts = findViewById(R.id.recyclerProducts);
        viewPagerCarousel = findViewById(R.id.viewPagerCarousel);
        layoutIndicators = findViewById(R.id.layoutIndicators);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        fabCart = findViewById(R.id.fabCart);
    }

    private void setupCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("KEMDI", R.drawable.category1));
        categories.add(new Category("CÀ PHÊ\nTRUYỀN THỐNG", R.drawable.category2));
        categories.add(new Category("CÀ PHÊ\nPHA MÁY", R.drawable.category3));
        categories.add(new Category("TRÀ", R.drawable.category1));
        categories.add(new Category("PHI", R.drawable.category2));

        categoryAdapter = new CategoryAdapter(categories);
        recyclerCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerCategories.setAdapter(categoryAdapter);
    }

    private void setupCarousel() {
        List<CarouselItem> carouselItems = new ArrayList<>();
        carouselItems.add(new CarouselItem("Cà Phê", "Tươi Tỉnh", R.drawable.product1, "#8B4513"));
        carouselItems.add(new CarouselItem("Freeze", "Mát Lạnh", R.drawable.banner2, "#4CAF50"));
        carouselItems.add(new CarouselItem("Trà", "Sáng Khoái", R.drawable.product3, "#FFC107"));

        carouselAdapter = new CarouselAdapter(carouselItems);
        viewPagerCarousel.setAdapter(carouselAdapter);

        setupCarouselIndicators(carouselItems.size());

        viewPagerCarousel.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateIndicators(position);
            }
        });
    }

    private void setupCarouselIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(getResources().getDrawable(R.drawable.indicator_active));
            indicators[i].setLayoutParams(layoutParams);
            layoutIndicators.addView(indicators[i]);
        }

        if (indicators.length > 0) {
            indicators[0].setImageDrawable(getResources().getDrawable(R.drawable.indicator_active));
        }
    }

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
        products.add(new Product("Phín Sữa Đá", "29,000 đ", R.drawable.product2));
        products.add(new Product("Trà Sen Vàng", "45,000 đ", R.drawable.product3));

        productAdapter = new ProductAdapter(products);
        recyclerProducts.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerProducts.setAdapter(productAdapter);
    }

    private void setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener(item -> {
            // Handle navigation item selection
            return true;
        });

        fabCart.setOnClickListener(v -> {
            // Handle cart button click
        });
    }
}