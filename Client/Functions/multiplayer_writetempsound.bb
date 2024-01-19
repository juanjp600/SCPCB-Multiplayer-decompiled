Function multiplayer_writetempsound%(arg0$, arg1#, arg2#, arg3#, arg4#, arg5#)
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    udp_bytestreamwritechar($03)
    udp_bytestreamwriteline(arg0)
    udp_bytestreamwritefloat(arg4)
    udp_bytestreamwritefloat(arg5)
    udp_setmicrobyte($03)
    Return $00
End Function
