Function mp_decompressbuffer%(arg0.mp_netbuffer)
    Local local0%
    Local local1%
    local0 = createbank(mp_getbufferavail(arg0))
    copybank(arg0\Field0, arg0\Field1, local0, $00, banksize(local0))
    local1 = zipapi_uncompressbank(local0)
    If (local1 <> $00) Then
        copybank(local1, $00, arg0\Field0, arg0\Field1, banksize(local1))
        arg0\Field2 = banksize(local1)
    EndIf
    freebank(local0)
    local0 = $00
    freebank(local1)
    local1 = $00
    Return $00
End Function
