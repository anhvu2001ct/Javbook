/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model;

import com.group1.misc.Secret;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Mr Khang
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emoji {

    private String userName;
    private String userImage;
    private int emojiID;
    private int accountID;

    public String getID() {
        return Secret.encode2(String.valueOf(accountID));
    }

}
