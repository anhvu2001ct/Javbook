package com.group1.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Dang Minh Canh
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfileUserAbout {
    private int accountID;
    // Profile User
    private String name, avatar, coverImg;
    private Date DOB;
    private String address, gender, career;
    private int profileStatusID;
    private String audience;
    // String audience = "111111"
    // corresponding to DOB, Address, Gender, Career, ProfileStatus, Phone
    // 1 ~ Public, 2 ~ Friends, 3 ~ OnlyMe
}
