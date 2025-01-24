Function mp_updatetimestep%()
    Local local0%
    local0 = mp_microtimertick()
    mp_time\Field3 = (min(((Float local0) / 1000000.0), 1.0) * 70.0)
    Return $00
End Function
