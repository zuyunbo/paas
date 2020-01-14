package com.cloud.modle.apimodle.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 2u
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {

    private String username;

    private String type;

    private Long id;
}
