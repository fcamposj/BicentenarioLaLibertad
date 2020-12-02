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
        personajeTwo.image = R.drawable.ic_caballitos;
        personajeTwo.name = "Casonas";
        personajeTwo.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeTwo);

        CategoryActivity personajeThree = new CategoryActivity();
        personajeThree.image = R.drawable.ic_caballitos;
        personajeThree.name = "Lugares";
        personajeThree.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeThree);

        CategoryActivity personajeFour = new CategoryActivity();
        personajeFour.image = R.drawable.ic_caballitos;
        personajeFour.name = "Lugares";
        personajeFour.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeFour);

        CategoryActivity personajeFive = new CategoryActivity();
        personajeFive.image = R.drawable.ic_caballitos;
        personajeFive.name = "Lugares";
        personajeFive.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeFive);

        CategoryActivity personajeSix = new CategoryActivity();
        personajeSix.image = R.drawable.ic_caballitos;
        personajeSix.name = "Lugares";
        personajeSix.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeSix);

        CategoryActivity personajeSeven = new CategoryActivity();
        personajeSeven.image = R.drawable.ic_caballitos;
        personajeSeven.name = "Lugares";
        personajeSeven.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeSeven);

        CategoryActivity personajeEithg = new CategoryActivity();
        personajeEithg.image = R.drawable.ic_caballitos;
        personajeEithg.name = "Lugares";
        personajeEithg.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeEithg);

        CategoryActivity personajeNine = new CategoryActivity();
        personajeNine.image = R.drawable.ic_caballitos;
        personajeNine.name = "Lugares";
        personajeNine.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earht.";
        cat.add(personajeNine);

    }


}
