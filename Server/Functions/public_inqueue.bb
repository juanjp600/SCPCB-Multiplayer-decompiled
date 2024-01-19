Function public_inqueue%(arg0%, arg1%)
    publics\Field0 = arg0
    publics\Field1 = $00
    If (arg1 <> 0) Then
        callback($00)
    EndIf
    Return $00
End Function
