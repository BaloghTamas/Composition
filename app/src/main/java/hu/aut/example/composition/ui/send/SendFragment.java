package hu.aut.example.composition.ui.send;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hu.aut.example.composition.R;
import hu.aut.example.composition.model.DeliveryRepository;
import hu.aut.example.composition.model.Listable;

public class SendFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    public SendFragment() {
        // Required empty public constructor
    }

    public static SendFragment newInstance() {
        return new SendFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        DeliveryRepository deliveryRepository = new DeliveryRepository();
        List<Listable> deliveryList = new ArrayList<>();
        deliveryList.addAll(deliveryRepository.getSendDelivery());

        SendAdapter adapter = new SendAdapter(getContext(), deliveryList);
        recyclerView.setAdapter(adapter);
    }

}
