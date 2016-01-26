package com.tenchichrono.popularmovies;

/**
 * Created by dchi on 1/21/2016.
 */
public class Movies
{
    private String mTitle;
    private String mDate;
    private String mDescription;
    private String mID;
    private String mRating;
    private String mYear;
    private String mGenre;
    private String mPosterURL;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getPosterURL() {
        return mPosterURL;
    }

    public void setPosterURL(String posterURL) {
        mPosterURL = posterURL;
    }
}
