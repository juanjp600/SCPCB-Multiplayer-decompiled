Function client_recvplayers%()
    Local local0%
    Local local1.mp_player
    Repeat
        local0 = mp_readbyte()
        If (local0 = $00) Then
            Exit
        EndIf
        client_playerrecv(local0)
    Forever
    For local1 = Each mp_player
        If (local1\Field20 = $00) Then
            flushplayer(local1)
        Else
            local1\Field20 = $00
        EndIf
    Next
    Return $00
End Function
