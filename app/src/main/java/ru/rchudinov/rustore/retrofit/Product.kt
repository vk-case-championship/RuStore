package ru.rchudinov.rustore.retrofit

data class Product (
    val id: Int,
    val title: String,
    val description: String,
    val prise: Int,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Float,
    val brand: String,
    val category: String,
    val thumbnail : String,
    val images: List<String>


)