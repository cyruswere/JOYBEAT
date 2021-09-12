  package com.cyruswere.joybeat_week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

  public class MusicActivity extends AppCompatActivity {
      ActivityMusicBinding binding;
      private TextView name;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_music);
          Intent intent = getIntent();

          //Set the title of the view dynamically.
          String userName = intent.getStringExtra("userName");
          this.setTitle("User Name : "+userName);

          binding = ActivityMusicBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());

          int[] imageId = {R.drawable.african,R.drawable.afrofusion,R.drawable.blues,R.drawable.christian,R.drawable.classical,
                  R.drawable.country,R.drawable.electro,R.drawable.fusion,R.drawable.jazz,
                  R.drawable.middle,R.drawable.novelty,R.drawable.reggea
          };
          String[] categoryName = {"African Music","Afro fusion","Blues","Christian Music","Classical Music",
                  "Country Music","Electro Music","World Fusion","Jazz Music","Middle East Music",
                  "Novelty Music","Reggae Music"
          };
          String[] categoryDescription = {
                  "African Music gives you the best of African voices.","" +
                  "Afro beat fused with traditional African melodies",
                  "You know how we do it with the rhythm and blues",
                  "Get the divine feeling.. deep into your soul.",
                  "The classical of the day, delivered to you, today",
                  "The country road.. never get tired of this.",
                  "Because you know it's all about the beat..",
                  "From all over the world",
                  "Jazz. smooth sweet Jazz Music",
                  "Middle eastern beats played from the finest of them all",
                  "For the novels, and the high born..",
                  "Nobody can sop reggae"
          };
          String[] numberOfSongs ={
                  "305 songs","417 songs","211 songs","108 songs","78 songs","137 songs",
                  "319 songs","405 songs","313 Songs","274 songs","213 songs","289 songs"
          };

          ArrayList<Category> categoryArrayList = new ArrayList<>();

          for(int i = 0; i<imageId.length;i++){
              Category category = new Category(categoryName[i],categoryDescription[i],numberOfSongs[i],imageId[i]);
              categoryArrayList.add(category);
          }
          CategoryListAdapter categoryListAdapter = new  CategoryListAdapter(MusicActivity.this,categoryArrayList);
          binding.musicAlbumList.setAdapter(categoryListAdapter);
          binding.musicAlbumList.setClickable(true);
          binding.musicAlbumList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Toast toast=Toast.makeText(getApplicationContext(),categoryDescription[position],Toast.LENGTH_SHORT);
                  toast.setMargin(50,50);
                  toast.show();
              }
          });

      }
  }