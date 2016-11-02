package com.example.adam.tht;

/**
 * Created by Adam on 10/15/2016.
 */
public class HikeData
{

    public String getDifficulty(int i)
    {
        //do for all hikes
        if(i == 2 || i == 8 || i == 9){
            return "Easy";
        }
        else if(i == 0 || i == 1 || i == 4 || i == 6 || i == 7){
            return "Medium";
        }
        else if(i ==  3 || i == 5){
            return "Hard";
        }
        else{
            return "N/A"; //error checking
        }

    }
    public int getImage(int i)
    {
        switch (i){
            case 0: return R.drawable.andylayne;
            case 1: return R.drawable.angelsrest;
            case 2: return R.drawable.cascades;
            case 3: return R.drawable.devilsmarbleyard;
            case 4: return R.drawable.dragonstooth;
            case 5: return R.drawable.flattop;
            case 6: return R.drawable.kellysknob;
            case 7: return R.drawable.mcafee;
            case 8: return R.drawable.smithmtn;
            case 9: return R.drawable.warspur;
        }

        return R.drawable.tht_transparent;
    }
    public String getName(int i)
    {
        String name = "";
        switch (i){
            case 0: name = "Tinker Cliff";
                break;
            case 1: name = "Angel's Rest";
                break;
            case 2: name = "Cascades";
                break;
            case 3: name = "Devil's Marbleyard";
                break;
            case 4: name = "Dragon's Tooth";
                break;
            case 5: name = "Flat Top Trail";
                break;
            case 6: name = "Kelly's Knob";
                break;
            case 7: name = "McAfee's Knob";
                break;
            case 8: name = "Smith Mountain Lake";
                break;
            case 9: name = "War Spur Trail";
                break;
        }

        return name;
    }
    public String getDistance(int i)
    {
        //returning one way distance
        String distance = "Miles: ";
        switch (i){
            case 0: distance += "3.8";
                break;
            case 1: distance += "1.5";
                break;
            case 2: distance += "2";
                break;
            case 3: distance += "1";    //the easy part, not sure if we want to include the climb
                break;
            case 4: distance += "2.85";
                break;
            case 5: distance += "4.8";  //
                break;
            case 6: distance += "2.1";
                break;
            case 7: distance += "4";
                break;
            case 8: distance += "N/A";  //lot of short trails here
                break;
            case 9: distance += "2.7";  //is a loop
                break;
        }

        return distance;
    }
}
