package org.netzd.volleydip;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Queue;

/**
 * Created by Alumno12 on 03/03/18.
 */

public class VolleyService {
    private static VolleyService volleyService = null; //Encargado de hacer todas la peticiones y entregar la información

    private RequestQueue requestQueue = null; //Cola de peticiones

    private VolleyService(Context context){
        requestQueue= Volley.newRequestQueue(context);
    }

    public static VolleyService getInstance(Context context){
        if(volleyService == null){
            volleyService = new VolleyService(context);
        }
        return volleyService; //Permite instanciar el objeto VolleyService
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }

    //Agregamos peticion a la cola
    public <T> void addRequest(Request<T> request){
        requestQueue.add(request);
    }
}
