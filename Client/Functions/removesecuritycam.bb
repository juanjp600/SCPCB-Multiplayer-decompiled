Function removesecuritycam%(arg0.securitycams)
    If (arg0\Field3 <> $00) Then
        freeentity(arg0\Field3)
        arg0\Field3 = $00
    EndIf
    freeentity(arg0\Field1)
    arg0\Field1 = $00
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    If (arg0\Field5 <> 0) Then
        freeentity(arg0\Field2)
        arg0\Field2 = $00
        freeentity(arg0\Field7)
        arg0\Field7 = $00
        freeentity(arg0\Field4)
        arg0\Field4 = $00
        freeentity(arg0\Field6)
        arg0\Field6 = $00
    EndIf
    Delete arg0
    Return $00
End Function
