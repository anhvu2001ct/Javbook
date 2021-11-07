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
public class Chat {
    // Primary Key
    private int chatID;
   
    private int receiverID, senderID;
    private String text, chatImg, time;
}
