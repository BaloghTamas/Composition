package hu.aut.example.composition.ui.all;

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
import hu.aut.example.composition.model.Header;
import hu.aut.example.composition.model.Listable;

public class AllFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    public AllFragment() {
        // Required empty public constructor
    }

    public static AllFragment newInstance() {
        return new AllFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_all, container, false);
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
        deliveryList.addAll(deliveryRepository.getAllDelivery());
        deliveryList.add(0, new Header(getString(R.string.header_today)));
        deliveryList.add(2, new Header(getString(R.string.header_next_week)));

        AllAdapter adapter = new AllAdapter(getContext(), deliveryList);
        recyclerView.setAdapter(adapter);
    }
}
