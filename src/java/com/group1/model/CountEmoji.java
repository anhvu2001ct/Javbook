/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model;

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
public class CountEmoji {

    private int like;
    private int love;
    private int care;
    private int haha;
    private int sad;
    private int angry;
}
