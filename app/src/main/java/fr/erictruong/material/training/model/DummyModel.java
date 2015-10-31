package fr.erictruong.material.training.model;

public class DummyModel {

    private long id;
    private String avatarUrl, text1, text2, text3;

    public DummyModel(long id, String avatarUrl, String text1, String text2, String text3) {
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    @Override
    public String toString() {
        return "DummyModel{" +
                "id=" + id +
                '}';
    }
}
