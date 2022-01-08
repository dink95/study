package com.example.backend.dto;

import java.io.Serializable;


public class EmbedDto implements Serializable {

    private String version;
    private String type;
    private String title;
    private String author_url;
    private String author_name;
    private String width;
    private String height;
    private String html;
    private String thumbnail_width;
    private String thumbnail_height;
    private String thumbnail_url;
    private String provider_url;
    private String provider_name;

    public void setVersion(String version) {
        this.version = version;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setThumbnail_width(String thumbnail_width) {
        this.thumbnail_width = thumbnail_width;
    }

    public void setThumbnail_height(String thumbnail_height) {
        this.thumbnail_height = thumbnail_height;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public void setProvider_url(String provider_url) {
        this.provider_url = provider_url;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getHtml() {
        return html;
    }

    public String getThumbnail_width() {
        return thumbnail_width;
    }

    public String getThumbnail_height() {
        return thumbnail_height;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getProvider_url() {
        return provider_url;
    }

    public String getProvider_name() {
        return provider_name;
    }
}
