Function initpinging%()
    mp_ping = (New mp_pingsystem)
    mp_ping\Field0 = createudpstreamext($00)
    Return $00
End Function
