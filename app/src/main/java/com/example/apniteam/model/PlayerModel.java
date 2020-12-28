package com.example.apniteam.model;

public class PlayerModel {

    private int id;
    private  String name;
    private int score;
    private int userId;
    private int isOut;
    private int playerId;
    private int teamId;
    private boolean isSelected;
    private  String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTeamId() {
        return teamId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    private String teamName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsOut() {
        return isOut;
    }

    public void setIsOut(int isOut) {
        this.isOut = isOut;
    }

    @Override
    public String toString() {
        return "PlayerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", userId=" + userId +
                ", isOut=" + isOut +
                ", playerId=" + playerId +
                ", teamId=" + teamId +
                ", isSelected=" + isSelected +
                ", status='" + status + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
