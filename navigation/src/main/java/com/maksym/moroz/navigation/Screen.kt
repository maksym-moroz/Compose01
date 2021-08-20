package com.maksym.moroz.navigation

sealed interface Screen {
    val route: String

    operator fun invoke() = this.route

    object List : Screen {
        override val route: String
            get() = "list"
    }

    object Detail : Screen {
        const val ID = "ID"
        private const val ROUTE = "detail?$ID="

        override val route: String
            get() = "$ROUTE{$ID}"

        operator fun invoke(id: Int) = "$ROUTE$id"
    }
}