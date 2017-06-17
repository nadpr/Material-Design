package salatigacity.materialdesigndemo.data.model;

import java.util.List;

/**
 * Created by ssh on 6/13/2017.
 */

public class RssFeedModel {

    public String status;
    public List<Items> items;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public static class Items{
        public String title;
        public String pubDate;
        public String link;
        public String guid;
        public String author;
        public String description;
        public List<String> categories;
        public Enclosure enclosure;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public Enclosure getEnclosure() {
            return enclosure;
        }

        public void setEnclosure(Enclosure enclosure) {
            this.enclosure = enclosure;
        }

        public static class Enclosure{

            public String link;

            public void setLink(String link) {
                this.link = link;
            }

            public String getLink() {
                return link;
            }
        }
    }
}
