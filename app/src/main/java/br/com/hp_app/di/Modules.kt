package br.com.hp_app.di

import br.com.hp_app.data.api.Repository
import br.com.hp_app.data.api.RetrofitInicializador
import br.com.hp_app.ui.viewmodel.DetailsViewModel
import br.com.hp_app.ui.viewmodel.ListsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListsViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}

val repositoryModule = module {
    single {
        Repository(get())
    }
}

val retrofitModule = module {
    factory { RetrofitInicializador }
}