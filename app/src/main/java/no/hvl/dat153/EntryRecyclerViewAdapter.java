package no.hvl.dat153;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//import perotto.dat153.earthquake.databinding.ListItemEarthquakeBinding;

public class EntryRecyclerViewAdapter extends RecyclerView.Adapter<EntryRecyclerViewAdapter.ViewHolder> {

    private final List<Entry> mEntries;

    public EntryRecyclerViewAdapter(List<Entry> entries ) {
        mEntries = entries;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemEntryBinding binding = ListItemEntryBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return mEntries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ListItemEntryBinding binding;

        public ViewHolder(ListItemEntryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.set
            //binding.setTimeformat(TIME_FORMAT);
            //binding.setMagnitudeformat(MAGNITUDE_FORMAT);

            //date = (TextView) view.findViewById(R.id.date);
            //details = (TextView) view.findViewById(R.id.details);
            //magnitude = (TextView) view.findViewById(R.id.magnitude);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + details.getText() + "'";
//        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Entry entry = mEntries.get(position);

//        holder.date.setText(TIME_FORMAT.format(earthquake.getDate()));
//        holder.details.setText(earthquake.getDetails());
//        holder.magnitude.setText(
//                MAGNITUDE_FORMAT.format(earthquake.getMagnitude()));
        holder.binding.setEarthquake(earthquake);
        holder.binding.executePendingBindings();
    }
}