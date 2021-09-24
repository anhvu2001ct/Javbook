package com.group1.model;

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
public class Account {
    private int accountID;
    private String username, password, name, avatar, phone, dob, address;
    private boolean gender;
}
