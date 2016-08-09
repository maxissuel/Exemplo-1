package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityRecord;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

import gamerpg.desenvolvimento.max.gamerpg.R;
import model.Skill;

/**
 * Created by max on 28/06/2016.
 */
public class AdapterGridBatalha extends BaseAdapter {

    private Context context;
    private List<Skill> listaSkill;
    private int[] drawablesListaSkill;

    public AdapterGridBatalha(Context context, List<Skill> listaSkill) {
        this.context = context;
        this.listaSkill = listaSkill;
        constroiListaDrawable();
    }

    public void constroiListaDrawable(){
        drawablesListaSkill = new int[listaSkill.size()];

        for(int i = 0; i < listaSkill.size(); i++){
            drawablesListaSkill[i] = listaSkill.get(i).getDrawable();
        }
    }

    @Override
    public int getCount() {
        return listaSkill.size();
    }

    @Override
    public Object getItem(int position) {
        return listaSkill.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageButton imageButton = new ImageButton(context);
        imageButton.setImageResource(drawablesListaSkill[position]);

        return imageButton;
    }
}
