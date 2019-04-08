package com.student.admin.desire;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;

import com.student.admin.desire.datagetter.listofnews;
import com.student.admin.desire.datagetter.studentlist;
import com.student.admin.desire.webservice.api;
import com.student.admin.desire.webservice.network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import androidx.navigation.Navigation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class managestudent extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView1;
    DataAdapter mAdapter1;
    ArrayList<studentlist.StudentList> data;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public managestudent() {
        // Required empty public constructor
    }

    public static managestudent newInstance(String param1, String param2) {
        managestudent fragment = new managestudent();
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


        final View view=inflater.inflate(R.layout.fragment_managestudent, container, false);
        recyclerView1=view.findViewById(R.id.recycleview);
        EditText editText=view.findViewById(R.id.search);
        final CheckBox checkbox=view.findViewById(R.id.checkbox);

        final Button button=view.findViewById(R.id.remove);

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkbox.isChecked()) {
                    for (studentlist.StudentList model : data) {
                        model.setSelected(true);
                    }
                } else {

                    for (studentlist.StudentList  model : data) {
                        model.setSelected(false);
                    }
                }
                mAdapter1.notifyDataSetChanged();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int o = 0;
                String g ="";
                for(int i=0;data.size()>i;i++) {

                    if(data.get(i).isSelected()){
                        o=1;

                        if(g.equals("")){

//                          g=data.get(i).getId();
                            g=data.get(i).getId();

                        }else{

                            g=g+","+data.get(i).getId();
//                          g=g+","+data.get(i).getId();
                        }
                    }


                }
                if (o == 1) {

//                    String mblNumVar =g;
//                    Intent smsMsgAppVar = new Intent(Intent.ACTION_VIEW);
//                    smsMsgAppVar.setData(Uri.parse("sms:" +  mblNumVar));
//                    smsMsgAppVar.putExtra("sms_body",r.getText().toString());
//                    startActivity(smsMsgAppVar);
                }
                else {
                    Snackbar.make(v, "Please click on any check box", Snackbar.LENGTH_LONG).show();
                }

            }
        });

//
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }
            @Override
            public void afterTextChanged(Editable s) {

            if(s.toString().isEmpty()){

             mAdapter1.getFilter().filter("");
             }else {

               mAdapter1.getFilter().filter(s.toString());

            }
            }
              });

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManager);
        final api mApiService =  network.getRetrofit().create(api.class);
        Call<studentlist> call = mApiService.studentlist();
        call.enqueue(new Callback<studentlist>() {
            @Override
            public void onResponse(Call<studentlist> call, Response<studentlist> response) {


                System.out.println(response.body());
                System.out.println(call.request().url());

                data = new ArrayList<>(Arrays.asList(response.body().getStudentList()));


                mAdapter1= new DataAdapter(data,getContext());
                recyclerView1.setAdapter(mAdapter1);

                System.out.println( call.request().url());
                noticeboard login=new noticeboard();

            }
            @Override
            public void onFailure(Call<studentlist> call, Throwable t) {

                System.out.println( call.request().url());
                Log.d("Error", t.getMessage());

            }
        });

        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class DataAdapter
            extends RecyclerView.Adapter< DataAdapter.ViewHolder> {
        private ArrayList<studentlist.StudentList> android, mFilteredList;

        private ArrayList<studentlist.StudentList> item_list;
        Context gg;

        public DataAdapter(ArrayList<studentlist.StudentList> android, Context g) {
            this.android = android;
            this.mFilteredList = android;
            this.gg = g;
        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.studentcart, viewGroup, false);
            return new DataAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, final int i) {

            viewHolder.tv_name.setText(android.get(i).getStudent_name());
            viewHolder.checkBox.setChecked(android.get(i).isSelected());
            viewHolder.checkBox.setTag(android.get(i));
            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    CheckBox cb = (CheckBox) v;
                    studentlist.StudentList  model=(studentlist.StudentList) cb.getTag();
                    model.setSelected(cb.isChecked());
                    android.get(i).setSelected(cb.isChecked());

                }
            });

        }

        @Override
        public int getItemCount() {
            return android.size();
        }
        Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    String charString = charSequence.toString();
                    if (charString.isEmpty()) {
                        android=mFilteredList;
                    } else {
                        System.out.println(charString);
                        ArrayList<studentlist.StudentList> filteredList = new ArrayList<>();
                        for(studentlist.StudentList androidVersion : android) {
                            if(androidVersion.getStudent_name().toLowerCase().contains(charString)) {
                                filteredList.add(androidVersion);
                           }
                        }
                        android = filteredList;
                    }
                    FilterResults filterResults = new FilterResults();
                    filterResults.values = android;
                    return filterResults;
                }
                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                    android=(ArrayList<studentlist.StudentList>) filterResults.values;
                    notifyDataSetChanged();

                }
            };

        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tv_name, tv_version, tv_api_level, tv_name1;
            CheckBox checkBox;

            public ViewHolder(View view) {
                super(view);
                tv_name = (TextView) view.findViewById(R.id.tv);
                checkBox=view.findViewById(R.id.checkbox);
            }
        }
    }
}
