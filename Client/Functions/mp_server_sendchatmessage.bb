Function mp_server_sendchatmessage%(arg0.mp_player, arg1$)
    Local local0.mp_player
    Local local1%
    mp_chat\Field5 = (mp_chat\Field5 + $01)
    For local0 = Each mp_player
        If (((local0\Field5 > $01) And (arg0 <> local0)) <> 0) Then
            For local1 = $00 To $01 Step $01
                mp_writebyte($13)
                mp_writeline(arg1)
                mp_writeint(mp_chat\Field5)
                mp_send(local0\Field0, local0\Field1)
            Next
        EndIf
    Next
    Return $00
End Function
