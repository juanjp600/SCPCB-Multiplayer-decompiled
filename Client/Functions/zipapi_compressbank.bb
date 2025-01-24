Function zipapi_compressbank%(arg0%, arg1%)
    Local local0%
    If (arg0 = $00) Then
        Return $FFFFFFCE
    EndIf
    local0 = zipapi_compress(arg0, arg1)
    If (local0 = $00) Then
        Return local0
    EndIf
    resizebank(local0, (banksize(local0) + $08))
    pokeint(local0, (banksize(local0) - $08), $9A24DE)
    pokeint(local0, (banksize(local0) - $04), banksize(arg0))
    Return local0
    Return $00
End Function
