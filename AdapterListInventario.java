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
import gamerpg.desenvolvimento.max.gamerpg.personagem.EquipamentoActivity;
import model.ItemPersonagem;

/**
 * Created by ADMIN on 28/06/2016.
 */
public class AdapterListInventario extends BaseAdapter {

    private EquipamentoActivity activity;
    private ArrayList<ItemPersonagem> items;
    private LayoutInflater layoutInflater;

    public AdapterListInventario(EquipamentoActivity activity, ArrayList<ItemPersonagem> items) {
        this.activity = activity;
        this.items = items;
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
            convertView = layoutInflater.inflate(R.layout.listview_inventario_personagem, null);
        }

        ItemPersonagem item = items.get(position);
        LinearLayout lnl_linearLayout = (LinearLayout) convertView.findViewById(R.id.lnl_inventario_itempersonagem);
        TextView descricao = (TextView) convertView.findViewById(R.id.tv_inventario_itempersonagem_descricao);
        TextView nivel = (TextView) convertView.findViewById(R.id.tv_inventario_itempersonagem_nivel);
        TextView quantidade = (TextView) convertView.findViewById(R.id.tv_inventario_itempersonagem_quantidade);
        descricao.setText(item.getDescricao());
        nivel.setText(item.getNivel()+"");
        quantidade.setText("x"+item.getQuantidade());

        if(item.getClasse() == 1)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_comum);
        else if(item.getClasse() == 2)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_raro);
        else if(item.getClasse() == 3)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_lendario);
        else if(item.getClasse() == 4)
            lnl_linearLayout.setBackgroundResource(R.drawable.selector_item_divino);

        lnl_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.selecionaItem(position, items.get(position).get_id());
            }
        });

        return convertView;
    }

}
