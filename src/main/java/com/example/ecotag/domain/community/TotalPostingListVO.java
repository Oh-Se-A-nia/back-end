package com.example.ecotag.domain.community;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TotalPostingListVO {
    private long postId;
    private String postPicture;
    private String trashType;
    private String trashLocation;
}
