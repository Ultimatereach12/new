package com.student.admin.desire;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableWeightLayout;
import com.student.admin.desire.common.test;
import com.student.admin.desire.datagetter.listofnews;

import java.util.ArrayList;
import java.util.Arrays;

public class noticeboard extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    test  test12 ;
    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerView1;
    public noticeboard() {

    }


    public static noticeboard newInstance(String param1, String param2) {
        noticeboard fragment = new noticeboard();
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
        getActivity().setTitle("Notice Board");
      View view=  inflater.inflate(R.layout.fragment_noticeboard, container, false);

        recyclerView1=view.findViewById(R.id.recycleview);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManager);

        test12=new test();
        test12.noticeboard(recyclerView1,getContext());

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

    public void noticedata(listofnews body, Context context, RecyclerView recyclerView) {

          ArrayList<listofnews.NewsEventsList> data;
        DataAdapter2  mAdapter1;

        data = new ArrayList<>(Arrays.asList(body.getNewsEventsList()));


        mAdapter1= new DataAdapter2(data,context);
        recyclerView.setAdapter(mAdapter1);

    }
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }


    private class DataAdapter2
            extends RecyclerView.Adapter< DataAdapter2.ViewHolder> {
        private ArrayList<listofnews.NewsEventsList> android,mFilteredList;


        Context gg;

        public DataAdapter2(ArrayList<listofnews.NewsEventsList> android ,Context g) {
            this.android = android;
            this.mFilteredList=android;
            this.gg=g;
        }

        @Override
        public  DataAdapter2.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noticecart, viewGroup, false);
            return new  DataAdapter2.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final DataAdapter2.ViewHolder viewHolder, final int i) {

            viewHolder.tv_name.setText(android.get(i).getNews_title());
            viewHolder.tv_version.setText(android.get(i).getNews_content());
           viewHolder.expandLayout.collapse();


            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
        if(viewHolder.expandLayout.isExpanded()){
            viewHolder.expandLayout.collapse();

        }else{
            viewHolder.expandLayout.expand();
        }

                }
            });



        }
        @Override
        public int getItemCount() {
            return android.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tv_name, tv_version, tv_api_level ,tv_name1;
            ExpandableWeightLayout expandLayout;
            public ViewHolder(View view) {
                super(view);
                tv_name = (TextView)view.findViewById(R.id.newew);
                tv_version = (TextView)view.findViewById(R.id.noteContent);

                expandLayout = (ExpandableWeightLayout) itemView.findViewById(R.id.expandableLayout);


            }
        }
    }













}
