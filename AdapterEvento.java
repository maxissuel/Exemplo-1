package adapter;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import gamerpg.desenvolvimento.max.gamerpg.R;
import model.Evento;

/**
 * Created by max on 05/07/2016.
 */
public class AdapterEvento extends BaseAdapter {

    private ArrayList<Evento> listaEvento;
    private Activity activity;

    public AdapterEvento(Activity activity, ArrayList<Evento> listaEvento){
        this.activity = activity;
        this.listaEvento = listaEvento;
    }

    @Override
    public int getCount() {
        return listaEvento.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEvento.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){

        }

        TextView tvEvento = (TextView)convertView.findViewById(R.id.tv_evento);

        tvEvento.setGravity(Gravity.LEFT);
        return convertView;
    }
}
