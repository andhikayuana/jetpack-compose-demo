package com.example.democompose.data.model.playstore

import com.example.democompose.R

data class BottomNavItem(
    val icon: Int,
    val label: String
) {
    companion object {
        fun generate(): List<BottomNavItem> {
            return listOf(
                BottomNavItem(
                    icon = R.drawable.ic_games,
                    label = "Games"
                ),
                BottomNavItem(
                    icon = R.drawable.ic_apps,
                    label = "Apps"
                ),
                BottomNavItem(
                    icon = R.drawable.ic_movies,
                    label = "Movies"
                ),
                BottomNavItem(
                    icon = R.drawable.ic_books,
                    label = "Books"
                ),
            )
        }
    }
}