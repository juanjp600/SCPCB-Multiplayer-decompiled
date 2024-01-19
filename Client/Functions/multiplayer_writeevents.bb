Function multiplayer_writeevents%()
    Local local0.events
    For local0 = Each events
        If (isablockedevent(local0) = $00) Then
            udp_writebyte(local0\Field15)
            udp_writebyte(local0\Field22)
            udp_writebyte(local0\Field1\Field65)
            udp_writefloat(local0\Field2)
            udp_writefloat(local0\Field3)
            udp_writefloat(local0\Field4)
        EndIf
    Next
    udp_writebyte($00)
    Return $00
End Function
