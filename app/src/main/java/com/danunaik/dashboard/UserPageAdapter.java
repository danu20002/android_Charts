package com.danunaik.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserPageAdapter extends RecyclerView.Adapter<UserPageAdapter.ViewHolder> {
    private List<UserPage> userPages;

    public UserPageAdapter(List<UserPage> userPages) {
        this.userPages = userPages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_page, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserPage userPage = userPages.get(position);
        holder.pageTextView.setText(userPage.getPage());
        holder.usersTextView.setText(String.valueOf(userPage.getUsers()));
    }

    @Override
    public int getItemCount() {
        return userPages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView pageTextView;
        public TextView usersTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            pageTextView = itemView.findViewById(R.id.pageTextView);
            usersTextView = itemView.findViewById(R.id.usersTextView);
        }
    }
}
