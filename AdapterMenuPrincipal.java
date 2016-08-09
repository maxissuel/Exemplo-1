package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gamerpg.desenvolvimento.max.gamerpg.R;

/**
 * Created by max on 14/06/2016.
 */
public class AdapterMenuPrincipal extends BaseAdapter {
    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<String> listaOpcoes;

    public AdapterMenuPrincipal(Activity activity, List<String> listaOpcoes) {
        this.activity = activity;
        this.listaOpcoes = listaOpcoes;
    }

    @Override
    public int getCount() {
        return listaOpcoes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaOpcoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_menu_principal, null);
        }

        ImageView imgOpcao = (ImageView) convertView.findViewById(R.id.img_opcao);
        TextView tvNomeOpcao = (TextView) convertView.findViewById(R.id.tv_nome_opcao);


        if (listaOpcoes.get(position).equals("")) {
            imgOpcao.setImageResource(android.R.drawable.ic_menu_agenda);
        } else if (listaOpcoes.get(position).equals("")) {
            imgOpcao.setImageResource(android.R.drawable.ic_menu_agenda);
        } else if (listaOpcoes.get(position).equals("")) {
            imgOpcao.setImageResource(android.R.drawable.ic_menu_agenda);
        }

        tvNomeOpcao.setText(listaOpcoes.get(position).toString());


        return convertView;
    }
}
