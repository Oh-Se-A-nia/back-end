package com.example.ecotag.domain.post;

import com.example.ecotag.domain.trash.TrashVO;
import com.example.ecotag.entity.Trash;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostingFormVO {
    private String postDetail;
    private String userId;
    private Trash trash;
}
