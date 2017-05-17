package hu.aut.example.composition.ui.all;

import android.content.Context;

import java.util.List;

import hu.aut.example.composition.composite.adapter.CompositeAdapter;
import hu.aut.example.composition.model.Delivery;
import hu.aut.example.composition.model.Header;
import hu.aut.example.composition.model.Listable;
import hu.aut.example.composition.ui.adapter.DeliveryViewType;
import hu.aut.example.composition.ui.adapter.HeaderAdapterDelegate;
import hu.aut.example.composition.ui.adapter.ReceiveAdapterDelegate;
import hu.aut.example.composition.ui.adapter.SendAdapterDelegate;

public class AllAdapter extends CompositeAdapter<Listable> {
    private List<Listable> listables;

    public AllAdapter(Context context, List<Listable> listables) {
        this.listables = listables;
        addAdapterDelegate(new SendAdapterDelegate(context, this));
        addAdapterDelegate(new ReceiveAdapterDelegate(context, this));
        addAdapterDelegate(new HeaderAdapterDelegate(context, this));
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
            } else {
                return DeliveryViewType.SEND;
            }
        } else if (listable instanceof Header) {
            return DeliveryViewType.HEADER;
        } else {
            throw new RuntimeException("Item type not supported;");
        }


    }

}


