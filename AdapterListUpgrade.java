package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import gamerpg.desenvolvimento.max.gamerpg.R;
import gamerpg.desenvolvimento.max.gamerpg.item.UpgradeActivity;
import model.ItemPersonagem;
import util.Calculos;

/**
 * Created by ADMIN on 28/06/2016.
 */
public class AdapterListUpgrade extends BaseAdapter {

    private UpgradeActivity activity;
    private ArrayList<ItemPersonagem> items;
    private LayoutInflater layoutInflater;
    private Calculos calculos;

    public AdapterListUpgrade(UpgradeActivity activity, ArrayList<ItemPersonagem> items) {
        this.activity = activity;
        this.items = items;
        this.calculos = new Calculos();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_upgrade_equipamento, null);
        }

        ItemPersonagem item = items.get(position);
        LinearLayout lnl_linearLayout = (LinearLayout) convertView.findViewById(R.id.lnl_upgrade_equipamento);
        TextView descricao = (TextView) convertView.findViewById(R.id.tv_upgrade_equipamento_descricao);
        TextView nivel = (TextView) convertView.findViewById(R.id.tv_upgrade_equipamento_nivel);
        TextView valor = (TextView) convertView.findViewById(R.id.tv_upgrade_equipamento_valor);
        descricao.setText(item.getDescricao());
        nivel.setText(item.getNivel()+"");
        valor.setText(calculos.calculaValorUpgrade(item.getClasse(), item.getNivel())+"");

        lnl_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.selecionaItem(position, items.get(position).get_id());
            }
        });

        if(item.getClasse() == 1)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_comum);
        else if(item.getClasse() == 2)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_raro);
        else if(item.getClasse() == 3)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_lendario);
        else if(item.getClasse() == 4)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_divino);


        return convertView;
    }

}
