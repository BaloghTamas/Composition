package hu.aut.example.composition.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hu.aut.example.composition.R;
import hu.aut.example.composition.composite.adapter.AdapterDelegate;
import hu.aut.example.composition.composite.adapter.CompositeAdapter;
import hu.aut.example.composition.model.Header;


public class HeaderAdapterDelegate extends AdapterDelegate<HeaderAdapterDelegate.ViewHolder> {

    private final CompositeAdapter adapter;

    public HeaderAdapterDelegate(Context context, CompositeAdapter adapter) {
        super(context);
        this.adapter = adapter;
    }

    @Override
    public int getViewType() {
        return DeliveryViewType.HEADER;
    }

    @Override
    public HeaderAdapterDelegate.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View contentView = getInflater().inflate(R.layout.li_header, parent, false);
        return new ViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Header delivery = (Header) adapter.getItem(position);
        holder.titleTV.setText(delivery.getName());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV;


        ViewHolder(View v) {
            super(v);
            titleTV = (TextView) v.findViewById(R.id.titleTV);
        }
    }
}
