package com.prabudi.getapp.data.model.vouchers

import com.google.gson.annotations.SerializedName

data class VoucherList(
    @SerializedName("RSN")
    val rSN: String?,
    @SerializedName("AuthenticationRequired")
    val authenticationRequired: Boolean?,
    @SerializedName("DisplayValue")
    val displayValue: String?,
    @SerializedName("Images")
    val images: Images?,
    @SerializedName("IsPendingTransfer")
    val isPendingTransfer: Boolean?,
    @SerializedName("Partner")
    val partner: Partner?,
    @SerializedName("ReferralCode")
    val referralCode: String?,
    @SerializedName("ReferralExpiry")
    val referralExpiry: String?,
    @SerializedName("ScanToUse")
    val scanToUse: Boolean?,
    @SerializedName("Status")
    val status: String?,
    @SerializedName("URLOnly")
    val uRLOnly: Boolean?,
    @SerializedName("ValidFrom")
    val validFrom: String?,
    @SerializedName("ValidUntil")
    val validUntil: String?,
    @SerializedName("VoucherCode")
    val voucherCode: String?,
    @SerializedName("VoucherURL")
    val voucherURL: String?,
    @SerializedName("VoucherValue")
    val voucherValue: Int?
)