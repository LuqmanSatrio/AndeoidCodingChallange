package com.example.luqmansatriowicaksono.androidcodingchallange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by luqmansatriowicaksono on 18.04.17.
 */

public class SimpsonsCharacterAdapter  extends ArrayAdapter<SimpsonsCharacter>{


        Context c;

        public SimpsonsCharacterAdapter(Context context, List<SimpsonsCharacter> simpsonsCharacters) {

            super(context, 0, simpsonsCharacters);
            c = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            View listItemView = convertView;
            if(listItemView == null)
            {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.simpsonslistitem, parent, false);

            }

            SimpsonsCharacter currentsimpsonCharacter = getItem(position);

            TextView Vorname = (TextView) listItemView.findViewById(R.id.firstname);
            Vorname.setText(currentsimpsonCharacter.getFirstname());

            TextView Nachname = (TextView)listItemView.findViewById(R.id.lastname);
            Nachname.setText(currentsimpsonCharacter.getLastName());

            //using Picasso to extract the picture from the URL
            ImageView pic = (ImageView)listItemView.findViewById(R.id.list_item_icon);
            Picasso.with(c).load(currentsimpsonCharacter.getImg()).into(pic);

            return listItemView;
        }
    }

