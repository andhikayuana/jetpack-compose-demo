package com.example.democompose.data.model.playstore

data class AppItem(
    val name: String,
    val size: Int,
    val imageUrl: String
) {
    companion object {
        fun generate(): List<AppItem> {
            return listOf(
                AppItem(
                    name = "Instagram",
                    size = 32,
                    imageUrl = "https://lh3.googleusercontent.com/2sREY-8UpjmaLDCTztldQf6u2RGUtuyf6VT5iyX3z53JS4TdvfQlX-rNChXKgpBYMw=s128-rw"
                ),
                AppItem(
                    name = "Facebook Lite",
                    size = 32,
                    imageUrl = "https://lh3.googleusercontent.com/tjUtqpz5-svv0bZRsC8PlAMQ7EeLY1aSwp27hLRFWWW8aVbpRsi2tmQIpZpuzn_UFtM=s128-rw"
                ),
                AppItem(
                    name = "Messenger",
                    size = 32,
                    imageUrl = "https://lh3.googleusercontent.com/rkBi-WHAI-dzkAIYjGBSMUToUoi6SWKoy9Fu7QybFb6KVOJweb51NNzokTtjod__MzA=s128-rw"
                ),
                AppItem(
                    name = "Shoppe",
                    size = 32,
                    imageUrl = "https://lh3.googleusercontent.com/1Z6jBghbn4Llk2OrGqW0Yjb6yQvg5Csc1y51ITtgU7MhYt9MTt6JAuJwn1feR4JeRWw=s128-rw"
                ),
                AppItem(
                    name = "Twitter",
                    size = 32,
                    imageUrl = "https://lh3.googleusercontent.com/wIf3HtczQDjHzHuu7vezhqNs0zXAG85F7VmP7nhsTxO3OHegrVXlqIh_DWBYi86FTIGk=s128-rw"
                ),
                AppItem(
                    name = "WhatsApp Messenger",
                    size = 32,
                    imageUrl = "https://lh3.googleusercontent.com/bYtqbOcTYOlgc6gqZ2rwb8lptHuwlNE75zYJu6Bn076-hTmvd96HH-6v7S0YUAAJXoJN=s128-rw"
                ),

            )
        }
    }
}