package ru.vaszol.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.vaszol.e_commerce.adapter.CategoryAdapter;
import ru.vaszol.e_commerce.adapter.CourseAdapter;
import ru.vaszol.e_commerce.model.Category;
import ru.vaszol.e_commerce.model.Course;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new LinkedList<>();
    static List<Course> fullCourseList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new LinkedList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "1 января", "начальный", "#424345", "test", 3));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "10 января", "начальный", "#9FA52D", "test", 3));
        courseList.add(new Course(3, "unity", "Профессия Unity\nразработчик", "10 января", "начальный", "#DB4254", "test", 1));
        courseList.add(new Course(4, "front_end", "Профессия Front-end\nразработчик", "10 января", "начальный", "#B14935", "test", 2));
        courseList.add(new Course(5, "back_end", "Профессия Back-end\nразработчик", "10 января", "начальный", "#2C55A6", "test", 2));
        courseList.add(new Course(6, "full_stack", "Профессия Full Stack\nразработчик", "10 января", "начальный", "#0D0F29", "test", 2));

        fullCourseList.addAll(courseList);

        setCourseRecycler(courseList);

        ImageButton showAllCourses = findViewById(R.id.showAllCourses);
        showAllCourses.setOnClickListener(v -> {
            showCoursesCategory(0);
        });
    }

    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OderPage.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesCategory(int category) {
        courseList.clear();
        courseList.addAll(fullCourseList);

        if (category != 0) {
            List<Course> filterCourses = new LinkedList<>();
            for (Course c : courseList) {
                if (c.getCategory() == category)
                    filterCourses.add(c);
            }

            courseList.clear();
            courseList.addAll(filterCourses);
        }

        courseAdapter.notifyDataSetChanged();
    }
}