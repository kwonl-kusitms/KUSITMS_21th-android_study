package com.example.backendtutorial;

public class BoardItemData {
    String title;
    String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public BoardItemData(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
