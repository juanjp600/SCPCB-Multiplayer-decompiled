Function zipapi_uncompress%(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2%
    If (arg0 < $01) Then
        Return $FFFFFFCE
    EndIf
    If (banksize(arg0) < $01) Then
        Return $FFFFFFCE
    EndIf
    If (arg1 = $00) Then
        arg1 = (banksize(arg0) * $64)
    EndIf
    local0 = createbank(arg1)
    local2 = zlib_uncompress(local0, local1, arg0, banksize(arg0))
    If (local2 <> $00) Then
        freebank(local0)
        Return $00
    EndIf
    resizebank(local0, local1)
    Return local0
    Return $00
End Function
