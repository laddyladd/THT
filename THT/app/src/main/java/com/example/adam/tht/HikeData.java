package com.example.adam.tht;

import android.widget.ImageView;

/**
 * Created by Adam on 10/15/2016.
 */
public class HikeData
{

    public String getDifficulty(int i)
    {
        //do for all hikes
        return "Medium";
    }
    public int getImage(int i)
    {
        //Put in all the images of the hikes
        return R.drawable.THT_transparent;
    }
    public String getName(int i)
    {
        return "Cascades";
    }
    public String getDistance(int i)
    {
        return "Miles: 2";
    }
}
