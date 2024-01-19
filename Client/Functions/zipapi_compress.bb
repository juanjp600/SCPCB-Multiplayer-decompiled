Function zipapi_compress%(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2%
    If (arg0 = $00) Then
        Return $00
    EndIf
    If (banksize(arg0) < $01) Then
        Return $00
    EndIf
    If (arg1 < $01) Then
        arg1 = $01
    EndIf
    If (arg1 > $09) Then
        arg1 = $09
    EndIf
    local0 = createbank(zlibwapi_compressbound(banksize(arg0)))
    local1 = createbank($04)
    pokeint(local1, $00, banksize(local0))
    local2 = zlibwapi_compress2(local0, local1, arg0, banksize(arg0), arg1)
    If (local2 <> $00) Then
        freebank(local1)
        freebank(local0)
        Return $00
    EndIf
    resizebank(local0, peekint(local1, $00))
    freebank(local1)
    Return local0
    Return $00
End Function
