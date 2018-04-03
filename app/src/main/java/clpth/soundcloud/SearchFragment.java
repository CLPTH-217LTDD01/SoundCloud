package clpth.soundcloud;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchFragment extends Fragment {
    ListView lvAndround;
    ArrayList<String>dsAndround;
    ArrayAdapter<String>adapterAndround;
    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void addEvents() {

    }
    private void addControls(View view) {
       lvAndround=view.findViewById(R.id.lvAndround);
       dsAndround=new ArrayList<>();
       dsAndround.addAll(Arrays.asList(getResources().getStringArray(R.array.arrAndround)));
       adapterAndround=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,dsAndround);
       lvAndround.setAdapter(adapterAndround);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        addControls(view);
        addEvents();
        return view;

    }

}
