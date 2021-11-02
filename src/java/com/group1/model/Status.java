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
 * @author Mr Khang
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Status {

    private String userName;
    private String userImage;
    private int statusId;
    private String text, statusImg;
    private String time, activeTime;
    private int mood;
    private int numberOfEmoji;
    private String max1, max2;
    private int userEmotion;

}
