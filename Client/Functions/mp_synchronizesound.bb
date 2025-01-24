Function mp_synchronizesound%(arg0$, arg1%, arg2.mp_player, arg3#, arg4#, arg5#, arg6#, arg7#)
    Local local0%
    Local local1.mp_player
    If ((((mp_getsocket() = $00) Lor (mp_ishoster() = $00)) Lor (arg0 = "")) <> 0) Then
        Return $00
    EndIf
    local0 = $00
    If (arg2 <> Null) Then
        local0 = arg2\Field5
    EndIf
    For local1 = Each mp_player
        If (((local1\Field5 > $01) And (local1\Field5 <> local0)) <> 0) Then
            mp_server_sendsound(local1, arg0, arg1, local0, arg3, arg4, arg5, arg6, arg7)
        EndIf
    Next
    Return $00
End Function
