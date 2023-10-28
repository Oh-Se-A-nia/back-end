package com.example.ecotag.domain.trash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MostTrashTypeCountingDTO {

    private int cigaretteCount = 0;
    private int disposableCount = 0;
    private int foodWasteCount = 0;
    private int maskCount = 0;
    private int illegalDumpingCount = 0;

}
