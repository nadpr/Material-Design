package salatigacity.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import salatigacity.materialdesigndemo.R;
import salatigacity.materialdesigndemo.adapter.RssAdapter;
import salatigacity.materialdesigndemo.data.model.RssFeedModel;
import salatigacity.materialdesigndemo.data.remote.FetchRss;

/**
 * Created by ssh on 6/13/2017.
 */

public class MainFragment extends Fragment{

    public static MainFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("title", title);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView list_rss_feed = (RecyclerView) view.findViewById(R.id.list_rss_feed);
        final ProgressBar progress_loader = (ProgressBar) view.findViewById(R.id.progress_loader);
        progress_loader.setIndeterminate(true);

        new FetchRss(new FetchRss.RssCallback() {
            @Override
            public void onResponse(final RssFeedModel rssFeedModel) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setList(list_rss_feed, rssFeedModel);
                        progress_loader.setIndeterminate(false);
                        progress_loader.setVisibility(View.GONE);
                    }
                });
            }

            @Override
            public void onError(Throwable throwable) {

            }
        }).getData();
    }

    private void setList(RecyclerView list_rss_feed, RssFeedModel rssFeedModel) {
        RssAdapter adapter = new RssAdapter(rssFeedModel.getItems());
        list_rss_feed.setLayoutManager(new LinearLayoutManager(getActivity()));
        list_rss_feed.setAdapter(adapter);
    }
}
