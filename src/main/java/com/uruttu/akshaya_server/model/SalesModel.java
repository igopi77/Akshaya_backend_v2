package com.uruttu.akshaya_server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales")
public class SalesModel {
    @Id
    private String id;

    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double totalAmount;
    private double discount;
    private String customerId;
    private String customerName;

    private String saleDate;
    private String paymentMode;
    private String invoiceNumber;

    private String createdAt;
    private String updatedAt;

    public SalesModel() {
    }

    public String getId() {
        return this.id;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public double getDiscount() {
        return this.discount;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getSaleDate() {
        return this.saleDate;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SalesModel)) return false;
        final SalesModel other = (SalesModel) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$productId = this.getProductId();
        final Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final Object this$productName = this.getProductName();
        final Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName))
            return false;
        if (this.getQuantity() != other.getQuantity()) return false;
        if (Double.compare(this.getUnitPrice(), other.getUnitPrice()) != 0) return false;
        if (Double.compare(this.getTotalAmount(), other.getTotalAmount()) != 0) return false;
        if (Double.compare(this.getDiscount(), other.getDiscount()) != 0) return false;
        final Object this$customerId = this.getCustomerId();
        final Object other$customerId = other.getCustomerId();
        if (this$customerId == null ? other$customerId != null : !this$customerId.equals(other$customerId))
            return false;
        final Object this$customerName = this.getCustomerName();
        final Object other$customerName = other.getCustomerName();
        if (this$customerName == null ? other$customerName != null : !this$customerName.equals(other$customerName))
            return false;
        final Object this$saleDate = this.getSaleDate();
        final Object other$saleDate = other.getSaleDate();
        if (this$saleDate == null ? other$saleDate != null : !this$saleDate.equals(other$saleDate)) return false;
        final Object this$paymentMode = this.getPaymentMode();
        final Object other$paymentMode = other.getPaymentMode();
        if (this$paymentMode == null ? other$paymentMode != null : !this$paymentMode.equals(other$paymentMode))
            return false;
        final Object this$invoiceNumber = this.getInvoiceNumber();
        final Object other$invoiceNumber = other.getInvoiceNumber();
        if (this$invoiceNumber == null ? other$invoiceNumber != null : !this$invoiceNumber.equals(other$invoiceNumber))
            return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SalesModel;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        result = result * PRIME + this.getQuantity();
        final long $unitPrice = Double.doubleToLongBits(this.getUnitPrice());
        result = result * PRIME + (int) ($unitPrice >>> 32 ^ $unitPrice);
        final long $totalAmount = Double.doubleToLongBits(this.getTotalAmount());
        result = result * PRIME + (int) ($totalAmount >>> 32 ^ $totalAmount);
        final long $discount = Double.doubleToLongBits(this.getDiscount());
        result = result * PRIME + (int) ($discount >>> 32 ^ $discount);
        final Object $customerId = this.getCustomerId();
        result = result * PRIME + ($customerId == null ? 43 : $customerId.hashCode());
        final Object $customerName = this.getCustomerName();
        result = result * PRIME + ($customerName == null ? 43 : $customerName.hashCode());
        final Object $saleDate = this.getSaleDate();
        result = result * PRIME + ($saleDate == null ? 43 : $saleDate.hashCode());
        final Object $paymentMode = this.getPaymentMode();
        result = result * PRIME + ($paymentMode == null ? 43 : $paymentMode.hashCode());
        final Object $invoiceNumber = this.getInvoiceNumber();
        result = result * PRIME + ($invoiceNumber == null ? 43 : $invoiceNumber.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    public String toString() {
        return "SalesModel(id=" + this.getId() + ", productId=" + this.getProductId() + ", productName=" + this.getProductName() + ", quantity=" + this.getQuantity() + ", unitPrice=" + this.getUnitPrice() + ", totalAmount=" + this.getTotalAmount() + ", discount=" + this.getDiscount() + ", customerId=" + this.getCustomerId() + ", customerName=" + this.getCustomerName() + ", saleDate=" + this.getSaleDate() + ", paymentMode=" + this.getPaymentMode() + ", invoiceNumber=" + this.getInvoiceNumber() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }
}
