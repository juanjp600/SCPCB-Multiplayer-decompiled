Function streamsound_strict%(arg0$, arg1#, arg2%)
    Local local0.stream
    If (filetype((lang\Field1 + arg0)) = $01) Then
        arg0 = (lang\Field1 + arg0)
    EndIf
    If (filetype(arg0) <> $01) Then
        openconsoleonerror(format(getlocalstring("runerr", "sound.notfound"), arg0, "%s"))
        Return $00
    EndIf
    local0 = (New stream)
    local0\Field0 = playmusic(arg0, arg1)
    If (local0\Field0 = $FFFFFFFF) Then
        openconsoleonerror(format(format(getlocalstring("runerr", "sound.stream.failed.n1"), arg0, "{0}"), (Str local0\Field0), "{1}"))
        Return $FFFFFFFF
    EndIf
    loopsound(local0\Field0, arg2)
    createsubtitlestoken(arg0, Null)
    Return (Handle local0)
    Return $00
End Function
