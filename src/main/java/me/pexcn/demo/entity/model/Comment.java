package me.pexcn.demo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pexcn.demo.annotation.CreateTime;
import me.pexcn.demo.annotation.UpdateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author pexcn
 * @date 2018-09-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private String cid;

    private String commentText;

    @CreateTime
    private Date createdTime;

    @UpdateTime
    private Date updatedTime;

    private Long userId;
}
