package com.nooty.nootyfollow.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Follow {
    @Id
    @GeneratedValue
    private int id;
    private String userId;
    private String followeeId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(String followeeId) {
        this.followeeId = followeeId;
    }
}
