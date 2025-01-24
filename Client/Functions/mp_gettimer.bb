Function mp_gettimer%()
    Local local0%
    local0 = millisecs()
    mp_time\Field1 = (Int ((Float mp_time\Field1) + max((Float (local0 - mp_time\Field0)), 0.0)))
    mp_time\Field0 = local0
    Return mp_time\Field1
    Return $00
End Function
