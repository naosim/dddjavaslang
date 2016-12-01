package com.naosim.dddjavaslang.api;

import com.naosim.dddjavaslang.domain.serviceengagement.engagementdate.ServiceEngagementStartOrderDate;
import com.naosim.dddjavaslang.domain.order.engagementstart.EngagementStartOrder;
import com.naosim.dddjavaslang.domain.payment.CreditCard;
import com.naosim.dddjavaslang.domain.payment.CreditCardExpireDate;
import com.naosim.dddjavaslang.domain.payment.CreditCardNumber;
import com.naosim.dddjavaslang.domain.useraccessinfo.birthday.Age;
import com.naosim.dddjavaslang.domain.useraccessinfo.birthday.Birthday;
import com.naosim.dddjavaslang.domain.useraccessinfo.username.*;
import com.naosim.dddjavaslang.lib.date.CurrentDateTime;
import com.naosim.dddjavaslang.service.EngagementStartOrderService;
import javaslang.collection.HashMap;
import javaslang.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaslang.collection.Map;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class SampleApi {

    @Autowired
    EngagementStartOrderService engagementStartOrderService;

    @RequestMapping("/hello")
    public java.util.Map invoke(@RequestParam("text") String text) {
        Map<String, String> map = HashMap.of("result", "ok").put("message", "hello");
        return map.toJavaMap();
    }

    @RequestMapping("/engage")
    public java.util.List invoke() {
        LocalDateTime now = LocalDateTime.now();
        CurrentDateTime currentDateTime = new CurrentDateTime(now);
        EngagementStartOrder engagementStartOrder = new EngagementStartOrder(
                new ServiceEngagementStartOrderDate(now.toLocalDate()),
                new UserNameKana(new UserNameSeiKana("シナガワ"), new UserNameMeiKana("タロウ")),
                new UserNameKanji(new UserNameSeiKanji("品川"), new UserNameMeiKanji("太郎")),
                new Age(new Birthday(LocalDate.of(1990, 1, 1)), currentDateTime),
                new CreditCard(new CreditCardNumber("123"), new CreditCardExpireDate(LocalDate.of(2020, 1, 1)))
        );
        return engagementStartOrderService.order(engagementStartOrder).getOrElse(List.empty()).toJavaList();
    }
}
