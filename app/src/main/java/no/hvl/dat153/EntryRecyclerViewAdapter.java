package no.hvl.dat153;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import no.hvl.dat153.databinding.EntryLayoutBinding;

public class EntryRecyclerViewAdapter extends RecyclerView.Adapter<EntryRecyclerViewAdapter.ViewHolder> {

    private final List<Entry> mEntries;

    public EntryRecyclerViewAdapter(List<Entry> entries ) {
        mEntries = entries;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EntryLayoutBinding binding = EntryLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return mEntries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final EntryLayoutBinding binding;

        public ViewHolder(EntryLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Entry entry = mEntries.get(position);
        holder.binding.setEntry(entry);
        holder.binding.executePendingBindings();
    }
}