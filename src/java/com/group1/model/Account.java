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
    // Primary Key
    private int accountID;
    // Account User
    private String username, password, avatar, phone, email;
    private boolean firstLogin;
}
