//package com.IFA.service;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//@Service
//public class RazorpayPayoutService {
//
//    @Value("${razorpay.api.key}")
//    private String apiKey;
//
//    @Value("${razorpay.api.secret}")
//    private String apiSecret;
//
//    @Value("${razorpay.account.number}")
//    private String accountNumber;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public boolean createPayout(double amount, String bankAccount, String transactionNote) {
//        try {
//            JSONObject payoutRequest = new JSONObject();
//            payoutRequest.put("account_number", accountNumber);
//
//            JSONObject fundAccount = new JSONObject();
//            fundAccount.put("account_type", "bank_account");
//            JSONObject bankDetails = new JSONObject();
//            bankDetails.put("ifsc", "YOUR_IFSC_CODE"); // Replace with actual IFSC code
//            bankDetails.put("account_number", bankAccount);
//            fundAccount.put("details", bankDetails);
//            payoutRequest.put("fund_account", fundAccount);
//
//            payoutRequest.put("amount", (int) (amount * 100));
//            payoutRequest.put("currency", "INR");
//            payoutRequest.put("mode", "IMPS");
//            payoutRequest.put("purpose", "payout");
//            payoutRequest.put("queue_if_low_balance", true);
//            payoutRequest.put("reference_id", "LOAN_" + System.currentTimeMillis());
//            payoutRequest.put("narration", transactionNote);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            String auth = apiKey + ":" + apiSecret;
//            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
//            String authHeader = "Basic " + new String(encodedAuth);
//            headers.set("Authorization", authHeader);
//
//            HttpEntity<String> entity = new HttpEntity<>(payoutRequest.toString(), headers);
//
//            ResponseEntity<String> response = restTemplate.exchange(
//                    "https://api.razorpay.com/v1/payouts",
//                    HttpMethod.POST,
//                    entity,
//                    String.class
//            );
//
//            if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
//                JSONObject responseBody = new JSONObject(response.getBody());
//                String status = responseBody.getString("status");
//                return "processed".equalsIgnoreCase(status) || "created".equalsIgnoreCase(status);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//}
