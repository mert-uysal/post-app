package com.youngadessi.app.post.model.entity;

import com.youngadessi.app.common.sql.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// predefined values
// book, sport, cinema, politics, journey, sight
@Entity
@Table(name = "tbl_tag")
@Getter
@Setter
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "tag_id"))
})
public class Tag extends BaseEntity {

    @NotNull
    @NotBlank
    @Column(name = "tag_name")
    private String tagName;

}
