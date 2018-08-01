package hu.tamaskozmer.bindableadapterexample

interface BindableAdapter<T> {
    fun setData(items: T)
}