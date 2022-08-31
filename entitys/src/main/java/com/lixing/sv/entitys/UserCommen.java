package com.lixing.sv.entitys;

public class UserCommen {
	private long followCount;
    private long followerCount;
    private long id;
    private String name;

    
    public long getFollowCount() { return followCount; }
    public void setFollowCount(long value) { this.followCount = value; }

    public long getFollowerCount() { return followerCount; }
    public void setFollowerCount(long value) { this.followerCount = value; }

    public long getId() { return id; }
    public void setId(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
