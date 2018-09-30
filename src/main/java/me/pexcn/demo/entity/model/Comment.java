package me.pexcn.demo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.GeneratedValue;
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
@NameStyle(Style.camelhumpAndLowercase)
public class Comment {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long cid;
    private String commentText;
    private Date createdTime;
    private Date updatedTime;
    private Long userId;
}
