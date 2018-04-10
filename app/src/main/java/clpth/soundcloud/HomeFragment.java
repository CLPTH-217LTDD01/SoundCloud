package clpth.soundcloud;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryRecyclerAdapter categoryRecyclerAdapter;
    private ArrayList<Category> categories = new ArrayList<>();

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //--------------------------------------Workout---------------------------------------------
        ArrayList<Album> workout = new ArrayList<>();

        workout.add(new Album(R.drawable.pump_the_beat, "PumpTheBeat.com Presents: Weekend Workout Vol. 17", "Lowest Ends"));
        workout.add(new Album(R.drawable.workout_edm_10, "Workout EDM 10", "GusManke"));
        workout.add(new Album(R.drawable.work_out_or_get_out, "Work out or get out", "maddieparrot"));
        workout.add(new Album(R.drawable.run, "Run", "YVK7"));
        workout.add(new Album(R.drawable.no_pain_no_gain, "Savage Mode", "Tristen"));
        workout.add(new Album(R.drawable.run_it_out, "Run It Out | thewaywardwalrus.com", "The Wayward Walrus"));

        AlbumRecyclerAdapter workoutAdapter = new AlbumRecyclerAdapter(workout);
        //------------------------------------------------------------------------------------------

        //--------------------------------------Party---------------------------------------------
        ArrayList<Album> party = new ArrayList<>();

        party.add(new Album(R.drawable.saxxy_deep_house, "Saxxy Deep House (2018 Sping Collection)", "Westcoast Radio (EDM)"));
        party.add(new Album(R.drawable.chill_vibes, "CHILL VIBES", "3sUP"));
        party.add(new Album(R.drawable.grooveey_danceyy, "Grooveey danceyy", "*seba*"));
        party.add(new Album(R.drawable.youre_welcome, "You're welcome", "MattRaith"));
        party.add(new Album(R.drawable.yawk, "Yawk", "TeamDr"));
        party.add(new Album(R.drawable.summer_fireworks, "Summer Fireworks", "Heather."));

        AlbumRecyclerAdapter partyAdapter = new AlbumRecyclerAdapter(party);
        //------------------------------------------------------------------------------------------

        //----------------------------------------Relax---------------------------------------------
        ArrayList<Album> relax = new ArrayList<>();

        relax.add(new Album(R.drawable.relaxing_sunday_mornings, "Relaxing Sunday Mornings - An Indie/Folk/Pop Album | Vol. 1", "alexrainbirdMusic"));
        relax.add(new Album(R.drawable.chill_vibes, "CHILL VIBES", "3sUP"));
        relax.add(new Album(R.drawable.grooveey_danceyy, "Grooveey danceyy", "*seba*"));
        relax.add(new Album(R.drawable.youre_welcome, "You're welcome", "MattRaith"));
        relax.add(new Album(R.drawable.yawk, "Yawk", "TeamDr"));
        relax.add(new Album(R.drawable.summer_fireworks, "Summer Fireworks", "Heather."));

        AlbumRecyclerAdapter relaxAdapter = new AlbumRecyclerAdapter(relax);
        //------------------------------------------------------------------------------------------

        //----------------------------------------Study---------------------------------------------
        ArrayList<Album> study = new ArrayList<>();

        study.add(new Album(R.drawable.stellas_coffee_house, "Stella's Coffee House", "Mah"));
        study.add(new Album(R.drawable.tropixaton, "Tropixaton | Finals Antidote vol. 3", "GoodVibesOnly"));
        study.add(new Album(R.drawable.music_for_concentration, "Music For Concentration", "Tracklist"));
        study.add(new Album(R.drawable.study, "Study Study Study Study", "AgentOxygen"));
        study.add(new Album(R.drawable.study_electronic_chill, "Study Electronic Chill", "Randy Gerard C R"));
        study.add(new Album(R.drawable.rainy_day, "Rainy Day", "so.phree"));

        AlbumRecyclerAdapter studyAdapter = new AlbumRecyclerAdapter(study);
        //------------------------------------------------------------------------------------------

        //------------------------------------------Sleep-------------------------------------------
        ArrayList<Album> sleep = new ArrayList<>();

        sleep.add(new Album(R.drawable.sleep, "Sleep", "Kyler Smith1"));
        sleep.add(new Album(R.drawable.sleeping_n_high, "Sleeping & High Brain Cells List", "Thomas"));
        sleep.add(new Album(R.drawable.bed_time_blues, "Bed Time Blues", "*maddxe*"));
        sleep.add(new Album(R.drawable.new_rap_n_edm, "New Rap & EDM (Top 20) 2018", "Westcoast Radio (EDM)"));
        sleep.add(new Album(R.drawable.best_chill_trap, "Best Chill Trap of 2018 (Mixtape)", "Westcoast Radio (EDM)"));
        sleep.add(new Album(R.drawable.sad_sleep_songs, "Sad/Sleep songs", "Marcelinethevampirequeen."));

        AlbumRecyclerAdapter sleepAdapter = new AlbumRecyclerAdapter(sleep);
        //------------------------------------------------------------------------------------------

        //-------------------------------------Charts: New & Hot------------------------------------
        ArrayList<Album> charts = new ArrayList<>();

        charts.add(new Album(R.drawable.all_music_genres, "All music genres", "New & Hot"));
        charts.add(new Album(R.drawable.ambient, "Ambient", "New & Hot"));
        charts.add(new Album(R.drawable.country, "Country", "New & Hot"));
        charts.add(new Album(R.drawable.dance_n_edm, "Dance & EDM", "New & Hot"));
        charts.add(new Album(R.drawable.drum_n_bass, "Drum & Bass", "New & Hot"));
        charts.add(new Album(R.drawable.dubstep, "Dubstep", "New & Hot"));

        AlbumRecyclerAdapter chartsAdapter = new AlbumRecyclerAdapter(charts);
        //------------------------------------------------------------------------------------------

        //Category
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rvCategory);

        categories.add(new Category("Workout", "Popular playlists from the SoundCloud community", workoutAdapter));
        categories.add(new Category("Party", "Popular playlists from the SoundCloud community", partyAdapter));
        categories.add(new Category("Relax", "Popular playlists from the SoundCloud community", relaxAdapter));
        categories.add(new Category("Study", "Popular playlists from the SoundCloud community", studyAdapter));
        categories.add(new Category("Sleep", "Popular playlists from the SoundCloud community", sleepAdapter));
        categories.add(new Category("Charts: New & Hot", "Up-and-coming tracks on SoundCloud", chartsAdapter));


        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        categoryRecyclerAdapter = new CategoryRecyclerAdapter(categories);
        DividerItemDecoration decoration = new DividerItemDecoration(getResources(), 20);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(categoryRecyclerAdapter);

        return rootView;
    }

}
