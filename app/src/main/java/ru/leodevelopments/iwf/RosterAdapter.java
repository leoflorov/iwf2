package ru.leodevelopments.iwf;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import leodevelopments.iwf.R;

class RosterAdapter extends RecyclerView.Adapter<RosterAdapter.MyViewHolder> {

    private Context mContext;
    private List<Roster> rosterList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, count;
        ImageView thumbnail, overflow;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    RosterAdapter(Context mContext, List<Roster> rosterList) {
        this.mContext = mContext;
        this.rosterList = rosterList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Roster roster = rosterList.get(position);
        holder.title.setText(roster.getName());
        holder.count.setText(roster.getNumOfWins() + mContext.getString(R.string.roster_menu_win_button));

        // loading roster cover using Glide library
        Glide.with(mContext).load(roster.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_wrestler_contacts:
                    Toast.makeText(mContext, "Контакты", Toast.LENGTH_SHORT).show(); //сделать поп-ап меню с контактами реслера, либо нижний навигэйшн бар
                    return true;
                case R.id.action_wrestlercard_stats:
                    Toast.makeText(mContext, "Статистика", Toast.LENGTH_SHORT).show(); // тоже самое, что и в первом случае, только на отдельную активити
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return rosterList.size();
    }
}
