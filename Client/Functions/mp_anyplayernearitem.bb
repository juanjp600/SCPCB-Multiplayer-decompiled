Function mp_anyplayernearitem%(arg0.items)
    If (mp_ishoster() = $00) Then
        Return $00
    EndIf
    Return mp_anyplayernearentity(arg0\Field2, 64.0)
    Return $00
End Function
