package com.jocelinlaroch08.inventorymanagement.exception;

public enum ErrorCode {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    // TODO : COMPLETE THE REST OF ERROR
    CUSTOMER_NOT_FOUND(3000),
    CUSTOMER_ORDER_NOT_FOUND(4000),
    SUPPLIER_ORDER_NOT_FOUND(5000),
    COMPANY_NOT_FOUND(6000),
    SUPPLIER_NOT_FOUND(7000),
    CUSTOMER_ORDER_LINE_NOT_FOUND(8000),
    SUPPLIER_ORDER_LINE_NOT_FOUND(9000),
    SALE_LINE_NOT_FOUND(1000),
    STOCK_MOVEMENT_NOT_FOUND(11000),
    USER_NOT_FOUND(12000),
    SALE_NOT_FOUND(13000),;

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public  int getCode() {
        return code;
    }

}
