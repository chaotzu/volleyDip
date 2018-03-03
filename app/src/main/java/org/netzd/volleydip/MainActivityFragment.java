package org.netzd.volleydip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView moviesRecyclerView = null;
    private ProgressBar moviesProgressBar = null;
    private List<Video> videos = null;

    private VolleyService volleyService = null;
    private RequestQueue requestQueue = null;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volleyService = VolleyService.getInstance(getContext()); //Instanciamos el objeto
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesRecyclerView = (RecyclerView) view.findViewById(R.id.moviesRecyclerView);
        moviesProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        moviesRecyclerView.setHasFixedSize(true);
        moviesRecyclerView.setLayoutManager(layoutManager);
        getVideos();
    }

    private void getVideos(){
        String url = "http://www.omdbapi.com/?s=superman&apikey=2b28d307&r=json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                Search search = gson.fromJson(response.toString(),Search.class);
                videos = search.getVideos();
                VideoAdapter videoAdapter = new VideoAdapter(videos, getActivity());
                moviesRecyclerView.setAdapter((videoAdapter));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "hubo un error", Toast.LENGTH_LONG).show();
            }
        });
        volleyService.addRequest(jsonObjectRequest);
    }
}

//Volley regresa jsonobjectrequest y jsonarrayrequest