//package com.IFA.service.impl;
//
//import com.IFA.entity.LoanApplication;
//import com.IFA.service.PaymentService;
//import com.IFA.service.RazorpayPayoutService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    private final RazorpayPayoutService payoutService;
//
//    @Autowired
//    public PaymentServiceImpl(RazorpayPayoutService payoutService) {
//        this.payoutService = payoutService;
//    }
//
//    @Override
//    public boolean disburseLoanAmount(LoanApplication loanApplication, String bankAccount) {
//        return payoutService.createPayout(
//                loanApplication.getLoanAmount(),
//                bankAccount,
//                "Loan Disbursement for Loan ID: " + loanApplication.getId()
//        );
//    }
//}
