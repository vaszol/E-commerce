package ru.vaszol.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.vaszol.e_commerce.adapter.CategoryAdapter;
import ru.vaszol.e_commerce.model.Category;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView categoryRecycler;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new LinkedList<>();
        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(1,"Сайты"));
        categoryList.add(new Category(1,"Языки"));
        categoryList.add(new Category(1,"Прочее"));

        setCategoryRecycler(categoryList);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}