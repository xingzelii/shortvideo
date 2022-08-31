package com.lixing.sv.entitys;

public class Video {
    private long id;
    private OtherUser author;
    private long commentCount;
    private String coverURL;
    private long favoriteCount;
    private boolean isFavorite;
    private String playURL;
    private String title;

    public Video(){
        author=new OtherUser();
        commentCount=10L;
        coverURL="http://169.254.34.167:8080/static/1.jpg";
        favoriteCount=10L;
        id=10L;
        isFavorite=true;
        playURL="http://169.254.34.167:8080/static/1.mp4";
        title="你脑袋大";
    }

    public OtherUser getAuthor() { return author; }
    public void setAuthor(OtherUser value) { this.author = value; }

    public long getCommentCount() { return commentCount; }
    public void setCommentCount(long value) { this.commentCount = value; }

    public String getCoverURL() { return coverURL; }
    public void setCoverURL(String value) { this.coverURL = value; }

    public long getFavoriteCount() { return favoriteCount; }
    public void setFavoriteCount(long value) { this.favoriteCount = value; }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public boolean getIsFavorite() { return isFavorite; }
    public void setIsFavorite(boolean value) { this.isFavorite = value; }

    public String getPlayURL() { return playURL; }
    public void setPlayURL(String value) { this.playURL = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
}
