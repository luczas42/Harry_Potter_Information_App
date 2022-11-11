package br.com.hp_app.di

import br.com.hp_app.api.Repository
import br.com.hp_app.api.RetrofitInicializador
import br.com.hp_app.ui.viewmodel.DetalhesViewModel
import br.com.hp_app.ui.viewmodel.ListasViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ListasViewModel(get())}
    viewModel { DetalhesViewModel(get()) }
}

val repositoryModule = module {
    single {
        Repository(get())
    }
}

val retrofitModule = module{
    factory { RetrofitInicializador }
}