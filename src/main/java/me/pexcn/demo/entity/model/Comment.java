package me.pexcn.demo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

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
    @GeneratedValue(generator = "JDBC")
    private Long cid;
    private String commentText;
    private Timestamp createdTime;
    private Timestamp updatedTime;
    private Long userId;
}
