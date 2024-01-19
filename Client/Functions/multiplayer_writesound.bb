Function multiplayer_writesound%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#)
    Local local0.sound
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    local0 = (Object.sound arg0)
    If (local0 <> Null) Then
        multiplayer_writetempsound(local0\Field1, arg1, arg2, arg3, arg4, arg5)
    EndIf
    Return $00
End Function
