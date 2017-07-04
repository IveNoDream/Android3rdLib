package com.wafe.android3rdlib.thirdpartylibs.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wafe.android3rdlib.util.LogUtils;
import com.wafe.android3rdlib.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 2/6/17.
 */
public class RVAdapter extends RecyclerView.Adapter<RVBaseViewHolder> {
    private final static String TAG = "RVAdapter";

    private LayoutInflater inflater;
    List<Integer> types = new ArrayList<>();
    List<RVDataModelOne> list1 = new ArrayList<>();
    List<RVDataModelTwo> list2 = new ArrayList<>();
    List<RVDataModelThree> list3 = new ArrayList<>();

    private Map<Integer,Integer> mPositions = new HashMap<>();
    public void setDatas(List<RVDataModelOne> list1, List<RVDataModelTwo> list2, List<RVDataModelThree> list3){
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        addListByType(RVDataModel.TYPE_ONE,list1);
        addListByType(RVDataModel.TYPE_TWO,list2);
        addListByType(RVDataModel.TYPE_THREE,list3);
    }

    private void addListByType(int type, List list) {
        mPositions.put(type,types.size());//use for realposition,calculate how many types insert before current list add
        for (int i = 0; i < list.size(); i++){
            types.add(type);
        }
    }

    public RVAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case RVDataModel.TYPE_ONE:
                return new RVViewHolderOne(inflater.inflate(R.layout.rv_item_type1,parent,false));
            case RVDataModel.TYPE_TWO:
                return new RVViewHolderTwo(inflater.inflate(R.layout.rv_item_type2,parent,false));
            case RVDataModel.TYPE_THREE:
                return new RVViewHolderThree(inflater.inflate(R.layout.rv_item_type3,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPosition = position - mPositions.get(viewType);//the real position in current list
        LogUtils.i(TAG,"viewType: " + viewType + ", position: " + position + ", realPos: " + realPosition);
        switch (viewType) {
            case RVDataModel.TYPE_ONE:
                ((RVViewHolderOne)holder).bingHolder(list1.get(realPosition));
                break;
            case RVDataModel.TYPE_TWO:
                ((RVViewHolderTwo)holder).bingHolder(list2.get(realPosition));
                break;
            case RVDataModel.TYPE_THREE:
                ((RVViewHolderThree)holder).bingHolder(list3.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
