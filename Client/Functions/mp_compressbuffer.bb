Function mp_compressbuffer%(arg0.mp_netbuffer)
    Local local0%
    Local local1%
    Local local2%
    If (arg0\Field3 > $00) Then
        local0 = (arg0\Field3 - $01)
        local1 = createbank((arg0\Field2 - local0))
        copybank(arg0\Field0, local0, local1, $00, banksize(local1))
        local2 = zipapi_compressbank(local1, $01)
        If (local2 <> $00) Then
            copybank(local2, $00, arg0\Field0, local0, banksize(local2))
            arg0\Field2 = (banksize(local2) + local0)
            freebank(local2)
            local2 = $00
        EndIf
        freebank(local1)
        local1 = $00
        arg0\Field3 = $00
        Return (local2 <> $00)
    EndIf
    Return $00
    Return $00
End Function
