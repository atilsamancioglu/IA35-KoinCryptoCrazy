package com.atilsamancioglu.koinretrofit.di

import com.atilsamancioglu.koinretrofit.view.ListFragment
import com.atilsamancioglu.koinretrofit.view.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module

val anotherModule = module {
    //if we want we can add multiple modules, but we need to specify in MyApplication
    //if we want, we can scope our providing modules.
    //for example the below scope will be living in ListFragment rather than a singleton

    scope<ListFragment> {
        // no need to use qualifier paremeter if we are using only one string or one same type object
        scoped(qualifier = named("hello")) {
            "Hello Kotlin"
        }

        //if i want to add more than two strings, i can use qualifier, named parameters
        scoped(qualifier = named("hi")) {
            "Hi Kotlin"
        }
    }
}