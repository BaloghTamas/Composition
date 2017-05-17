package hu.aut.example.composition.ui.receive;

import android.content.Context;

import java.util.List;

import hu.aut.example.composition.composite.adapter.CompositeAdapter;
import hu.aut.example.composition.model.Delivery;
import hu.aut.example.composition.model.Listable;
import hu.aut.example.composition.ui.adapter.DeliveryViewType;
import hu.aut.example.composition.ui.adapter.ReceiveAdapterDelegate;

public class ReceiveAdapter extends CompositeAdapter<Listable> {
    private List<Listable> listables;

    public ReceiveAdapter(Context context, List<Listable> listables) {
        this.listables = listables;
        addAdapterDelegate(new ReceiveAdapterDelegate(context, this));
    }

    @Override
    public int getItemCount() {
        return listables.size();
    }

    @Override
    public Listable getItem(int position) {
        return listables.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        Listable listable = getItem(position);
        if (listable instanceof Delivery) {
            Delivery delivery = (Delivery) listable;
            if (delivery.isReceive()) {
                return DeliveryViewType.RECEIVE;
            }
        }
        throw new RuntimeException("Item type not supported;");
    }

}

