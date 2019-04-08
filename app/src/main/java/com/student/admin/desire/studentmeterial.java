package com.student.admin.desire;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.student.admin.desire.datagetter.alllist;
import com.student.admin.desire.datagetter.listofnews;
import com.student.admin.desire.webservice.api;
import com.student.admin.desire.webservice.network;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class studentmeterial extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView1;
    MaterialSpinner spinner,spinner1,spinner2;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public studentmeterial() {


    }

    public static studentmeterial newInstance(String param1, String param2) {

        studentmeterial fragment = new studentmeterial();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("Student Meterial");
        View view= inflater.inflate(R.layout.fragment_studentmeterial, container, false);
        recyclerView1=view.findViewById(R.id.recycleview);

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManager);

        g();

          spinner = (MaterialSpinner)view.findViewById(R.id.spinner);
         spinner1 = (MaterialSpinner)view.findViewById(R.id.spinner1);
         spinner2 = (MaterialSpinner)view.findViewById(R.id.spinner2);

        return view;
    }

    private void g() {

        final api mApiService =  network.getRetrofit().create(api.class) ;
        Call<alllist> call = mApiService.alllist();
        call.enqueue(new Callback<alllist>() {
            @Override
            public void onResponse(Call<alllist> call, Response<alllist> response) {

                final alllist gg=response.body();

                final String[] grade = new String[gg.getGrade().length];
                final String[] gradeid = new String[gg.getGrade().length];

                for(int i=0;i<gg.getGrade().length;i++){
                         System.out.println(i);
                         grade[i]=gg.getGrade()[i].getClass_name();
                         gradeid[i]=gg.getGrade()[i].getId();

                  }

                spinner.setItems( grade);
                spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                    @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

                        final int io=  spinner.getSelectedIndex();
                        final String[] grade1 = new String[gg.getGrade()[io].getBoard_list().length];
                        final String[] gradeid1= new String[gg.getGrade()[io].getBoard_list().length];
                        for(int ii=0;ii<gg.getGrade()[io].getBoard_list().length;ii++){

                                       grade1[ii]=gg.getGrade()[io].getBoard_list()[ii].getBoard_name();
                                       gradeid1[ii]=gg.getGrade()[io].getBoard_list()[ii].getId();

                        }
                        spinner1.setItems( grade1);
                        spinner1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

                                int ioo = spinner1.getSelectedIndex();


                                final String[] grade2 = new String[gg.getGrade()[io].getBoard_list()[ioo].getSub_list().length];
                                final String[] gradeid2= new String[gg.getGrade()[io].getBoard_list()[ioo].getSub_list().length];

                                for(int iii=0;iii<gg.getGrade()[io].getBoard_list()[ioo].getSub_list().length;iii++){

                                    grade2[iii]= gg.getGrade()[io].getBoard_list()[ioo].getSub_list()[iii].getSubject_name() ;
                                    gradeid2[iii]= gg.getGrade()[io].getBoard_list()[ioo].getSub_list()[iii].getId();


                                }
                                spinner2.setItems( grade2);





                            }
                        });

                    }
                });



            }


            @Override
            public void onFailure(Call<alllist> call, Throwable t) {

                System.out.println( call.request().url());
                Log.d("Error", t.getMessage());

            }
        });





    }

    public void onButtonPressed(Uri uri) {

        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onAttach(Context context) {

        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {

            mListener = (OnFragmentInteractionListener) context;

        } else {

        }
    }
    public void onDetach() {
        
        super.onDetach();
        mListener = null;

    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);

    }

//    private class DataAdapter extends RecyclerView.Adapter <DataAdapter.ViewHolder>  {
//
//        ArrayList<alllist.Grade> data;
//                Context context;
//        public DataAdapter(ArrayList<alllist.Grade> data, Context context) {
//
//            this.data=data;  this.context=context;
//        }
//        @NonNull
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noticecart, viewGroup, false);
//            return new   DataAdapter.ViewHolder(view);
//        }
//        @Override
//        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }
//        public class ViewHolder   extends RecyclerView.ViewHolder {
//            private TextView tv_name, tv_version, tv_api_level ,tv_name1;
//            public ViewHolder(View view) {
//                super(view);
//                tv_name = (TextView)view.findViewById(R.id.newew);
//                tv_version = (TextView)view.findViewById(R.id.noteContent);
//        }
//        }
//    }

}
