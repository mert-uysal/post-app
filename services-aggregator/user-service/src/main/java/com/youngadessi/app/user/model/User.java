package com.youngadessi.app.user.model;

import com.youngadessi.app.common.sql.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_user",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
},indexes = {
        @Index(columnList = "fullname")
})
@Getter
@Setter
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "user_id"))
})
public class User extends BaseEntity {

    @Column(name = "fullname")
    private String fullname;

    @NotNull
    @NotBlank
    @Column(name = "username")
    private String username;

    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

}
