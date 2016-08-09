package adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gamerpg.desenvolvimento.max.gamerpg.R;
import model.Classe;

/**
 * Created by max on 14/06/2016.
 */
public class AdapterClasse extends BaseAdapter{
    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<Classe> listaClasse;
    private int genero;
    public AdapterClasse(Activity activity, List<Classe> listaClasse, int genero){
        this.activity = activity;
        this.listaClasse = listaClasse;
        this.genero = genero;
    }

    @Override
    public int getCount() {
        return listaClasse.size();
    }

    @Override
    public Object getItem(int position) {
        return listaClasse.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(layoutInflater == null){
            layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_classe, null);
        }

        ImageView imgClasse = (ImageView)convertView.findViewById(R.id.img_classe);
        TextView tvNomeClasse = (TextView)convertView.findViewById(R.id.tv_nome_classe);
        TextView tvHpClasse = (TextView)convertView.findViewById(R.id.tv_hp_classe);
        TextView tvMpClasse = (TextView)convertView.findViewById(R.id.tv_mp_classe);
        TextView tvSpClasse = (TextView)convertView.findViewById(R.id.tv_sp_classe);
        TextView tvDefesaClasse = (TextView)convertView.findViewById(R.id.tv_defesa_classe);
        TextView tvForcaClasse = (TextView)convertView.findViewById(R.id.tv_forca_classe);
        TextView tvAgilidadeClasse = (TextView)convertView.findViewById(R.id.tv_agilidade_classe);
        TextView tvVitalidadeClasse = (TextView)convertView.findViewById(R.id.tv_vitalidade_classe);
        TextView tvInteligenciaClasse = (TextView)convertView.findViewById(R.id.tv_inteligencia_classe);
        TextView tvSorteClasse = (TextView)convertView.findViewById(R.id.tv_sorte_classe);
        TextView tvDestrezaClasse = (TextView)convertView.findViewById(R.id.tv_destreza_classe);

        if(genero == 0) {
            if (listaClasse.get(position).getCodigo() == 1) {
                imgClasse.setImageResource(R.drawable.warrior_f);
            } else if (listaClasse.get(position).getCodigo() == 2) {
                imgClasse.setImageResource(R.drawable.wizard_f);
            } else if (listaClasse.get(position).getCodigo() == 3) {
                imgClasse.setImageResource(R.drawable.archer_f);
            }
        }
        else if (genero == 1){
            if(listaClasse.get(position).getCodigo() == 1){
                imgClasse.setImageResource(R.drawable.warrior_m);
            }
            else if(listaClasse.get(position).getCodigo() == 2){
                imgClasse.setImageResource(R.drawable.wizard_m);
            }
            else if(listaClasse.get(position).getCodigo() == 3){
                imgClasse.setImageResource(R.drawable.archer_m);
            }
        }

        tvNomeClasse.setText(listaClasse.get(position).getNome());
        tvHpClasse.setText(listaClasse.get(position).getHp()+"");
        tvMpClasse.setText(listaClasse.get(position).getMp()+"");
        tvSpClasse.setText(listaClasse.get(position).getSp()+"");
        tvDefesaClasse.setText(listaClasse.get(position).getDefesa()+"");
        tvForcaClasse.setText(listaClasse.get(position).getForca()+"");
        tvAgilidadeClasse.setText(listaClasse.get(position).getAgilidade()+"");
        tvVitalidadeClasse.setText(listaClasse.get(position).getVitalidade()+"");
        tvInteligenciaClasse.setText(listaClasse.get(position).getInteligencia()+"");
        tvSorteClasse.setText(listaClasse.get(position).getSorte()+"");
        tvDestrezaClasse.setText(listaClasse.get(position).getDestreza()+"");

        return convertView;
    }
}
