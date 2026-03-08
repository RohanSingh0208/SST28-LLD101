package com.example.payments;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, PaymentGateway> gateways = new HashMap<>();
        // TODO: register adapters instead of raw SDKs
        // gateways.put("fastpay", new FastPayAdapter(new FastPayClient()));
        // gateways.put("safecash", new SafeCashAdapter(new SafeCashClient()));

        gateways.put("fastpay", new FastPayAdapter(new FastPayClient()));
        gateways.put("safecash", new SafeCashAdapter(new SafeCashClient()));

        OrderService svcFastPay = new OrderService(gateways.get("fastpay"));
        OrderService svcSafeCash = new OrderService(gateways.get("safecash"));

        String id1 = svcFastPay.charge("cust-1", 1299);
        String id2 = svcSafeCash.charge("cust-2", 1299);
        
        System.out.println(id1);
        System.out.println(id2);
    }
}
