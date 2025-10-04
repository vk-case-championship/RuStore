package ru.rchudinov.rustore.retrofit

import retrofit2.http.GET
interface ProductApi {
    @GET("products/1")
    suspend fun getProductsById(): Product
}