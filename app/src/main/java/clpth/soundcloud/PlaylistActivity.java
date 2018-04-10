package clpth.soundcloud;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        getSupportActionBar().setTitle("Playlist");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rlTop);
        TextView plName = (TextView) findViewById(R.id.plName);
        TextView plArtist = (TextView) findViewById(R.id.plArtist);
        ImageButton ibPlay = (ImageButton) findViewById(R.id.ibPlay);
        ImageButton ibMore = (ImageButton) findViewById(R.id.ibMore);

        relativeLayout.getLayoutParams().height = Resources.getSystem().getDisplayMetrics().widthPixels;

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        relativeLayout.setBackgroundResource(bundle.getInt("img"));
        plName.setText(bundle.getString("name"));
        plArtist.setText(bundle.getString("artist"));

        ibMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(PlaylistActivity.this, view);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.more_playlist_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
