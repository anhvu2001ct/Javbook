package com.group1.misc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pair<T1, T2> {
    public T1 first;
    public T2 second;
}
