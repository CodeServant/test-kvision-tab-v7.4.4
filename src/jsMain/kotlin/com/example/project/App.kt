package com.example.project

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapCssModule
import io.kvision.TabulatorModule
import io.kvision.TabulatorCssBootstrapModule
import io.kvision.html.div
import io.kvision.module
import io.kvision.panel.root
import io.kvision.startApplication
import io.kvision.tabulator.*
import io.kvision.utils.px
import kotlinx.serialization.Serializable
import kotlinx.serialization.serializer

@Serializable
data class Book(val title: String, val author: String, val year: Int, val rating: Int)

val model = listOf(
    Book("Fairy tales", "Hans Christian Andersen", 1836, 4),
    Book("Don Quijote De La Mancha", "Miguel de Cervantes", 1610, 4),
    Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 3),
    Book("In Search of Lost Time", "Marcel Proust", 1920, 5)
)


class App : Application() {
    override fun start() {
        root("kvapp") {
            div("Hello world")
            tabulator(
                model, options = TabulatorOptions(
                    layout = Layout.FITCOLUMNS,
                    columns = listOf(
                        ColumnDefinition("Title", "title"),
                        ColumnDefinition("Author", "author"),
                        ColumnDefinition("Year", "year"),
                        ColumnDefinition("Rating", "rating", formatter = Formatter.STAR)
                    ),
                    selectableRows = 1
                )
            ) {
                height = 400.px
            }

        }
    }
}

fun main() {
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
        CoreModule
    )
}
