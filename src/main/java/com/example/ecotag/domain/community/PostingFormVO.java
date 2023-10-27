package com.example.ecotag.domain.community;

import com.example.ecotag.domain.trash.TrashVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostingFormVO {

    private String postDetail;
    private String userId;
    private TrashVO trash;

}
