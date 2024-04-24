package com.bbox.domain;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tools")
public class Tool implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String link;
    private String description;
    @Type(StringArrayType.class)
    @Column(
            name = "tags",
            columnDefinition = "text[]"
    )
    private String[] tags;
    public Tool() {
    }

    public Tool(UUID id, String title, String link, String description, String[] tags) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return Objects.equals(id, tool.id) && Objects.equals(title, tool.title) && Objects.equals(link, tool.link) && Objects.equals(description, tool.description) && Objects.equals(tags, tool.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, link, description, tags);
    }
}
