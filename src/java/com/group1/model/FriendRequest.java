/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nhatquynh
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FriendRequest {

    private String sender;
    private String sendername;
    private String senderavatar;
    private String time;
}
