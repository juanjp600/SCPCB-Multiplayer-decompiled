Function zipapi_uncompressbank%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    If (arg0 = $00) Then
        Return $FFFFFFCE
    EndIf
    If (peekint(arg0, (banksize(arg0) - $08)) <> $9A24DE) Then
        Return $FFFFFFCE
    EndIf
    local0 = peekint(arg0, (banksize(arg0) - $04))
    local1 = createbank((banksize(arg0) - $08))
    copybank(arg0, $00, local1, $00, banksize(local1))
    local2 = zipapi_uncompress(local1, local0)
    freebank(local1)
    local1 = $00
    Return local2
    Return $00
End Function
