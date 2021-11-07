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
 * @author Lê Nhật Quỳnh
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotiMessage {
    private String id;
    private String name;
    private String avatar;
    private String time;
    private String seen;

}
