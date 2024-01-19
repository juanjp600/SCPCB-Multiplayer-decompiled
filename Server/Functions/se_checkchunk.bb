Function se_checkchunk%(arg0%)
    If (se_current_chunk\Field0 = arg0) Then
        Return $00
    Else
        se_error_unexpected(se_current_chunk\Field1)
        Return $01
    EndIf
    Return $00
End Function
