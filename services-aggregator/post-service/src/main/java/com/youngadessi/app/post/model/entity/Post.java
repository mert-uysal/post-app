package com.youngadessi.app.post.model.entity;

import com.youngadessi.app.common.sql.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@Getter
@Setter
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "post_id"))
})
public class Post extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(name = "title")
    private String title;

    @NotNull
    @NotBlank
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "post", cascade=CascadeType.ALL)
    private List<Comment> comments;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "tbl_post_tags",
            joinColumns = @JoinColumn(name = "post_id",referencedColumnName = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "tag_id"))
    private List<Tag> tags;

}
