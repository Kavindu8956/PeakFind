package com.example.peakfind;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserDetailsListModel extends ArrayAdapter<UserDetailsModel> {

    private Activity context;
    private List<UserDetailsModel> userDetailsModelList;

    public UserDetailsListModel(Activity context, List<UserDetailsModel> userDetailsModelList) {
        super(context, R.layout.userdetailslist_layout, userDetailsModelList);
        this.context = context;
        this.userDetailsModelList = userDetailsModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewUserDetails = inflater.inflate(R.layout.userdetailslist_layout, null, true);

        TextView textViewName = (TextView) listViewUserDetails.findViewById(R.id.textViewName);

        UserDetailsModel user = userDetailsModelList.get(position);

        textViewName.setText(user.getUserName());

        return listViewUserDetails;
    }
}
