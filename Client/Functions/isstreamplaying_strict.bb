Function isstreamplaying_strict%(arg0%)
    Local local0.stream
    local0 = (Object.stream arg0)
    If (local0 = Null) Then
        openconsoleonerror(getlocalstring("runerr", "sound.stream.failed.find"))
        Return $00
    EndIf
    If (((local0\Field0 = $00) Lor (local0\Field0 = $FFFFFFFF)) <> 0) Then
        openconsoleonerror(format(getlocalstring("runerr", "sound.stream.failed.find.v"), (Str local0\Field0), "%s"))
        Return $00
    EndIf
    Return channelplaying(local0\Field0)
    Return $00
End Function
