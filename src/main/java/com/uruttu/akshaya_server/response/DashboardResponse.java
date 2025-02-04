package com.uruttu.akshaya_server.response;

public class DashboardResponse {
    private double totalSales;
    private double totalRevenue;
    private double totalCost;
    private double totalProfit;
    private int totalPurchases;
    private double totalPurchaseCost;
    Boolean status;

    public DashboardResponse(double totalSales, double totalRevenue, double totalCost, double totalProfit, int totalPurchases, double totalPurchaseCost,boolean status) {
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
        this.totalCost = totalCost;
        this.totalProfit = totalProfit;
        this.totalPurchases = totalPurchases;
        this.totalPurchaseCost = totalPurchaseCost;
        this.status = status;
    }

    public double getTotalSales() { return totalSales; }
    public double getTotalRevenue() { return totalRevenue; }
    public double getTotalCost() { return totalCost; }
    public double getTotalProfit() { return totalProfit; }
    public int getTotalPurchases() { return totalPurchases; }
    public double getTotalPurchaseCost() { return totalPurchaseCost; }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
