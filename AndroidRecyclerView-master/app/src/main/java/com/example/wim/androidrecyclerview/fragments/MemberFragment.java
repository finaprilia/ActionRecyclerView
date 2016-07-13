package com.example.wim.androidrecyclerview.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wim.androidrecyclerview.DetailActivity;
import com.example.wim.androidrecyclerview.R;
import com.example.wim.androidrecyclerview.adapter.MemberListAdapter;
import com.example.wim.androidrecyclerview.model.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satriadimasp on 11/7/16.
 */
public class MemberFragment extends Fragment implements MemberListAdapter.OnClickItem{

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;

    protected Context context;

    public final static String KEY_MEMBER="keymember";


    public static MemberFragment newInstance(){
        return new MemberFragment();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member, container, false);

        listMember = (RecyclerView) rootView.findViewById(R.id.listMember);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter(this);

        loadData();
        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);

    }

    private void loadData(){
        final List<Member> memberList = new ArrayList<>();
        Member member;

        int thumb[] = {R.drawable.ayana_shahab, R.drawable.beby_chaseara_anadila, R.drawable.delima_rizky,
                R.drawable.dena_siti_rohyati, R.drawable.elaine_hartanto, R.drawable.frieska_anastasia_laksani,
                R.drawable.gabriella, R.drawable.ghaida, R.drawable.jennifer_rachel_natasya,
                R.drawable.jessica_vania_widjaja, R.drawable.jessica_veranda, R.drawable.melody_nurramdhani_laksani,
                R.drawable.nabilah_ratna_ayu, R.drawable.rezky_wiranti_dhike, R.drawable.sendy_ariani,
                R.drawable.shania_junianantha, R.drawable.shinta_naomi, R.drawable.sofia_meifaliani,
                R.drawable.sonia_natalia, R.drawable.thalia_ivanka_elizabeth_frederik};

        String name[] = {"Ayana Shahab", "Beby Chaesara Anadila", "Delima Rizky", "Dena Siti Rohyati",
                "Elaine Hartanto", "Frieska Anastasia Laksani", "Gabriella M. W.", "Ghaida Farisya",
                "Jennifer Rachel Natasya", "Jessica Vania Widjaja", "Jessica Veranda", "Melody Nurramdhani Laksani",
                "Nabilah Ratna Ayu Azalia", "Rezky Wiranti Dhike", "Sendy Ariani", "Shania Junianatha",
                "Shinta Naomi", "Sofia Meifaliani", "Sonia Natalia", "Thalia Ivanka Elizabeth"};

        int number[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        String team = "Team J";

        for(int i=0; i < thumb.length; i++){
            member = new Member();

            member.setId(i+1);
            member.setName(name[i]);
            member.setTeam(team);
            member.setThumb(thumb[i]);
            member.setNumber(number[i]);

            memberList.add(member);
        }

        memberListAdapter.addAll(memberList);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void OnClick(Member member) {
        Intent pindah = new Intent(getActivity(),DetailActivity.class);
        pindah.putExtra(KEY_MEMBER, member);
        startActivity(pindah);

    }




}