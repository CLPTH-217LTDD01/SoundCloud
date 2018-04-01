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
        ArrayList<Playlist> workout = new ArrayList<>();

        workout.add(new Playlist(R.drawable.pump_the_beat, ellipsize("PumpTheBeat.com Presents: Weekend Workout Vol. 17", 24), "Lowest Ends"));
        workout.add(new Playlist(R.drawable.workout_edm_10, ellipsize("Workout EDM 10", 24), "GusManke"));
        workout.add(new Playlist(R.drawable.work_out_or_get_out, ellipsize("Work out or get out", 24), "maddieparrot"));
        workout.add(new Playlist(R.drawable.run, ellipsize("Run", 24), "YVK7"));
        workout.add(new Playlist(R.drawable.no_pain_no_gain, ellipsize("Savage Mode", 24), "Tristen"));
        workout.add(new Playlist(R.drawable.run_it_out, ellipsize("Run It Out | thewaywardwalrus.com", 24), "The Wayward Walrus"));

        PlaylistRecyclerAdapter workoutAdapter = new PlaylistRecyclerAdapter(workout);
        //------------------------------------------------------------------------------------------

        //--------------------------------------Party---------------------------------------------
        ArrayList<Playlist> party = new ArrayList<>();

        party.add(new Playlist(R.drawable.saxxy_deep_house, ellipsize("Saxxy Deep House (2018 Sping Collection)", 24), "Westcoast Radio (EDM)"));
        party.add(new Playlist(R.drawable.chill_vibes, ellipsize("CHILL VIBES", 24), "3sUP"));
        party.add(new Playlist(R.drawable.grooveey_danceyy, ellipsize("Grooveey danceyy", 24), "*seba*"));
        party.add(new Playlist(R.drawable.youre_welcome, ellipsize("You're welcome", 24), "MattRaith"));
        party.add(new Playlist(R.drawable.yawk, ellipsize("Yawk", 24), "TeamDr"));
        party.add(new Playlist(R.drawable.summer_fireworks, ellipsize("Summer Fireworks", 24), "Heather."));

        PlaylistRecyclerAdapter partyAdapter = new PlaylistRecyclerAdapter(party);
        //------------------------------------------------------------------------------------------

        //----------------------------------------Relax---------------------------------------------
        ArrayList<Playlist> relax = new ArrayList<>();

        relax.add(new Playlist(R.drawable.relaxing_sunday_mornings, ellipsize("Relaxing Sunday Mornings - An Indie/Folk/Pop Playlist | Vol. 1", 24), "alexrainbirdMusic"));
        relax.add(new Playlist(R.drawable.chill_vibes, ellipsize("CHILL VIBES", 24), "3sUP"));
        relax.add(new Playlist(R.drawable.grooveey_danceyy, ellipsize("Grooveey danceyy", 24), "*seba*"));
        relax.add(new Playlist(R.drawable.youre_welcome, ellipsize("You're welcome", 24), "MattRaith"));
        relax.add(new Playlist(R.drawable.yawk, ellipsize("Yawk", 24), "TeamDr"));
        relax.add(new Playlist(R.drawable.summer_fireworks, ellipsize("Summer Fireworks", 24), "Heather."));

        PlaylistRecyclerAdapter relaxAdapter = new PlaylistRecyclerAdapter(relax);
        //------------------------------------------------------------------------------------------

        //----------------------------------------Study---------------------------------------------
        ArrayList<Playlist> study = new ArrayList<>();

        study.add(new Playlist(R.drawable.stellas_coffee_house, ellipsize("Stella's Coffee House", 24), "Mah"));
        study.add(new Playlist(R.drawable.tropixaton, ellipsize("Tropixaton | Finals Antidote vol. 3", 24), "GoodVibesOnly"));
        study.add(new Playlist(R.drawable.music_for_concentration, ellipsize("Music For Concentration", 24), "Tracklist"));
        study.add(new Playlist(R.drawable.study, ellipsize("Study Study Study Study", 24), "AgentOxygen"));
        study.add(new Playlist(R.drawable.study_electronic_chill, ellipsize("Study Electronic Chill", 24), "Randy Gerard C R"));
        study.add(new Playlist(R.drawable.rainy_day, ellipsize("Rainy Day", 24), "so.phree"));

        PlaylistRecyclerAdapter studyAdapter = new PlaylistRecyclerAdapter(study);
        //------------------------------------------------------------------------------------------

        //------------------------------------------Sleep-------------------------------------------
        ArrayList<Playlist> sleep = new ArrayList<>();

        sleep.add(new Playlist(R.drawable.sleep, ellipsize("Sleep", 24), "Kyler Smith1"));
        sleep.add(new Playlist(R.drawable.sleeping_n_high, ellipsize("Sleeping & High Brain Cells List", 24), "Thomas"));
        sleep.add(new Playlist(R.drawable.bed_time_blues, ellipsize("Bed Time Blues", 24), "*maddxe*"));
        sleep.add(new Playlist(R.drawable.new_rap_n_edm, ellipsize("New Rap & EDM (Top 20) 2018", 24), "Westcoast Radio (EDM)"));
        sleep.add(new Playlist(R.drawable.best_chill_trap, ellipsize("Best Chill Trap of 2018 (Mixtape)", 24), "Westcoast Radio (EDM)"));
        sleep.add(new Playlist(R.drawable.sad_sleep_songs, ellipsize("Sad/Sleep songs", 24), "Marcelinethevampirequeen."));

        PlaylistRecyclerAdapter sleepAdapter = new PlaylistRecyclerAdapter(sleep);
        //------------------------------------------------------------------------------------------

        //-------------------------------------Charts: New & Hot------------------------------------
        ArrayList<Playlist> charts = new ArrayList<>();

        charts.add(new Playlist(R.drawable.all_music_genres, ellipsize("All music genres", 24), "New & Hot"));
        charts.add(new Playlist(R.drawable.ambient, ellipsize("Ambient", 24), "New & Hot"));
        charts.add(new Playlist(R.drawable.country, ellipsize("Country", 24), "New & Hot"));
        charts.add(new Playlist(R.drawable.dance_n_edm, ellipsize("Dance & EDM", 24), "New & Hot"));
        charts.add(new Playlist(R.drawable.drum_n_bass, ellipsize("Drum & Bass", 24), "New & Hot"));
        charts.add(new Playlist(R.drawable.dubstep, ellipsize("Dubstep", 24), "New & Hot"));

        PlaylistRecyclerAdapter chartsAdapter = new PlaylistRecyclerAdapter(charts);
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

    String ellipsize(String input, int maxLength) {
        String ellip = "...";
        if (input == null || input.length() <= maxLength || input.length() < ellip.length()) {
            return input;
        }
        return input.substring(0, maxLength - ellip.length()).concat(ellip);
    }
}
