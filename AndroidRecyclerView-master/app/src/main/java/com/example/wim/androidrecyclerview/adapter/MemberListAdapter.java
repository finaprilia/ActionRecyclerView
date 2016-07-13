package com.example.wim.androidrecyclerview.adapter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wim.androidrecyclerview.R;
import com.example.wim.androidrecyclerview.model.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satriadimasp on 11/7/16.
 */
public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.MemberViewHolder>{

    private List<Member> memberList;
    public OnClickItem itemClick;

    public MemberListAdapter(OnClickItem itemClick) {
        this.itemClick = itemClick;
        memberList = new ArrayList<>();
    }

    public interface OnClickItem{
        public void OnClick(Member member);
    }


    private void add(Member item) {
        memberList.add(item);
        notifyItemInserted(memberList.size() - 1);
    }

    public void addAll(List<Member> memberList) {
        for (Member member : memberList) {
            add(member);
        }
    }

    public void remove(Member item) {
        int position = memberList.indexOf(item);
        if (position > -1) {
            memberList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Member getItem(int position){
        return memberList.get(position);
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_member, parent, false);
        MemberViewHolder memberViewHolder = new MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {
        final Member member = memberList.get(position);

        holder.memberThumb.setImageResource(member.getThumb());
        holder.memberName.setText(member.getName());
        holder.memberTeam.setText(member.getTeam());
        holder.memberNumber.setText(member.getNumber()+"");
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.OnClick(member);
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {

        ImageView memberThumb;
        TextView memberName;
        TextView memberTeam;
        TextView memberNumber;
        View v;

        public MemberViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            memberThumb = (ImageView) itemView.findViewById(R.id.thumb);
            memberName = (TextView) itemView.findViewById(R.id.name);
            memberTeam = (TextView) itemView.findViewById(R.id.team);
            memberNumber = (TextView) itemView.findViewById(R.id.call);
        }
    }
}
