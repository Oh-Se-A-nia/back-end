package com.example.ecotag.controller.contributionAPI;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Contribution API", description = "전체 기여도와 자신의 기여도를 확인해 볼 수 있는 API")
@RestController
@RequestMapping("/api/contribution")
public class ProviderContribution {


}
