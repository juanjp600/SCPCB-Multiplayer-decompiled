Function removescreen%(arg0.screens)
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    If (arg0\Field2 <> $00) Then
        freeimage(arg0\Field2)
        arg0\Field2 = $00
    EndIf
    Delete arg0
    Return $00
End Function
