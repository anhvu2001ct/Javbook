/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model;

import com.group1.misc.Pair;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mr Khang
 */
@Getter
@Setter
public class Post {

    private Status status;
    private List<Pair<Comment,List<Comment2>>> comment;
    
   
}
