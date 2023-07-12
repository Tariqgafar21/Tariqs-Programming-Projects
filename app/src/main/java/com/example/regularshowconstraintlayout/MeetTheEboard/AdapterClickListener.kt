package com.example.regularshowconstraintlayout.MeetTheEboard

interface AdapterClickListener<E> {
    fun onClick(data: E?, index: Int)
}