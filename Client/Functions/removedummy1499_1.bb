Function removedummy1499_1%(arg0.dummy1499_1)
    If (arg0\Field1 <> $00) Then
        freeentity(arg0\Field1)
        arg0\Field1 = $00
    EndIf
    Delete arg0
    Return $00
End Function
