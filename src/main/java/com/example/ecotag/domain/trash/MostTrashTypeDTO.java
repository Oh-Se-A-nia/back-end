package com.example.ecotag.domain.trash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MostTrashTypeDTO {

    private int cigaretteCount;
    private int disposableCount;
    private int foodWasteCount;
    private int maskCount;
    private int illegalDumpingCount;

}
