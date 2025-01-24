Function removespritetext%(arg0.spritefont)
    If (arg0 = Null) Then
        Return $00
    EndIf
    setfontex(fo\Field0[$00])
    freefont(arg0\Field1)
    arg0\Field1 = $00
    Delete arg0
    Return $00
End Function
