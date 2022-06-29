package com.youngadessi.app.post.model.entity;

import com.youngadessi.app.common.sql.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_comment")
@Getter
@Setter
public class Comment extends BaseEntity {

    @Column(name = "comment_text")
    private String commentText;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

}
