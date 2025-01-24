Function mp_inittimer%()
    mp_time = (New mp_timer)
    mp_time\Field1 = $00
    mp_time\Field0 = millisecs()
    mp_time\Field2 = getmicroseconds()
    Return $00
End Function
