package com.neppplus.gudoc_in.datas

class CartData(
    var id: Int,
    var product: ProductData,
) {
/* //    ProductData 함수 활용
    fun getFormattedPrice(): String {
        return "${NumberFormat.getInstance(Locale.KOREA).format(this.product.price)} 원"
    } */
}