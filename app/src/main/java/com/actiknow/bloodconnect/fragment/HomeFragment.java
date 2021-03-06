package com.actiknow.bloodconnect.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.actiknow.bloodconnect.R;
import com.actiknow.bloodconnect.utils.SetTypeFace;
import com.actiknow.bloodconnect.utils.Utils;

/**
 * Created by Admin on 25-10-2016.
 */
public class HomeFragment extends Fragment {

    public HomeFragment () {
        setHasOptionsMenu (true);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate (R.layout.fragment_home, container, false);
        setHasOptionsMenu (true);
        initView (rootView);
        initData ();
        return rootView;
    }

    private void initView (View view) {
    }

    private void initData () {
    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        menu.clear ();
        inflater.inflate (R.menu.menu_fragment_home, menu);
        SearchManager searchManager = (SearchManager) getActivity ().getSystemService (Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem (R.id.action_search).getActionView ();
        if (null != searchView) {
            searchView.setSearchableInfo (searchManager.getSearchableInfo (getActivity ().getComponentName ()));
        }

        searchView.setQueryHint ("Search Home");
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener () {
            public boolean onQueryTextChange (String newText) {
//                Utils.showToast (getActivity (), "search text home " + newText);
                return true;
            }

            public boolean onQueryTextSubmit (String query) {
                //Here u can get the value "query" which is entered in the search box.
                return true;
            }
        };
        searchView.setOnQueryTextListener (queryTextListener);

        EditText et = (EditText) searchView.findViewById (R.id.search_src_text);
        et.setHintTextColor (getResources ().getColor (R.color.hint_color_white));
        et.setTypeface (SetTypeFace.getTypeface (getActivity ()));
        super.onCreateOptionsMenu (menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.action_search:

//                if (etSearch.isShown ()) {
//                    etSearch.setVisibility (View.GONE);
//                    final Handler handler = new Handler ();
//                    handler.postDelayed (new Runnable () {
//                        @Override
//                        public void run () {
//                            etSearch.setText ("");
//                        }
//                    }, 1000);
//                } else {
//                    etSearch.setVisibility (View.VISIBLE);
//                }
                break;
        }
        Utils.hideSoftKeyboard (getActivity ());

        return super.onOptionsItemSelected (item);
    }
}
