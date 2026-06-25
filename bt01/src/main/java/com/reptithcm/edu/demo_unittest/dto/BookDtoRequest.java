package com.reptithcm.edu.demo_unittest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDtoRequest {
    private Long id;
    private String title;
    private String author;
    private int page;
}
