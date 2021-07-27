package ru.vaszol.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import ru.vaszol.e_commerce.model.Course;
import ru.vaszol.e_commerce.model.Order;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullCourseList) {
            if (Order.items_id.contains(c.getId())) {
                coursesTitle.add(c.getTitle());
            }
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
    }
}