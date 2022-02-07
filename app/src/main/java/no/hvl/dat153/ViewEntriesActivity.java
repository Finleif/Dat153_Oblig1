package no.hvl.dat153;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class ViewEntriesActivity extends AppCompatActivity {

    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";
    EntryListFragment mEntryListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entries);

        FragmentManager fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            FragmentTransaction ft = fm.beginTransaction();

            mEntryListFragment = new EntryListFragment();
            ft.add(R.id.view_entries_frame, mEntryListFragment, TAG_LIST_FRAGMENT)
            ft.commitNow();
        } else {
            mEntryListFragment = (EntryListFragment)fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }

        List<Entry> dummyEntries = new ArrayList<Entry>(0);
        dummyEntries.add(new Entry("jonas", 0));

        mEntryListFragment.setEntries(dummyEntries);


    }



}