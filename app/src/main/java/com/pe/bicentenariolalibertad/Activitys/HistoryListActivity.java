package com.pe.bicentenariolalibertad.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pe.bicentenariolalibertad.Holder.HolderHistoryList;
import com.pe.bicentenariolalibertad.Model.CategoryActivity;
import com.pe.bicentenariolalibertad.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        RecyclerView recyclerHistoryList = findViewById(R.id.recyclerHistoryList);

        List<CategoryActivity> cat = new ArrayList<>();

        CategoryActivity personajeOne = new CategoryActivity();
        personajeOne.setImage(R.drawable.ic_caballitos);
        personajeOne.setName("Personajes");
        personajeOne.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeOne);

        CategoryActivity personajeTwo = new CategoryActivity();
        personajeTwo.setImage(R.drawable.ic_caballitos);
        personajeTwo.setName("Casonas");
        personajeTwo.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeTwo);

        CategoryActivity personajeThree = new CategoryActivity();
        personajeThree.setImage(R.drawable.ic_caballitos);
        personajeThree.setName("Lugares");
        personajeThree.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeThree);

        CategoryActivity personajeFour = new CategoryActivity();
        personajeFour.setImage(R.drawable.ic_caballitos);
        personajeFour.setName("Lugares");
        personajeFour.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeFour);

        CategoryActivity personajeFive = new CategoryActivity();
        personajeFive.setImage(R.drawable.ic_caballitos);
        personajeFive.setName("Lugares");
        personajeFive.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeFive);

        CategoryActivity personajeSix = new CategoryActivity();
        personajeSix.setImage(R.drawable.ic_caballitos);
        personajeSix.setName("Lugares");
        personajeSix.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeSix);

        CategoryActivity personajeSeven = new CategoryActivity();
        personajeSeven.setImage(R.drawable.ic_caballitos);
        personajeSeven.setName("Lugares");
        personajeSeven.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeSeven);

        CategoryActivity personajeEithg = new CategoryActivity();
        personajeEithg.setImage(R.drawable.ic_caballitos);
        personajeEithg.setName("Lugares");
        personajeEithg.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeEithg);

        CategoryActivity personajeNine = new CategoryActivity();
        personajeNine.setImage(R.drawable.ic_caballitos);
        personajeNine.setName("Lugares");
        personajeNine.setStory("The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.");
        cat.add(personajeNine);

    }


}
