Function server_sendimportantdata%()
    Local local0.mp_player
    server_fillplayersdata()
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            mp_writebyte($05)
            mp_writebyte(local0\Field5)
            mp_writebuffer(mp_getdatabuffer(), $00)
            server_fillownplayerdata(local0)
            mp_send(local0\Field0, local0\Field1)
        EndIf
    Next
    Return $00
End Function
