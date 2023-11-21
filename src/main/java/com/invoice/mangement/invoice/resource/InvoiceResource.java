package com.invoice.mangement.invoice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @GetMapping
    public String getInvoice() {
        return "Invoice";
    }

    //@PostMapping
    //public


}
