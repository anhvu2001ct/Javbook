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
 * @author NhatQuynh
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {

    private int notificationid;
    private int senderid;
    private String sendername;
    private String senderavatar;
    private String time;
    private String emoji; 
    private String reference;
    private int seen;
    private String messnotifi;
   

}
