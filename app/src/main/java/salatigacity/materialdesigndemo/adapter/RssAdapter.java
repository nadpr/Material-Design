package salatigacity.materialdesigndemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import salatigacity.materialdesigndemo.R;
import salatigacity.materialdesigndemo.data.model.RssFeedModel;

/**
 * Created by ssh on 6/13/2017.
 */

public class RssAdapter extends RecyclerView.Adapter<RssAdapter.ItemHolder>{
    private final List<RssFeedModel.Items> items;

    public RssAdapter(List<RssFeedModel.Items> items) {
        this.items = items;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rss_feed, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        private TextView title, pub_date, categories;
        private ImageView thumbnail;
        public ItemHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            pub_date = (TextView) itemView.findViewById(R.id.pub_date);
            categories = (TextView) itemView.findViewById(R.id.categories);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }

        public void bind(RssFeedModel.Items items) {
            title.setText(items.getTitle());
            pub_date.setText(items.getPubDate().split(" ")[0]);
            categories.setText(TextUtils.join(",", items.getCategories()));
            Glide.with(itemView.getContext())
                    .load(items.getEnclosure().getLink())
                    .into(thumbnail);
        }
    }
}
