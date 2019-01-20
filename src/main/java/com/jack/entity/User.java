package com.jack.entity;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/13.
 *
 * @author liweijian.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Short gender;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
