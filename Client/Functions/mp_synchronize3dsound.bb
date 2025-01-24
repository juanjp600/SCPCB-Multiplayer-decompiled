Function mp_synchronize3dsound%(arg0.mp_player, arg1$, arg2%, arg3#, arg4#)
    Local local0#
    Local local1#
    Local local2#
    Local local3.mp_player
    If (((((arg2 = $00) Lor (mp_getsocket() = $00)) Lor (mp_ishoster() = $00)) Lor (arg1 = "")) <> 0) Then
        Return $00
    EndIf
    local0 = entityx(arg2, $01)
    local1 = entityy(arg2, $01)
    local2 = entityz(arg2, $01)
    For local3 = Each mp_player
        If ((((local3\Field5 > $01) And (arg0 <> local3)) And ((arg3 * 1.25) > entitydistance(arg2, local3\Field18))) <> 0) Then
            mp_server_sendsound(local3, arg1, $01, $00, arg3, arg4, local0, local1, local2)
        EndIf
    Next
    Return $00
End Function
