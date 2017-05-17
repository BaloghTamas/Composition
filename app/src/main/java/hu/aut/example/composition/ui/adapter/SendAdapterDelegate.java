package hu.aut.example.composition.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hu.aut.example.composition.R;
import hu.aut.example.composition.composite.adapter.AdapterDelegate;
import hu.aut.example.composition.composite.adapter.CompositeAdapter;
import hu.aut.example.composition.model.Delivery;


public class SendAdapterDelegate extends AdapterDelegate<SendAdapterDelegate.ViewHolder> {

    private final CompositeAdapter adapter;

    public SendAdapterDelegate(Context context, CompositeAdapter adapter) {
        super(context);
        this.adapter = adapter;
    }

    @Override
    public int getViewType() {
        return DeliveryViewType.SEND;
    }

    @Override
    public SendAdapterDelegate.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View contentView = getInflater().inflate(R.layout.li_send, parent, false);
        return new ViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Delivery delivery = (Delivery) adapter.getItem(position);
        holder.titleTV.setText(delivery.getName());
        holder.descriptionTV.setText(delivery.getDescription());
        holder.statusTV.setText(delivery.getStatus());
        holder.dateTV.setText(delivery.getWhen());
        holder.toTV.setText(delivery.getTo());
        holder.priceTV.setText("" + delivery.getFee());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV;
        TextView descriptionTV;
        TextView statusTV;
        TextView dateTV;
        TextView toTV;
        TextView priceTV;

        ViewHolder(View v) {
            super(v);
            titleTV = (TextView) v.findViewById(R.id.titleTV);
            descriptionTV = (TextView) v.findViewById(R.id.descriptionTV);
            statusTV = (TextView) v.findViewById(R.id.statusTV);
            dateTV = (TextView) v.findViewById(R.id.dateTV);
            toTV = (TextView) v.findViewById(R.id.toTV);
            priceTV = (TextView) v.findViewById(R.id.priceTV);
        }
    }
}
