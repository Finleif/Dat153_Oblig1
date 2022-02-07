package no.hvl.dat153;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EntryListFragment extends Fragment {

    private ArrayList<Entry> mEntries =
            new ArrayList<Entry>();

    private RecyclerView mRecyclerView;

    private EntryRecyclerViewAdapter mEntryAdapter =
            new EntryRecyclerViewAdapter(mEntries);

    public EntryListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entry_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.entry_list);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the Recycler View adapter
        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mEntryAdapter);
    }

    /*
    takes a List
    of entries, checks for duplicates, and then adds each new Entry to the Array List.
    It should also notify the Recycler View Adapter that a new item has been inserted
     */
    public void setEntries(List<Entry> entries) {
        for (Entry entry: entries) {
            if (!mEntries.contains(entry)) {
                mEntries.add(entry);
                mEntryAdapter
                        .notifyItemInserted(mEntries.indexOf(entry));
            }
        }
    }
}
