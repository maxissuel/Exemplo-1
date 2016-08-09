package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import gamerpg.desenvolvimento.max.gamerpg.R;
import model.Missao;

/**
 * Created by max on 21/06/2016.
 */
public class AdapterMissao extends BaseExpandableListAdapter {

    private List<String> listGroup;
    private HashMap<String, Missao> listData;
    private LayoutInflater layoutInflater;

    public AdapterMissao(Context context, List<String> listGroup, HashMap<String, Missao> listData){
        this.listGroup = listGroup;
        this.listData = listData;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listData.get(listGroup.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup holderGroup;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_view_expandable_group, null);
            holderGroup = new ViewHolderGroup();
            convertView.setTag(holderGroup);

            holderGroup.tvGroup = (TextView)convertView.findViewById(R.id.tv_expandable_group);
            holderGroup.imgArrow = (ImageView)convertView.findViewById(R.id.img_arrow);
        }
        else{
            holderGroup = (ViewHolderGroup) convertView.getTag();
        }
        Log.i("rpg", listGroup.get(groupPosition));
        holderGroup.tvGroup.setText(listGroup.get(groupPosition));

        if(!isExpanded){
            holderGroup.imgArrow.setRotationX(0f);
            holderGroup.imgArrow.setRotationY(0f);
        }
        else{
            holderGroup.imgArrow.setRotationX(180f);
            holderGroup.imgArrow.setRotationY(180f);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem holderItem;
        Missao val = (Missao)getChild(groupPosition, childPosition);
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_view_expandable_item, null);
            holderItem = new ViewHolderItem();
            convertView.setTag(holderItem);

            holderItem.tvDescricao = (TextView)convertView.findViewById(R.id.tv_expandable_item);
            holderItem.tvRecompensa = (TextView)convertView.findViewById(R.id.tv_recompensa);
            holderItem.tvNivel = (TextView)convertView.findViewById(R.id.tv_nivel_req);
        }
        else{
            holderItem = (ViewHolderItem)convertView.getTag();
        }

        holderItem.tvDescricao.setText(val.getDescricao());
        holderItem.tvNivel.setText(val.getNivelNecessario()+"");
        holderItem.tvRecompensa.setText(val.getDinheiro()+"gold");

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class ViewHolderGroup{
        TextView tvGroup;
        ImageView imgArrow;
    }

    class ViewHolderItem{
        TextView tvDescricao;
        TextView tvNivel;
        TextView tvRecompensa;
    }
}
