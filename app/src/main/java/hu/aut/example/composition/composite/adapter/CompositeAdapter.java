package hu.aut.example.composition.composite.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = "CompositeAdapter";
    private List<AdapterDelegate> delegates = new ArrayList<AdapterDelegate>();

    protected void addAdapterDelegate(AdapterDelegate adapterDelegate) {
        delegates.add(adapterDelegate);
    }

    protected void removeAdapterDelegate(AdapterDelegate adapterDelegate) {
        delegates.remove(adapterDelegate);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (AdapterDelegate delegate : delegates) {
            if (delegate.getViewType() == viewType) {
                return delegate.onCreateViewHolder(parent);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        for (AdapterDelegate delegate : delegates) {
            if (delegate.getViewType() == getItemViewType(position)) {
                delegate.onBindViewHolder(holder, position);
            }
        }
        Log.e(TAG, "No adapter found for position:" + position + " with view type:" + getItemViewType(position));

    }

    public abstract T getItem(int position);
}
