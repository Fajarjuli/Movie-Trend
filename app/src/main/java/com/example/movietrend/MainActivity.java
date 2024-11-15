package com.example.movietrend;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
// MainActivity.java
import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerTrending, recyclerIndonesia, recyclerKoreanDrama;
    private MovieAdapter trendingAdapter, indonesiaAdapter, koreanDramaAdapter;
    private List<Integer> trendingMovies, indonesiaMovies, koreanDramaMovies;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi SearchView
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Logika untuk pencarian dapat ditambahkan di sini
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Logika pencarian real-time (opsional)
                return false;
            }
        });

        // Data Dummy untuk masing-masing kategori
        trendingMovies = new ArrayList<>();
        indonesiaMovies = new ArrayList<>();
        koreanDramaMovies = new ArrayList<>();

        // Tambahkan ID drawable gambar contoh
        trendingMovies.add(R.drawable.film_1);
        trendingMovies.add(R.drawable.film_1);

        indonesiaMovies.add(R.drawable.film_1);
        indonesiaMovies.add(R.drawable.film_1);

        koreanDramaMovies.add(R.drawable.film_1);
        koreanDramaMovies.add(R.drawable.film_1);

        // Inisialisasi RecyclerView
        recyclerTrending = findViewById(R.id.recyclerTrending);
        recyclerIndonesia = findViewById(R.id.recyclerIndonesia);
        recyclerKoreanDrama = findViewById(R.id.recyclerKoreanDrama);

        trendingAdapter = new MovieAdapter(this, trendingMovies);
        indonesiaAdapter = new MovieAdapter(this, indonesiaMovies);
        koreanDramaAdapter = new MovieAdapter(this, koreanDramaMovies);

        // Set layout dan adapter
        recyclerTrending.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerTrending.setAdapter(trendingAdapter);

        recyclerIndonesia.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerIndonesia.setAdapter(indonesiaAdapter);

        recyclerKoreanDrama.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerKoreanDrama.setAdapter(koreanDramaAdapter);
    }
}
