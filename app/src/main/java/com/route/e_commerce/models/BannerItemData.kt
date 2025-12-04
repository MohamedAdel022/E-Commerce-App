package com.route.e_commerce.models

import com.route.e_commerce.R

data class BannerItemData(
    val image: Int,
    val title: String,
    val description: String,

    )

val banners = listOf(
    BannerItemData(
        image = R.drawable.headphonees_banner,
        title = "UP TO\n25% OFF",

        description = "For all Headphones \n" +
                "& AirPods"
    ),
    BannerItemData(
        image = R.drawable.makeup_banner,
        title = "UP TO\n30% OFF",

        description = "For all Makeup Products\n" + "& Skincare"
    ),
    BannerItemData(
        image = R.drawable.laptop_banner,
        title = "UP TO\n20% OFF",
        description = "For all Laptops\n" + "Mobiles"

    )
)