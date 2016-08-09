package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import gamerpg.desenvolvimento.max.gamerpg.MenuPrincipalActivity;
import gamerpg.desenvolvimento.max.gamerpg.R;
import gamerpg.desenvolvimento.max.gamerpg.personagem.ListaPersonagemActivity;
import model.Personagem;

/**
 * Created by max on 15/06/2016.
 */
public class AdapterPersonagem extends BaseAdapter {

    private ListaPersonagemActivity activityListaPersonagem;
    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<Personagem> listaPersonagem;

    public AdapterPersonagem(ListaPersonagemActivity activity, List<Personagem> listaPersonagem) {
        this.activityListaPersonagem = activity;
        this.activity = activity;
        this.listaPersonagem = listaPersonagem;
    }

    public AdapterPersonagem(Activity activity, List<Personagem> listaPersonagem) {
        this.activity = activity;
        this.activityListaPersonagem = null;
        this.listaPersonagem = listaPersonagem;
    }

    @Override
    public int getCount() {
        return listaPersonagem.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPersonagem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(layoutInflater == null){
            layoutInflater = (LayoutInflater)activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_personagem, null);
        }
        ImageView imgClasse = (ImageView)convertView.findViewById(R.id.img_classe);
        TextView tvNomePersonagem = (TextView)convertView.findViewById(R.id.tv_nomePersonagem);
        TextView tvClasse = (TextView)convertView.findViewById(R.id.tv_classe);
        TextView tvNivel = (TextView)convertView.findViewById(R.id.tv_nivel);
        TextView tvExp = (TextView)convertView.findViewById(R.id.tv_exp);
        LinearLayout lnlPersonagem = (LinearLayout)convertView.findViewById(R.id.lnl_personagem);

        tvNomePersonagem.setText(listaPersonagem.get(position).getNome());
        tvClasse.setText(listaPersonagem.get(position).getClasse());
        tvNivel.setText(listaPersonagem.get(position).getNivel()+"");
        tvExp.setText(listaPersonagem.get(position).getExp()+"");

        if(listaPersonagem.get(position).getGenero() == 1){
            switch (listaPersonagem.get(position).getClasse()){
                case "Arqueiro":
                    imgClasse.setImageResource(R.drawable.archer_m);
                    break;
                case "Guerreiro":
                    imgClasse.setImageResource(R.drawable.warrior_m);
                    break;
                case "Mago":
                    imgClasse.setImageResource(R.drawable.wizard_m);
                    break;
            }
        }
        else{
            switch (listaPersonagem.get(position).getClasse()){
                case "Arqueiro":
                    imgClasse.setImageResource(R.drawable.archer_f);
                    break;
                case "Guerreiro":
                    imgClasse.setImageResource(R.drawable.warrior_f);
                    break;
                case "Mago":
                    imgClasse.setImageResource(R.drawable.wizard_f);
                    break;
            }
        }

        lnlPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(activityListaPersonagem != null)
                    activityListaPersonagem.selecionaPersonagem(listaPersonagem.get(position).getId());
            }
        });

        return convertView;
    }
}
