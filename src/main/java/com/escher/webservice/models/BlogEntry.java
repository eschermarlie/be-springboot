package com.escher.webservice.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BLOGENTRY")
public class BlogEntry {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="title")
        private String title;

        @Column(name="content")
        private String content;

        @Column(name="author")
        private String author;

        @Column(nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date publishDate;

        @Column(name="image_url")
        private String imageUrl;

        @Column(name="total_views")
        private Integer totalViews;
        //Setters and getters

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }


        public Integer getTotalViews() {
                return totalViews;
        }

        public void setTotalViews(Integer totalViews) {
                this.totalViews = totalViews;
        }

        public String getImageURL() {
                return imageUrl;
        }

        public void setImageURL(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        @Override
        public String toString() {
                return "BlogEntry [id=" + id + ", title=" + title +
                        ", content=" + content + ", author=" + author + ", publishDate=" + publishDate + ", totalViews=" + totalViews + ", imageUrl=" + imageUrl + "]";
        }
}