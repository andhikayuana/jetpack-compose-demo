package com.example.democompose.data.model.playstore

data class AppSectionItem(
    val title: String,
    val subtitle: String? = null,
    val apps: List<AppItem>
) {
    companion object {
        fun generate(): List<AppSectionItem> {
            return listOf(
                AppSectionItem(
                    title = "Welcome to Google Play",
                    subtitle = "Browse our most popular apps",
                    apps = AppItem.generate()
                ),
                AppSectionItem(
                    title = "Suggested for You",
                    apps = AppItem.generate()
                ),
                AppSectionItem(
                    title = "Premium apps",
                    apps = AppItem.generate()
                ),
                AppSectionItem(
                    title = "Browse our most popular games",
                    apps = AppItem.generate()
                ),
                AppSectionItem(
                    title = "Educational apps",
                    apps = AppItem.generate()
                ),
                AppSectionItem(
                    title = "Recently updated",
                    subtitle = "Fresh features & content",
                    apps = AppItem.generate()
                ),
            )
        }
    }
}