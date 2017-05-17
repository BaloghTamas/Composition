package hu.aut.example.composition.composite.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class AdapterDelegate<VH extends RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;

    public AdapterDelegate(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    protected LayoutInflater getInflater() {
        return inflater;
    }

    public abstract int getViewType();

    public abstract VH onCreateViewHolder(ViewGroup parent);

    public abstract void onBindViewHolder(VH holder, int position);
}
