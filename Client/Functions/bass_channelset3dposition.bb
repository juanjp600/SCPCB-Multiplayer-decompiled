Function bass_channelset3dposition%(arg0%, arg1#, arg2#, arg3#)
    Local local0%
    Local local1%
    local0 = createbank($0C)
    pokefloat(local0, $00, arg1)
    pokefloat(local0, $04, arg2)
    pokefloat(local0, $08, arg3)
    local1 = bass_channelset3dposition_(arg0, local0, $00, $00)
    freebank(local0)
    local0 = $00
    Return local1
    Return $00
End Function
