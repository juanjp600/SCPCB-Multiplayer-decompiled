Function bass_fxsetdistortion%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#)
    Local local0%
    Local local1%
    local0 = createbank($14)
    pokefloat(local0, $00, arg1)
    pokefloat(local0, $04, arg2)
    pokefloat(local0, $08, arg3)
    pokefloat(local0, $0C, arg4)
    pokefloat(local0, $10, arg5)
    local1 = bass_fxsetparameters(arg0, local0)
    freebank(local0)
    local0 = $00
    Return local1
    Return $00
End Function
