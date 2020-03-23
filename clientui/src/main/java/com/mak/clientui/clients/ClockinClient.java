package com.mak.clientui.clients;

import com.mak.clientui.controllers.vm.ClockinWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "clockin-clockout", url = "localhost:9000")
public interface ClockinClient {

    @PostMapping(value = "v0/clockins")
    void clockin(@RequestBody ClockinWrapper clockinWrapper);

}
