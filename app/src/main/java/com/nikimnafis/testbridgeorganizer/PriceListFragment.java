package com.nikimnafis.testbridgeorganizer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PriceListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PriceListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridView gridView;

    String[] namaPaket = {"Paket Exclusive", "Paket Diamond", "Paket 1", "Paket 2",
            "Paket 3", "Paket 4"};
    int[] imagePaket = {R.drawable.eventparty, R.drawable.graduation, R.drawable.schoolparty, R.drawable.weddingstage,
            R.drawable.eventparty, R.drawable.graduation};
    int[] detailPaket = {R.string.lorem, R.string.lorem, R.string.lorem, R.string.lorem,
            R.string.lorem, R.string.lorem};
    String[] hargaPaket = {"Paket Exclusive : Rp 20.000.000,00", "Paket Diamond : Rp 17.500.000,00",
            "Paket 1 : Rp 15.000.000,00", "Paket 2 : Rp 14.000.000,00", "Paket 3 : Rp 12.500.000,00",
            "Paket 4 : Rp 8.000.000,00"};

    public PriceListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PriceListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PriceListFragment newInstance(String param1, String param2) {
        PriceListFragment fragment = new PriceListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_price_list, container, false);

        gridView = view.findViewById(R.id.gridViewPriceList);

        PriceListFragment.CustomAdapter customAdapter = new PriceListFragment.CustomAdapter(namaPaket, imagePaket, detailPaket, hargaPaket, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = namaPaket[i];
                int selectedImage = imagePaket[i];
                int selectedDetail = detailPaket[i];
                String selectedHarga = hargaPaket[i];

                Intent intent = new Intent(getActivity(), DetailPriceListActivity.class);
                intent.putExtra("nama", selectedName);
                intent.putExtra("image", selectedImage);
                intent.putExtra("detail", selectedDetail);
                intent.putExtra("harga", selectedHarga);
                startActivity(intent);
            }
        });

        return view;
    }

    public class CustomAdapter extends BaseAdapter {

        private String[] namaPaket;
        private int[] imagePaket;
        private int[] detailPaket;
        private String[] hargaPaket;
        private LayoutInflater layoutInflater;
        private PriceListFragment priceListFragment;

        public CustomAdapter(String[] namaPaket, int[] imagePaket, int[] detailPaket, String[] hargaPaket, PriceListFragment priceListFragment) {
            this.namaPaket = namaPaket;
            this.imagePaket = imagePaket;
            this.detailPaket = detailPaket;
            this.hargaPaket = hargaPaket;
            this.priceListFragment = priceListFragment;
            this.layoutInflater = (LayoutInflater) priceListFragment.getLayoutInflater();
        }

        @Override
        public int getCount() {
            return imagePaket.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
                view = layoutInflater.inflate(R.layout.list_price_list, viewGroup, false);
            }

            TextView txtNamaPaket = view.findViewById(R.id.txt_nama_paket);
            ShapeableImageView imgPaket = view.findViewById(R.id.img_paket);
            int dtlPaket;
            String hrgPaket;

            txtNamaPaket.setText(namaPaket[i]);
            imgPaket.setImageResource(imagePaket[i]);
            dtlPaket = (detailPaket[i]);
            hrgPaket = (hargaPaket[i]);

            return view;
        }
    }
}